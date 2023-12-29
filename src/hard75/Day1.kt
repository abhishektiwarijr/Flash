package hard75

/**
 * You have n tiles, where each tile has one letter tiles[i] printed on it.
 * Return the number of possible non-empty sequences of letters you can make
 * using the letters printed on those tiles
 *
 * e.g.
 * Input: tiles = "AAB"
 * Output: 8
 * Explanation: The possible sequences are - ["A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"]
 */
fun main() {
    val input = "AAB"
    println(countPossibleSequences(input)) //Output: 8
}

fun countPossibleSequences(tiles: String): Int {
    val sortedTiles = tiles.toCharArray().sorted().toCharArray()
    var count = 0
    fun backtrack(currSeq: String, remainingTiles: CharArray) {
        count++
        for (i in remainingTiles.indices) {
            if (i > 0 && remainingTiles[i] == remainingTiles[i - 1]) {
                continue
            }
            backtrack(currSeq + remainingTiles[i], remainingTiles.sliceArray(0 until i) + remainingTiles.sliceArray(i + 1 until remainingTiles.size))
        }
    }
    backtrack("", sortedTiles)
    return count
}
