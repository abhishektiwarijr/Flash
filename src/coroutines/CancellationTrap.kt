package coroutines

import kotlinx.coroutines.*

fun main() {


    `runs forever`()
//    `stops after cancellation`()
}

private fun `runs forever`() = runBlocking {
    var counter = 0
    val job = launch {
        while (true) {
//            if(isActive.not()) {
//                throw CancellationException()
//            }
//            ensureActive()
            println(counter)
            counter++
        }
    }
    delay(1000)
    job.cancelAndJoin()
}

private fun `stops after cancellation`() = runBlocking {
    var counter = 0
    val job = launch {
        while (true) {
            delay(10)
            println(counter)
            counter++
        }
    }
    delay(1000)
    job.cancelAndJoin()
}

