import java.util.*
import kotlin.collections.ArrayDeque

fun main() {
    val a = intArrayOf(-1, 150, 190, 170, -1, -1, 160, 180)
//    println(solution(a).contentToString()) //[-1, 150, 160, 170, -1, -1, 180, 190]
    println(solution(a).contentToString()) //[-1, 150, 160, 170, -1, -1, 180, 190]
}

private fun solution(a: IntArray): IntArray {
    val nonMinusOneElements = a.filter { it != -1 }.sorted()

    var nonMinusOneIndex = 0
    val resultArray = IntArray(a.size) {
        if (a[it] == -1) {
            -1
        } else {
            nonMinusOneElements[nonMinusOneIndex++]
        }
    }

    return resultArray
}
