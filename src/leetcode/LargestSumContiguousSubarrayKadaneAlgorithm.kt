package leetcode

fun main() {
    println(
        `Kadene's algorithm - Largest Sum Contiguous Subarray (Kadane's Algorithm)`(
            intArrayOf(-2, -3, 4, -1, -2, 1, 5, -3)
        )
    )
}

fun `Kadene's algorithm - Largest Sum Contiguous Subarray (Kadane's Algorithm)`(nums: IntArray) : Int {
    var maxSum = 0
    var currSumSoFar = 0
    for (i in 0..nums.lastIndex) {
        currSumSoFar += nums[i]

        if(currSumSoFar > maxSum) {
            maxSum = currSumSoFar
        }

        if(currSumSoFar < 0) {
            currSumSoFar = 0
        }
    }
    return maxSum
}