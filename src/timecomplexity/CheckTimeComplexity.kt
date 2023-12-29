package timecomplexity

import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

fun main() {
    val time = measureNanoTime {
        val n = 100
        for(num in 0 until n) {
            if (num == n) {
                println("Never got here $num")
                break
            }
        }
    }
    println(time)
}