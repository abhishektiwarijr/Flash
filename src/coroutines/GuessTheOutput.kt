package coroutines

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
//    coroutineDilemma1()
    coroutineDilemma2()
}

fun coroutineDilemma1(): Unit = runBlocking {
    //Here, The Job() is explicitly passed to the launch coroutine builder,
    //indicating that the coroutine will have a separate job.
    //However, there's a potential issue with this code.
    //If you don't keep the reference to the Job object returned by launch,
    //the runBlocking will not wait for the coroutine to complete,
    //and the program might exit before the coroutine has a chance to print the message.

    launch(Job()) {
        delay(1000L)
        println("Will I be printed?")
    }

    launch {
        delay(2000)
    }

    //Solution
//    val job = launch(Job()) {
//        delay(1000L)
//        println("Will I be printed?")
//    }
//    job.join()
}



fun coroutineDilemma2(): Unit = runBlocking {
    launch(Job()) {
        delay(2000L)
        println("Will I be printed?")
    }

    launch(Job()) {
        delay(2000)
        println("Now me")
    }
}