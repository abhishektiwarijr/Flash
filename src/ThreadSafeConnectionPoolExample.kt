import java.sql.Connection
import java.sql.Driver
import java.sql.SQLException
import java.util.*
import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock


fun main() {
//    val connectionPool = ConnectionPoolImpl()
}

interface ConnectionPool {
    /**
     * Returns a connection from this pool if it is available
     * or throws SQLException when no connection available
     * @return connection from this pool
     * @throws SQLException thrown when connection is not available
     */
    @Throws(SQLException::class, InterruptedException::class)
    fun getConnection(): Connection?

    /**
     * Returns a connection from this pool if it is available
     * otherwise waits for no more than timeout milliseconds to get a connection
     * @param timeout timeout in milliseconds
     * @return connection from this pool is it becomes available within timeout milliseconds
     * @throws SQLException thrown when connection is not available
     */
    @Throws(SQLException::class, InterruptedException::class)
    fun getConnection(timeout: Long): Connection?

    /**
     * Returns connection to the pool
     * @param connection connection to be returned to the pool
     */
    fun releaseConnection(connection: Connection?)
}

class ConnectionPoolImpl @Throws(
    ClassNotFoundException::class,
    IllegalAccessException::class,
    InstantiationException::class
) constructor(
    driverClassName: String?,
    private var jdbcUrl: String?,
    private var username: String?,
    private var password: String?,
    private var maximumPoolSize: Int
) : ConnectionPool {
    private var driver: Driver? = null
    private var size = 0
    private var connections: Queue<Connection>? = null

    private val lock = ReentrantLock()
    private val condition = lock.newCondition()

    init {
        val c = Class.forName(driverClassName)
        driver = c.getDeclaredConstructor().newInstance() as Driver
        size = 0
        connections = LinkedList()
    }

    @Throws(SQLException::class, InterruptedException::class)
    override fun getConnection(): Connection? {
        return getConnection(0)
    }

    @Throws(SQLException::class)
    private fun createNewConnection(): Connection? {
        return try {
            val info = Properties()
            info["user"] = username
            info["password"] = password
            driver!!.connect(jdbcUrl, info)
        } catch (t: Throwable) {
            lock.withLock {
                size--
                condition.signalAll()
            }
            t.printStackTrace()
            throw SQLException("Connection not available", t)
        }
    }


    @Throws(SQLException::class, InterruptedException::class)
    override fun getConnection(timeout: Long): Connection? {
        val timestamp = System.currentTimeMillis() + timeout
        var createNewConnection = false
        lock.withLock {
            while (connections.isNullOrEmpty()) {
                if (size < maximumPoolSize) {
                    size++
                    createNewConnection = true
                    break
                } else {
                    condition.await(Math.max(timestamp - System.currentTimeMillis(), 1), TimeUnit.MILLISECONDS)
                    if (timestamp <= System.currentTimeMillis()) {
                        throw SQLException("Connection not available")
                    }
                }
            }
            if (!createNewConnection) {
                return connections?.poll()
            }
        }
        return createNewConnection()
    }

    override fun releaseConnection(connection: Connection?) {
        lock.withLock {
            connections?.offer(connection)
            condition.signalAll()
        }
    }
}