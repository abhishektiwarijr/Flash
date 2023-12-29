package test

import kotlin.concurrent.thread

fun main() {
    try {
        val th = thread {
            println("Begin")
            Thread.sleep(1000L)
            println("Begin.")
            Thread.sleep(1000L)
            println("Begin..")
            Thread.sleep(1000L)
            println("Begin...")
            Thread.sleep(3000L)
        }
        th.start()
        Thread.sleep(4000L)
        th.interrupt()
    } catch (e : Exception) {
        e.printStackTrace()
    }



}