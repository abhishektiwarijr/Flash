package leetcode

/**
 * The four for loops print elements in a spiral pattern, moving clockwise:
 * Top row from left to right.
 * Right column from top to bottom.
 * Bottom row from right to left (if any).
 * Left column from bottom to top (if any).
 *
 * After each layer, the boundaries are adjusted to exclude the traversed elements.
 * The time complexity is O(m * n), where m is the number of rows and n is the number of columns.
 * The space complexity is O(1), as it uses a constant amount of extra space.
 */
fun main() {
    val matrix = arrayOf<IntArray>(
        intArrayOf(1, 1, 1, 1, 1),
        intArrayOf(1, 1, 1, 1, 1),
        intArrayOf(1, 1, 1, 1, 1),
        intArrayOf(1, 1, 1, 1, 1),
        intArrayOf(1, 1, 1, 1, 1),
    )


    //traverse every index spirally and make them 0
    val rows = matrix.size
    val columns = matrix[0].size
    var top = 0
    var left = 0
    var right = columns - 1
    var bottom = rows - 1

    while (top <= bottom && left <= right) {
        //Print top row from left to right
        for (i in left..right) {
            matrix[top][i] = 0
        }
        top++

        //Print right column from top to bottom
        for (i in top..bottom) {
            matrix[i][right] = 0
        }
        right--

        // Print bottom row from right to left (if any)
        if (top <= bottom) {
            for (i in right downTo left) {
                matrix[bottom][i] = 0
            }
            bottom--
        }

        // Print left column from bottom to top (if any)
        if (left <= right) {
            for (i in bottom downTo top) {
                matrix[i][left] = 0
            }
            left++
        }
    }

    for (i in 0 until rows) {
        println(matrix[i].joinToString(",", "[", "]"))
    }
}