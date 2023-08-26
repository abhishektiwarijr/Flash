import kotlin.math.sin

fun main() {
//    println(doubleArrayOf(1.0,1.0,1.0,3.0,5.0,9.0,17.0,31.0,57.0,105.0).size)
//    println(tribonacci(doubleArrayOf(1.0, 1.0, 1.0), 10).joinToString(","))
    println(tribonacciEff4(doubleArrayOf(1.0, 1.0, 1.0), 10).joinToString(","))
}

fun tribonacci(signature: DoubleArray, n: Int): DoubleArray {
    val result = mutableListOf<Double>()
    result.add(signature[0])
    result.add(signature[1])
    result.add(signature[2])
    var i = 0
    var j = 1
    var k = 2
    while (result.size <= n - 1) {
        result.add(result[i] + result[j] + result[k])
        i++
        j++
        k++
    }
    return result.toDoubleArray()
}

fun tribonacciEff2(signature: DoubleArray, n: Int) =
    generateSequence(Triple(signature[0], signature[1], signature[2])) {
        Triple(it.second, it.third, it.first + it.second + it.third)
    }.map { it.first }
        .take(n)
        .toList()
        .toDoubleArray()

fun tribonacciEff(signature: DoubleArray, n: Int) = DoubleArray(n).also {
    for (i in 0 until n) {
        it[i] = if (i < signature.size) signature[i] else it[i - 3] + it[i - 2] + it[i - 1]
    }
}


fun tribonacciEff3(signature: DoubleArray, n: Int) =
    signature.toMutableList().apply {
        repeat(n) {
            add(takeLast(3).sum())
        }
    }.take(n).toDoubleArray()

fun tribonacciEff4(signature: DoubleArray, n: Int) =
    signature.toMutableList().apply {
        repeat(n-3) {
            add(takeLast(3).sum())
        }
    }.toDoubleArray()
