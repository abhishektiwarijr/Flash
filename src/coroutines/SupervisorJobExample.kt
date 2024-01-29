package coroutines

import kotlinx.coroutines.*

fun main() : Unit = runBlocking {
    val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        println("Exception caught: $exception")
    }
//    val supervisorJob = SupervisorJob()
//    val scope = CoroutineScope(coroutineContext + supervisorJob + exceptionHandler)
    val scope = supervisorScope {
        val job1 = launch {
            delay(1000L)
            println("Job 1 completed")
        }
        
        val job2 = launch {
            delay(500L)
            throw RuntimeException("Job 2 failed")
        }

        val job3 = launch {
            delay(2000L)
            println("Job 3 completed")
        }
    }

//    supervisorJob.join()
}

suspend fun getDataFromApi1() : String {
    return "Data"
}
suspend fun getDataFromApi2() {
    throw CancellationException()
}