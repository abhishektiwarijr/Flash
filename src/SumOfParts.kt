import kotlin.system.measureTimeMillis

fun main() {
//    println(sumParts(intArrayOf()).contentToString())
//    println(sumParts(intArrayOf(0, 1, 3, 6, 10)).contentToString())
//    println(sumParts(intArrayOf(1, 2, 3, 4, 5, 6)).contentToString())
//    println(sumParts(intArrayOf(744125, 935, 407, 454, 430, 90, 144, 6710213, 889, 810, 2579358)).contentToString())

    val mt = measureTimeMillis {  sumParts(intArrayOf(744125, 935, 407, 454, 430, 90, 144, 6710213, 889, 810, 2579358)) }
    val ot = measureTimeMillis {  sumParts2(intArrayOf(744125, 935, 407, 454, 430, 90, 144, 6710213, 889, 810, 2579358)) }
    println(mt)
    println(ot)
}

fun sumParts(ls: IntArray): IntArray {
    var sum = 0
    val result = IntArray(ls.size + 1) { 0 }
    for (i in ls.indices.reversed()) {
        sum += ls[i]
        result[i] = sum
    }
    return result
}

fun sumParts2(ls: IntArray): IntArray {
    val result = IntArray(ls.size + 1)
    for (i in ls.indices.reversed()) {
        result[i] = result[i + 1] + ls[i]
    }
    return result
}