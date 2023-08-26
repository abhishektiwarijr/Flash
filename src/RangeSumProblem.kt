fun main() {
    val rsq = RangeSum(intArrayOf(1, 3, -2, 4, 2))
    println(rsq.getSum(0, 1)) //1L
    println(rsq.getSum(0, 5)) //8L
    println(rsq.getSum(2, 2)) //0L
    println(rsq.getSum(2, 3)) //-2L
    println(rsq.getSum(2, 5)) //4L
    println(rsq.getSum(1, 4)) //5
    println(rsq.getSum(0, 0)) //0
    println(rsq.getSum(4, 5)) //2
}

class RangeSum(a: IntArray) {
    // Implement additional fields and method here
    private val prefix = LongArray(a.size) { a[it].toLong() }
    init {
        for (i in prefix.indices.drop(1)) {
            prefix[i] += prefix[i - 1]
        }
    }

    fun getSum(left: Int, right: Int): Long {
        return get(right - 1) - get(left - 1)
    }

    private fun get(index: Int): Long {
        return when (index) {
            -1 -> 0
            else -> prefix[index]
        }
    }
}

