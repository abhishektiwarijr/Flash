fun main() {
    println(search(intArrayOf(-1, 0, 3, 5, 9, 12), 9))
}

fun search(nums: IntArray, target: Int): Int {
    var lb = 0
    var ub = nums.lastIndex

    while (lb <= ub) {
        val mid = lb + (ub - lb) / 2
        if (nums[mid] == target) {
            return mid
        }

        if (nums[mid] < target) {
            lb = mid + 1
        } else {
            ub = mid - 1
        }
    }
    return -1
}