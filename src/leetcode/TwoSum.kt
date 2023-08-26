package leetcode

import java.util.TreeMap

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