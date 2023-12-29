package leetcode

/**
 * Dynamic size sliding window
 */
fun main() {
    println(subArraySumEqualsKNonEfficient(nums = intArrayOf(1, 1, 1), k = 2))
    println(subArraySumEqualsKNonEfficient(nums = intArrayOf(1, 2, 3, 6), k = 6))
}

fun subArraySumEqualsKEfficient(nums: IntArray, k: Int): Int {
    var subArraySumEqualsKCount = 0

    return subArraySumEqualsKCount
}

fun subArraySumEqualsKNonEfficient(nums: IntArray, k: Int): Int {
    var subArraySumEqualsKCount = 0

    for (i in 0..nums.lastIndex) {
        var currentSum = nums[i]
        if(currentSum == k) {
            subArraySumEqualsKCount++
            continue
        }

        for(j in (i+1)..nums.lastIndex) {
            currentSum += nums[j]
            if(currentSum == k) {
                subArraySumEqualsKCount++
                break
            }
        }
    }


    return subArraySumEqualsKCount
}
