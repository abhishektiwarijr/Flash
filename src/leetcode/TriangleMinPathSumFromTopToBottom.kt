package leetcode

/**
 * "Triangle" - Involves finding the minimum path sum from the top to the bottom of a triangle
 * Each step can move to the adjacent numbers on the row below
 */
fun main() {
    //Solution approach - Dynamic Programming

    println(
        minimumPathSum(
            listOf(
                intArrayOf(2),
                intArrayOf(3, 4),
                intArrayOf(6, 5, 7),
                intArrayOf(4, 1, 8, 3)
            )
        )
    )
}

fun minimumPathSum(triangle: List<IntArray>): Int {
    return minPathSumHelper(0, 0, triangle)
}

fun minPathSumHelper(row: Int, col: Int, triangle: List<IntArray>): Int {
    if (row >= triangle.size) return 0

    val pathSum1 = minPathSumHelper(row + 1, col, triangle)
    val pathSum2 = minPathSumHelper(row + 1, col + 1, triangle)

    return Math.min(pathSum1, pathSum2) + triangle[row][col]
}
