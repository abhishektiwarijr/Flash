package leetcode

fun main() {
    //Solution Approach
    //1. HashMap, HashSet approach - Consumes more memory
    //2. XOR operation
    println(
        findTheSingleNumberInAnArrayWithAllElementsTwiceExceptOne(
            intArrayOf(4, 1, 2, 1, 2)
        )
    )

    println(
        findTheSingleNumberInAnArrayWithAllElementsTwiceExceptOneOptimized(
            intArrayOf(4, 1, 2, 1, 2)
        )
    )
}

fun findTheSingleNumberInAnArrayWithAllElementsTwiceExceptOneOptimized(nums: IntArray): Int {
    var singleNumber = 0
    for (num in nums) {
        singleNumber = singleNumber xor num
    }
    return singleNumber
}

fun findTheSingleNumberInAnArrayWithAllElementsTwiceExceptOne(nums: IntArray): Int {
    val setToTrackSingleNumber = hashSetOf<Int>()
    for (num in nums) {
        if (setToTrackSingleNumber.contains(num)) {
            setToTrackSingleNumber.remove(num)
        } else {
            setToTrackSingleNumber.add(num)
        }
    }
    return setToTrackSingleNumber.first()
}

