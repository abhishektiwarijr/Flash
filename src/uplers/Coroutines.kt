package uplers


import kotlinx.coroutines.*
import java.io.Closeable

class AggregateUserDataUseCase(
    private val resolveCurrentUser: suspend () -> UserEntity,
    private val fetchUserComments: suspend (UserId) -> List<CommentEntity>,
    private val fetchSuggestedFriends: suspend (UserId) -> List<FriendEntity>
) : Closeable, AggregateUseCase {

    private val scope = CoroutineScope(Dispatchers.IO + Job())

    override suspend fun aggregateDataForCurrentUser(): AggregatedData {
        val user: UserEntity = scope.async { resolveCurrentUser() }.await()

        var userComments : List<CommentEntity>
        var suggestedFriends : List<FriendEntity>
        try {
            withTimeout(2000L) {
                userComments = scope.async { fetchUserComments(user.id) }.await()
                suggestedFriends = scope.async { fetchSuggestedFriends(user.id) }.await()
            }
        } catch (timeout: TimeoutCancellationException) {
            userComments = listOf<CommentEntity>()
            suggestedFriends = listOf<FriendEntity>()
        }

        return AggregatedData(
            user = user,
            comments = userComments,
            suggestedFriends = suggestedFriends
        )
    }

    override fun close() {
        scope.cancel()
    }
}

data class AggregatedData(
    val user: UserEntity,
    val comments: List<CommentEntity>,
    val suggestedFriends: List<FriendEntity>
)

typealias UserId = String

data class UserEntity(val id: UserId, val name: String)

data class CommentEntity(val id: String, val content: String)

data class FriendEntity(val id: String, val name: String)

interface AggregateUseCase {
    suspend fun aggregateDataForCurrentUser(): AggregatedData
}


fun main() : Unit = runBlocking {
    val aggregatedData = AggregateUserDataUseCase(
        resolveCurrentUser,
        fetchUserComments,
        fetchSuggestedFriends
    )

    println(aggregatedData.aggregateDataForCurrentUser())
    aggregatedData.close()
}

val resolveCurrentUser : suspend () -> UserEntity = {
    UserEntity("1", "A")
}

val fetchUserComments : suspend (userId : UserId) -> List<CommentEntity> = {
    delay(3000)
    listOf(
        CommentEntity("C1", "Comment1"),
        CommentEntity("C2", "Comment3"),
    )
}

val fetchSuggestedFriends : suspend (userId : UserId) -> List<FriendEntity> = {
    delay(3000)
    listOf(
        FriendEntity("F1", "John"),
        FriendEntity("F2", "Bob")
    )
}