fun main() {
    val sequence = "001001"
    val blocks = countBlocksOfOnes(sequence)
    println(blocks)
    val sequence2 = "11100101"
    val blocks2 = countBlocksOfOnes(sequence2)
    println(blocks2)
}

fun countBlocksOfOnes(seq: CharSequence): Int {
    val groups = mutableListOf<BinaryData>()
    seq.forEach {
        val last = groups.lastOrNull()
        if (last?.value == it) {
            last.count++
        } else {
            groups.add(BinaryData(it, 1))
        }
    }
    return groups.count { it.value == '1'}
}

data class BinaryData(val value: Char, var count: Int)
