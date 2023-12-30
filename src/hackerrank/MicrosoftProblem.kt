package hackerrank

import java.util.*


/**
 * Given an unsorted integer array find the indices of the two integers
 * such that Arr[j] > Arr[i] and i< j.
 *
 */
fun main() {
    val nums = intArrayOf(7, 9, 5, 6, 3, 2)
//    val nums = intArrayOf(Integer.MIN_VALUE, Integer.MAX_VALUE)
    println(nextLargest(nums = nums))
//    println(countArr(arr = nums))
}

fun findIndices(nums : IntArray) : Int {
    var i = 0
    var j = 1

    var indicesCount = 0
    while (j < nums.size) {
        if(nums[j] > nums[i] && i < j){
            indicesCount++
        }
        i++
        j++
    }

    return indicesCount
}

fun countArr(arr: IntArray): Int {
    var count = 0
    for (i in arr.indices) {
        var j = arr.size - 1
        while (j > i) {
            if (arr[j] > arr[i]) {
                count++
            }
            j--
        }
    }
    return count
}

fun nextLargest(nums: IntArray): Int {
    val stack = Stack<Int>()
    var res = 0

    for (i in nums.lastIndex downTo 0) {
        while (stack.isNotEmpty() && nums[stack.peek()] < nums[i]) stack.pop()
        if(stack.isNotEmpty()) res++
        stack.add(i)
    }

    return res
}
