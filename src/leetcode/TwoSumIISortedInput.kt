package leetcode

fun main() {
    println(
        twoSumSortedInput(
            nums = intArrayOf(1, 3, 4, 5, 7, 10, 11),
            target = 9
        ).contentToString()
    )
}

fun twoSumSortedInput(nums: IntArray, target: Int): IntArray {
    var left = 0
    var right = nums.size - 1

    while (left < right) {
        val currentSum = nums[left] + nums[right]
        if (currentSum > target) right--
        else if (currentSum < target) left++
        else return intArrayOf(left + 1, right + 1)
    }

    return intArrayOf()
}

fun twoSumSortedInputEff(nums: IntArray, target: Int): IntArray {
    var left = 0
    var right = nums.size - 1

    while (left <= right) {
        val mid = left + (right - left) / 2
        val value = nums[mid]
        if (value < target) {
            left = mid + 1
        } else if (value > target) {
            right = mid - 1
        } else {
            //found
        }
    }


//    while (left < right) {
//        val currentSum = nums[left] + nums[right]
//        if (currentSum > target) right--
//        else if (currentSum < target) left++
//        else return intArrayOf(left + 1, right + 1)
//    }

    return intArrayOf()
}
