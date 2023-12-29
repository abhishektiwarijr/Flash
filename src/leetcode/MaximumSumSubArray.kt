package leetcode

fun main() {
    //Solution Pattern
    //1. Include the element in our running sub-array
    //2. Start a new sub-array
    println(maximumSumOfTheSubArrays(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4))) //6
    println(maximumSumOfTheSubArrays(intArrayOf(-2, -3, -1, 0, -1))) //0
}

fun maximumSumOfTheSubArrays(nums: IntArray): Int {
    var currentRunningSum = 0
    var maxSum = Int.MIN_VALUE

    for (num in nums) {
        //reset the current sum if it is less than 0
        // increment it by our current element
        currentRunningSum = Math.max(currentRunningSum, 0) + num

        //update the maximum sum
        maxSum = Math.max(maxSum, currentRunningSum)
    }

    return maxSum
}