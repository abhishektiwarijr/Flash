import java.math.BigInteger

fun main() {
    var lst = arrayOf(longArrayOf(1, 2), longArrayOf(1, 3), longArrayOf(1, 4))
//    testing(lst, "(6,12)(4,12)(3,12)")
    println(convertFrac(lst))
}

fun convertFrac(lst: Array<LongArray>): String {
    val d = lst.fold(1L) { mul, item -> mul * item.last() }
    return lst.sumOf { it.last() }.toString()
}

//fun main(args: Array<String>) {
//
//    println(listOf(1, 2, 3, 4, 5).fold(0) { total, item -> total + item })
//    // 15
//
//    println(listOf(1, 2, 3, 4, 5).foldRight(0) { item, total -> total + item })
//    // 15
//
//    println(listOf(1, 2, 3, 4, 5).fold(1) { mul, item -> mul * item })
//    // 120
//
//    println(listOf(1, 2, 3, 4, 5).foldRight(1) { item, mul -> mul * item })
//    // 120
//
//    println(listOf(0, 1, 2, 3, 4, 5)
//        .foldIndexed(0) { index, total, item -> if (index % 2 == 0) (total + item) else total })
//    // 6
//
//    println(listOf(0, 1, 2, 3, 4, 5)
//        .foldRightIndexed(0) { index, item, total -> if (index % 2 == 0) (total + item) else total })
//    // 6
//}
