package leetcode

import kotlinquiz.lastIndex

fun main() {
    println(minimizeMax(intArrayOf(10, 1, 2, 7, 1, 3), 2)) //1
    println(minimizeMax(intArrayOf(4,2,1,2), 1)) //0
    println(minimizeMax(intArrayOf(3, 4, 1, 2, 1), 2)) //1
    println(minimizeMax(intArrayOf(8,9,1,5,4,3,6,4,3,7), 4)) //0
}

fun minimizeMax(nums: IntArray, p: Int): Int {

    fun canFormPairs(sNums: List<Int>, mid: Int, p: Int): Boolean {
        var cP = p
        var i = 1
        while (i < sNums.size) {
            if((sNums[i] - sNums[i-1]) <= mid){
                cP--
                i++
            }
            i++
        }
        return cP<=0
    }

    val sNums = nums.sorted()
    var left = 0
    var right = sNums.last() - sNums.first()
    var result = right

    while (left <= right) {
        val mid = (left + right) / 2
        if(canFormPairs(sNums, mid, p)) {
            result = mid
            right = mid - 1
        } else {
            left = mid + 1
        }
    }

    return result
}