import java.util.*
import java.util.function.LongBinaryOperator
import kotlin.math.absoluteValue

fun main() {
    //output: r = [2, 6, 12, 20, 30, 50]
//    println(operArray(::som, longArrayOf(2, 4, 6, 8, 10, 20), 0).contentToString())
//    println(operArray(::gcdi, longArrayOf(2, 4, 6, 8, 10, 20), 0))
//    println(operArray(::lcmu, longArrayOf(2, 4, 6, 8, 10, 20), 0))
//    println(operArray(::mini, longArrayOf(2, 4, 6, 8, 10, 20), 0))
//    println(operArray(::maxi, longArrayOf(2, 4, 6, 8, 10, 20), 0))
    val a = longArrayOf(18, 69, -90, -78, 65, 40)
    var r = longArrayOf(18, 3, 3, 3, 1, 1)

    println(operArray({ x, y -> gcdi(x, y) }, a, a[0]).contentToString())
}


fun operArray(fn: LongBinaryOperator, arr: LongArray, init: Long): LongArray {
    val result = mutableListOf<Long>()
    var cInit = init
    arr.forEach { item ->
        cInit = fn.applyAsLong(cInit, item)
        result.add(cInit)
    }
    return result.toLongArray()
}

fun gcdi(xx: Long, yy: Long): Long {
    if (yy.absoluteValue == 0L) return xx
    return gcdi(yy.absoluteValue, xx.absoluteValue % yy.absoluteValue)
}

fun lcmu(a: Long, b: Long): Long {
    return (a * b).absoluteValue / gcdi(a, b)
}

fun som(a: Long, b: Long): Long {
    return a + b
}

fun maxi(a: Long, b: Long): Long {
    return a.coerceAtLeast(b)
}

fun mini(a: Long, b: Long): Long {
    return a.coerceAtMost(b)
}

fun operArrayEff(f: LongBinaryOperator, arr: LongArray, init: Long): LongArray =
    arr.scan(init, f::applyAsLong).drop(1).toLongArray()

fun operArrayEff2(f : LongBinaryOperator, arr:LongArray, base:Long) : LongArray{
    var acc = base
    return LongArray(arr.size, { i ->
        acc = f.applyAsLong(acc, arr[i])
        acc
    })
}

fun operArrayEff3(f: LongBinaryOperator, arr: LongArray, init: Long) = LongArray(arr.size).apply {
    arr.foldIndexed(init) { i, a, b -> f.applyAsLong(a, b).also { set(i, it) } }
}

fun operArrayEff4(operation: LongBinaryOperator, arr:LongArray, init:Long):LongArray =
    arr.fold(arrayListOf<Long>()) { acc, l ->
        acc.add(operation.applyAsLong(if (acc.isEmpty()) init else acc.last(), l))
        acc
    }.toLongArray()


