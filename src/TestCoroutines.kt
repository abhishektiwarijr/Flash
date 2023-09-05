import kotlinx.coroutines.*
import java.lang.IllegalArgumentException
import kotlin.concurrent.thread
import kotlin.coroutines.CoroutineContext

fun main() {
//    coroutineJob()
//    coroutineSupervisorJob()
//    coroutineHuge()
//    threadHuge()
    coroutineSupervisorJob()
}

fun coroutineJob() = runBlocking {
    val job = launch {
        delay(1000L)
        println("Coroutine completed")
    }
    println("Waiting for coroutine to finish")
    job.join()
    println("Coroutine has finished")
}

fun coroutineSupervisorJob() = runBlocking {
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("Exception caught: $throwable")
    }

    val supervisorJob = SupervisorJob()
    val scope = CoroutineScope(coroutineContext + supervisorJob + exceptionHandler)

    val job1 = scope.launch {
        delay(1000L)
        println("Job 1 completed")
    }

    val job2 = scope.launch {
        delay(500L)
        throw RuntimeException("Job 2 failed")
    }

    val job3 = scope.launch {
        delay(2000L)
        println("Job 3 completed")
    }

    joinAll(job1, job2, job3) //or supervisorJob.join()
}

fun coroutineHuge() = runBlocking {
    repeat(100_000) {
        launch {
            println(it)
        }
    }
}

fun threadHuge() {
    repeat(100_000_000) {
        thread {
            println(it)
        }
    }
}