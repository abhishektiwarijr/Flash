package leetcode

import java.util.*

fun main() {
//    Output: [[-1,-1,2],[-1,0,1]]
    println(threeSumNew(intArrayOf(-1, 0, 1, 2, -1, -4), 0))
}

fun threeSum(arr: IntArray, target: Int): List<List<Int>> {
    val sArr = arr.sortedArray()
    val result = LinkedList<List<Int>>()
    for (i in 0 until sArr.lastIndex) {
        if (i == 0 || (sArr[i] != sArr[i - 1])) {
            var low = i + 1
            var high = sArr.lastIndex
            val sum = 0 - sArr[i]
            while (low < high) {
                if (sArr[low] + sArr[high] == sum) {
                    result.add(listOf(sArr[i], sArr[low], sArr[high]))
                    while (low < high && sArr[low] == sArr[low + 1]) low++
                    while (low < high && sArr[high] == sArr[high - 1]) high--
                    low++
                    high--
                } else if (sArr[low] + sArr[high] > sum) {
                    high--
                } else {
                    low++
                }
            }
        }
    }
    return result
}


fun threeSumNew(arr: IntArray, target: Int): List<List<Int>> {
    //Bound check
    if (arr.size < 3) return emptyList()

    //Sort
    arr.sort()

    val result = HashSet<List<Int>>()

    //Now pick one
    for (i in 0 until arr.lastIndex) {
        val first = arr[i]

        //Find other two using 2Sum
        var left = i + 1
        var right = arr.lastIndex

        while (left < right) {
            val sum = first + arr[left] + arr[right]
            if (sum == target) {
                //Add the triplets in the result array
                result.add(listOf(first, arr[left], arr[right]))
                left++
                right--
            } else if (sum > target) {
                right--
            } else {
                left++
            }
        }
    }

    return ArrayList(result)
}