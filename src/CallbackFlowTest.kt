import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    getFragmentResumeListener().collect { isVisible ->
        println(isVisible)
    }
}

private fun getFragmentResumeListener(): Flow<Boolean> {
    return callbackFlow<Boolean> {
        val onFragmentResumeListener = object : OnFragmentResumeListener {
            override fun onFragmentResume() {
                trySend(true)
            }
        }

//        ActivityX.registerForFragmentResume(onFragmentResumeListener)

        awaitClose {
//            ActivityX.unregisterForFragmentResume(onFragmentResumeListener)
        }
    }
}

interface OnFragmentResumeListener {
    fun onFragmentResume()
}