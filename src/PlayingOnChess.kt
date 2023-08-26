fun main() {
    println(game(2))
}


fun game(n: Long) : String {
    val board = mutableListOf<Pair<Long, Long>>()
    for (i in 1..n) {
        for (j in 1..n) {
            board.add(Pair(j, j + i))
        }
    }
    var lcm = board[0].second
    var gcd: Long
    board.forEach {
        gcd = findGCDRec(it.second, lcm)
        lcm = (lcm * it.second) / gcd
    }
    var sum = 0L
    board.forEach {
        sum += (it.first * lcm) / it.second
    }

    val finalLcm = findGCD(sum, lcm)
    val result: Long = sum / finalLcm
    lcm /= finalLcm

    return "$result/$lcm"
    //finding lcm of the denominators
//    var lcm: Long = den1 * den2 / findGCD(den1, den2)

    //finding the sum of the numbers
//    val sum: Long = num1 * lcm / den1 + num2 * lcm / den2

    //normalizing numerator and denominator of result
//    val num3: Long = sum / findGCD(sum, lcm)

//    lcm = lcm / findGCD(sum, lcm)

    //printing output
//    num1 "/" den1 " + " num2 "/" den2 " = " num3 "/" lcm
}

fun findGCD(n1: Long, n2: Long): Long {
    var gcd = 0L
    var i = 1L
    while (i <= n1 && i <= n2) {
        if (n1 % i == 0L && n2 % i == 0L) {
            gcd = i
        }
        i++
    }
    return gcd
}

tailrec fun findGCDRec(a: Long, b: Long): Long {
    if (b == 0L) return a

    return findGCDRec(b, a % b)
}