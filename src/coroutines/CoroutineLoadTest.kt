package coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.math.log
import kotlin.system.measureTimeMillis
import kotlin.time.Duration.Companion.seconds

//fun main() {
////    `creating 10k threads`()
////    `creating 100k corutines`()
//    runBlocking {
//        val cf = coldFlow()
//        cf.collect {
//            println("First collector : Collected $it")
//        }
//        cf.collect {
//            println("Second collector : Collected $it")
//        }
//    }
//}

fun main() {
    
    fun isPowerOf3(n : Int) : Boolean {
        var cn = n
        while (cn % 3 == 0) {
            cn /= 3
        }
        return cn == 1
    }
    println(isPowerOf3(45))
}

fun `creating 10k threads`() {
    val time = measureTimeMillis {
        for(i in 1..10_000) {
            Thread {
                Thread.sleep(1)
            }.start()
        }
    }
    println(time)
}

fun `creating 100k corutines`() {
    val time = measureTimeMillis {
        runBlocking {
            for (i in 1..100_000) {
                launch {
                    delay(10.seconds)
                }
            }
        }
    }
    println(time)
}

fun coldFlow() = flow<Int> {
    var num = 1
    while (num < 11) {
        delay(1000L)
        emit(num++)
    }
}
