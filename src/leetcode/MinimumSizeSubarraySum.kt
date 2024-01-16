package leetcode

fun main() {
    print(minimumSizeSubArraySum(intArrayOf(2, 3, 1, 2, 4, 3), target = 7))
}

fun minimumSizeSubArraySum(nums: IntArray, target: Int): Int {
    var result = Int.MAX_VALUE
    var sum = 0
    var left = 0

    for (i in nums.indices) {
        sum += nums[i]

        while (sum >= target) {
            result = Math.min(result, i - left + 1)
            sum -= nums[left++]
        }
    }

    return if(result == Int.MAX_VALUE) 0 else result
}
