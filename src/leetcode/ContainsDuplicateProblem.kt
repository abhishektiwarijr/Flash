package leetcode

import kotlin.math.max

fun main() {
    println(containsDuplicate(intArrayOf(1, 2, 3, 1)))
    println(containsDuplicate(intArrayOf(1, 2, 3, 4)))
    println(containsDuplicate(intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)))

    println(containsDuplicateII(intArrayOf(1, 2, 3, 1), k = 3)) //true
    println(containsDuplicateII(intArrayOf(1, 0, 1, 1), k = 1)) //true
    println(containsDuplicateII(intArrayOf(1, 2, 3, 1, 2, 3), k = 2)) //false
}

private fun containsDuplicateII(nums : IntArray, k : Int) : Boolean {
    val table = hashMapOf<Int, Int>()

    //if current number is in table then check for distance
    //else keep putting number in the table
    for (i in 0..nums.lastIndex) {
        if(table.contains(nums[i])) {
            val distance = (i - table[nums[i]]!!)
            if(distance <= k) {
                return true
            }
        }
        table[nums[i]] = i
    }

    return false
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