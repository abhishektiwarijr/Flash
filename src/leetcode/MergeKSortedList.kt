package leetcode

fun main() {
    val input = listOf(
        intArrayOf(1, 4, 5),
        intArrayOf(1, 3, 4),
        intArrayOf(2, 6)
    )
    val expectedOutput = intArrayOf(1, 1, 2, 3, 4, 4, 5, 6)
    val actualOutput = mergeKSortedList(input)
    println(expectedOutput.equals(actualOutput))
}

fun mergeKSortedList(input: List<IntArray>) : List<Int> {
    //Lame solution
    //1. Add all items in a single list
    //2. then sort it Big O(n^2)

    //TODO
    //Efficient Solution
    val result = mutableListOf<Int>()
    val minHeap = mutableListOf<Int>()
    //TODO
    return listOf()
}