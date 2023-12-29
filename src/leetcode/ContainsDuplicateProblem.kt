package leetcode

import kotlin.math.max

fun main() {
    println(containsDuplicate(intArrayOf(1, 2, 3, 1)))
    println(containsDuplicate(intArrayOf(1, 2, 3, 4)))
    println(containsDuplicate(intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)))
}

private fun containsDuplicate(nums: IntArray): Boolean {
    val lookUp = hashSetOf<Int>()
    for (num in nums) {
        if (lookUp.contains(num)) {
            return true
        }
        lookUp.add(num)
    }
    return false
}

private fun lengthOfLongestSubstringFast(str: String): Int {
    var maxLength = 0
    var right = 0
    var left = 0
    while (right < str.length) {
        val indexOfFirstAppearanceInSubString = str.indexOf(str[right], left)
        if (indexOfFirstAppearanceInSubString != right) {
            left = indexOfFirstAppearanceInSubString + 1
        }
        maxLength = max(maxLength.toDouble(), (right - left + 1).toDouble()).toInt()
        right++
    }
    return maxLength
}