package leetcode

fun main() {
    val set = ArrayList<Int>()
    set.add(1)
    set.add(2)
    set.add(3)

    println(set)

//    val nums = intArrayOf(1, 1, 1, 2, 2, 3)
//    println(topKFrequent(nums = nums, k = 2).contentToString())
}

fun topKFrequentElement(nums: IntArray, k: Int): IntArray {
    val countMap = HashMap<Int, Int>()
    val freq = Array(nums.size + 1) { ArrayList<Int>() }

    for (n in nums) {
        countMap[n] = 1 + countMap.getOrDefault(n, 0)
    }

    for ((n, c) in countMap) {
        freq[c].add(n)
    }

    val result = arrayListOf<Int>()

    for (i in freq.lastIndex downTo 0) {
        for (n in freq[i]) {
            result.add(n)
            if (result.size == k) {
                return result.toIntArray()
            }
        }
    }

    return intArrayOf()
}

/**
 * Time complexity: O(nlog(n))
 * Space complexity: O(n)
 */
fun topKFrequent(nums: IntArray, k: Int): IntArray =
    nums.asSequence()
        .groupingBy { it }
        .eachCount()
        .asSequence()
        .sortedByDescending { it.value }
        .map { it.key }
        .take(k)
        .toList()
        .toIntArray()

