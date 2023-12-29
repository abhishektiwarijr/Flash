package leetcode

fun main() {
//    println(findDuplicateSlowMoreMemory(intArrayOf(1,3,4,2,2))) //2
    println(findDuplicateEfficient(intArrayOf(3,1,3,4,2))) //3
}

fun findDuplicateSlowMoreMemory(nums: IntArray): Int {
    val lookUp = hashMapOf<Int, Int>()
    for (i in 0..nums.lastIndex) {
        if(lookUp.contains(nums[i])) {
            return nums[i]
        }
        lookUp[nums[i]] = i
    }
    return -1
}

fun findDuplicateEfficient(nums: IntArray): Int {
    for (i in 0..nums.lastIndex) {
        if (nums[Math.abs(nums[i])] < 0) {
            return Math.abs(nums[i])
        } else {
            nums[Math.abs(nums[i])] = nums[Math.abs(nums[i])] * -1
        }
    }
    return -1
}
fun findDuplicateAverage(nums: IntArray): Int {
    var slow = nums[0]
    var fast = nums[0]

    // Phase 1: Find the intersection point in the cycle
    do {
        slow = nums[slow]
        fast = nums[nums[fast]]
    } while (slow != fast)

    // Phase 2: Find the "entrance" to the cycle
    slow = nums[0]
    while (slow != fast) {
        slow = nums[slow]
        fast = nums[fast]
    }

    return slow
}

