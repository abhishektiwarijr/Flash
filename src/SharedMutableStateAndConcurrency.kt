import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.system.measureTimeMillis

var counter = 0
fun main() = runBlocking {
//    val parallelism = Runtime.getRuntime().availableProcessors().coerceAtLeast(1)
    val mutex = Mutex()
    val coroutineContext = newSingleThreadContext("CoroutineContext")
    // confine everything to a single-threaded context
    withContext(Dispatchers.Default) {
        massiveRun {
            // confine each increment to a single-threaded context
//            withContext(coroutineContext) {
            mutex.withLock { // protect each increment with lock
                counter++
            }
//            }
        }
    }
    println("Counter is $counter")
}

suspend fun massiveRun(action: suspend () -> Unit) {
    val n = 1000 //no of coroutines
    val k = 1000 //no of times an action is repeated by each coroutine

    val time = measureTimeMillis {
        coroutineScope {
            repeat(n) {
                launch {
                    repeat(k) {
                        action()
                    }
                }
            }
        }
    }
    println("Completed ${n * k} actions in $time ms")
}