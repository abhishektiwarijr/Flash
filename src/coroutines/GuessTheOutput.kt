package coroutines

import kotlinx.coroutines.*

interface EnumInterface {
    fun onClick()
}

enum class GuessTheOutput : EnumInterface {
    ONE {
        override fun onClick() {

        }
    },
    TWO {
        override fun onClick() {

        }
    },
    THREE {
        override fun onClick() {

        }
    }
}

fun main() : Unit = runBlocking {
    val job = launch {
        println("Default: ${Thread.currentThread().name}")
        delay(1000)
        println("Will I be printed?")
    }
    job.join()
    launch {
        println("I am called")
    }
//    coroutineDilemma1()
//    coroutineDilemma2()
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
        delay(1000)
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