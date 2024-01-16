package leetcode

fun main() {
    val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    val k = 5
    rotateAnArrayByK(nums = nums, k = k)
    println(nums.joinToString(",", "[", "]"))
}

fun rotateAnArrayByK(nums: IntArray, k: Int) {
    val n = nums.size
    if (k % n == 0) {
        //no rotation
        return
    }

    fun reverse(nums: IntArray, start: Int, end: Int) {
        var left = start
        var right = end
        while (left < right) {
            nums[left] = nums[right].also { nums[right] = nums[left] }
            left++
            right--
        }
    }

    val nK = k % n
    //1. Reverse the whole array
    reverse(nums, start = 0, end = n - 1)
    //2. Reverse the first k elements
    reverse(nums, 0, nK - 1)
    //3. Reverse the remaining elements
    reverse(nums, nK, n - 1)
}

fun reverseAnArrayByKCyclicReplacements(nums: IntArray, k: Int) {
    val n = nums.size
    if(k % n == 0) return
    val nk = k % n

//    for (i in 0 until n - nk - 1) {
//        val first = nums[i]
//        val second = nums[i + nk]
//        val third = nums[]
//    }
}