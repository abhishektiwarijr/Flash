package coroutines

import kotlinx.coroutines.*
import kotlin.coroutines.Continuation

fun main() = runBlocking {
//    doWorld()
//    println("Done")

    val jobs = List(100_000) {
        launch {
            delay(1000L)
            println(".")
        }
    }
    jobs.forEach {job->
        job.join()
    }
}

// Concurrently executes both sections
suspend fun doWorld() = coroutineScope {
    // launch a new coroutine and continue
    launch {
        println("Before World 2")
        delay(2000L) // non-blocking delay for 1 second (default time unit is ms)
        println("World 2")
    }

    launch {
        println("Before World 1")
        delay(1000L)
        println("World 1")
    }

    println("Hello") // main coroutine continues while a previous one is delayed
}