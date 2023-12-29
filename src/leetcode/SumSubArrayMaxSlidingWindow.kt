package leetcode

import java.util.*


fun main() {
//    println(maxSlidingWindow(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3).contentToString()) //[3,3,5,5,6,7]
//    println(sumSubArrayNonEfficient(intArrayOf(1, 2, 3, 4, 5, 6), 3)) //[3,3,5,5,6,7]
//    println(sumSubArray(intArrayOf(1, 2, 3, 4, 5, 6), 3)) //[3,3,5,5,6,7]
    println(sumSubArrayEff(intArrayOf(1, 2, 3, 4, 5, 6), 3)) //[3,3,5,5,6,7]
}

fun sumSubArrayNonEfficient(input: IntArray, k: Int): Int {
    var left = 0
    var right = k - 1
    var resultSum = 0

    while (right < input.size) {
        var subArraySum = 0
        for (i in left..right) {
            subArraySum += input[i]
        }
        resultSum += subArraySum
        left++
        right++
    }

    return resultSum
}

fun sumSubArrayEff(input: IntArray, k: Int): List<Int> {
    val resultSum = mutableListOf<Int>()

    //Sum up the first sub-array and add it to result
    var currentSubArraySum = 0
    for (i in 0 until k) {
        currentSubArraySum += input[i]
    }
    resultSum.add(currentSubArraySum)

    for (i in 1 .. input.size - k) {
        currentSubArraySum = currentSubArraySum - input[i - 1] + input[i + k - 1]
        resultSum.add(currentSubArraySum)
    }

    return resultSum
}


fun sumSubArray(input: IntArray, k: Int): Int {
    var left = 0
    var right = k - 1
    var resultSum = 0

    var previousSubArraySum = 0
    for (i in left..right) {
        previousSubArraySum += input[i]
    }

    resultSum = previousSubArraySum
    right++

    while (right < input.size) {
        //keeping track of first item of previous window
        previousSubArraySum = previousSubArraySum - input[left] + input[right]
        resultSum += previousSubArraySum
        left++
        right++
    }

    return resultSum
}

fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    if (nums.isEmpty() || k == 0) return intArrayOf()
    val result = IntArray(nums.size - k + 1)
    val deque = ArrayDeque<Int>()

    for (i in nums.indices) {
        // Remove elements that are out of the current window
        while (deque.isNotEmpty() && deque.peek() < i - k + 1) {
            deque.poll()
        }

        // Remove elements that are smaller than the current element
        while (deque.isNotEmpty() && nums[deque.peekLast()] < nums[i]) {
            deque.pollLast()
        }

        // Add the current index to the deque
        deque.offer(i)

        if (i >= k - 1) {
            result[i - k + 1] = nums[deque.peek()]
        }
    }

    return result
}

