import kotlin.math.absoluteValue

fun main() {
//    println(find(arrayOf(2, 4, 0, 100, 4, 11, 2602, 36))) //11
//    println(find(arrayOf(160, 3, 1719, 19, 11, 13, -21))) //160
//    println(find(arrayOf(1, 0, 0))) //160
//    println(find(arrayOf(2, -6, 8, -10, -3))) //-3
    println(find(arrayOf(1, 1, -1, 1, 1, -44, 7, 7, 7, 7, 7, 7, 7, 7))) //-44
}

fun find(integers: Array<Int>): Int {
    val first = integers[0] % 2
    val second = integers[1] % 2
    val third = integers[2] % 2

    return when (first) {
        second -> integers.first { it.absoluteValue % 2 != first }
        third -> integers[1]
        else -> integers[0]
    }
}

fun findEff(integers: Array<Int>) = integers.singleOrNull { it % 2 == 0 } ?: integers.single { it % 2 != 0 }

fun findEff2(integers: Array<Int>): Int {
    val (even, odd) = integers.partition { it % 2 == 0 }
    return if (even.size == 1) even[0] else odd[0]
}

fun findEff3(integers: Array<Int>) = integers.partition { it % 2 == 0 }.toList().minBy { it.size }!![0]

fun findEff4(integers: Array<Int>): Int =
    integers.groupBy { it % 2 == 0 }.values.first { it.size == 1 }.first()

fun findEff5(integers: Array<Int>): Int =
    if( integers.take(3).count {it % 2 == 0} > 1 )
        integers.first {it % 2 != 0}
    else
        integers.first {it % 2 == 0}

fun findEff6(integers: Array<Int>): Int {
    val (a, b) = integers.partition { it % 2 == 0 }
    return if (a.size == 1) a[0]
    else b[0]
}

fun findEff7(integers: Array<Int>): Int {
    var target = 1
    if (integers.slice(0..2).asSequence().map { Math.abs(it % 2) }.sum() > 1) {
        target = 0
    }
    return integers.first { Math.abs(it % 2) == target }
}