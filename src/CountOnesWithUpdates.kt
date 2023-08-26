fun main() {
    val sequence = "001001"
    val blocks = CountOnesWithUpdates(sequence)
    println(blocks.countOnes())
    blocks.flip(0)
    println(blocks.countOnes())
    blocks.flip(1)
    println(blocks.countOnes())
    blocks.flip(2)
    println(blocks.countOnes())
}

class CountOnesWithUpdates(seq: CharSequence) {
    private val binStr: MutableList<Char>
    private var onesCount = -1
    init {
        binStr = seq.toMutableList()
        onesCount = seq.count { it == '1' }
    }

    fun countOnes(): Int {
        return onesCount
    }

    fun flip(index: Int) {
        if (binStr[index] == '1') {
            onesCount--
            binStr[index] = '0'
        } else {
            onesCount++
            binStr[index] = '1'
        }
    }
}
