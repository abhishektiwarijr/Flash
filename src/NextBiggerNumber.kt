fun main() {
//    println(nextBiggerNumber(12))
//    println(nextBiggerNumber(513))
//    println(nextBiggerNumber(2017)) //2071
//    println(nextBiggerNumber(9))
//    println(nextBiggerNumber(111))
//    println(nextBiggerNumber(531))
//    println(nextBiggerNumber(414))
    println(nextBiggerNumber(144))
    println(nextBiggerNumber(1989785893)) //1989785938
    println(nextBiggerNumber(1234567890))
    println(nextBiggerNumber(885854962)) //885856249
}

fun nextBiggerNumber(n: Long): Long {
    if (n < 12) return -1
    if (areAllDigitsSame(n)) return -1

    val numArray = n.toString().toMutableList()

    var i = numArray.lastIndex
    var j = numArray.lastIndex - 1

    while (j > -1) {
        if(numArray[i] == numArray[j]) {
            i--
            j--
            continue
        }
        //swap last two
        val t = numArray[i]
        numArray[i] = numArray[j]
        numArray[j] = t

        val nn = numArray.joinToString("").toLong()
        if (nn > n) {
            return nn
        }
//        i--
        j--
    }

    return -1
}

fun areAllDigitsSame(n: Long): Boolean {
    var cn = n
    val digit: Long = cn % 10
    var result = true
    while (cn > 0) {
        val currentDigit: Long = cn % 10
        cn /= 10
        if (currentDigit != digit) {
            result = false
        }
    }
    return result
}