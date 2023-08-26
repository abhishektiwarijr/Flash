fun main() {
    var a = arrayOf(intArrayOf(1, 2), intArrayOf(2, 9), intArrayOf(3, 18), intArrayOf(4, 24), intArrayOf(6, 48))
    println(SumFractions.sumFracts(a))
    a = arrayOf(intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(1, 4))
    println(SumFractions.sumFracts(a))
    a = arrayOf()
    println(SumFractions.sumFracts(a))
}

object SumFractions {
    fun sumFracts(l: Array<IntArray>): String {
        return ""
    }
}