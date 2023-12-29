package leetcode

import java.util.*
import kotlin.math.max

fun main() {
    println(twoSum(intArrayOf(2,7,11,15), 9).contentToString())
    println(twoSum(intArrayOf(3,2,4), 6).contentToString())
    println(twoSum(intArrayOf(3,3), 6).contentToString())
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val numMap = TreeMap<Int, Int>()

    nums.forEachIndexed { i, n ->
        if((target - n) in numMap) {
            return intArrayOf(numMap[target - n]!!, i)
        } else {
            numMap[n] = i
        }
    }

    return intArrayOf()
}

private fun lengthOfLongestSubstringFast(s: String): Int {
    val visitedChars = mutableMapOf<Char, Int>()
    var maxLength = 0
    var start = 0

    for (end in s.indices) {
        val char = s[end]
        if (visitedChars.containsKey(char)) {
            start = maxOf(start, visitedChars[char]!! + 1)
        }
        visitedChars[char] = end
        maxLength = maxOf(maxLength, end - start + 1)
    }

    return maxLength
}