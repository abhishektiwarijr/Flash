import java.math.BigInteger

fun main() {
//    println(hanoi(1)) //1
//    println(hanoi(3)) //7
//    println(hanoi(5)) //31
//    println(hanoi(10)) //1023
    println(hanoi(59)) //576460752303423487
    println(hanoi(64)) //18446744073709551615
}

fun hanoi(disks: Int): ULong {
    if (disks == 0) return 0uL
    val s = Math.pow(2.0, disks.toDouble()).toULong()
    if (ULong.MAX_VALUE == s) {
        return ULong.MAX_VALUE
    }
    return (s - 1uL)
}

fun hanoi1(disks: Int): ULong  = when (disks) {
    0 -> 0uL
    1 -> 1uL
    else -> 1uL + hanoi1(disks - 1) * 2uL
}
fun hanoi2(disks: Int): ULong = BigInteger.valueOf(2).pow(disks).toLong().dec().toULong()
