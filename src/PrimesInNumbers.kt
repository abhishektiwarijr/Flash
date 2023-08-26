fun main() {
//    println(getNextPrime())
//    println(getNextPrime(2))
//    println(getNextPrime(3))
//    println(getNextPrime(5))
//    println(getNextPrime(7))
    println(factors(86240)) //"(2**5)(5)(7**2)(11)"
}

fun factors(l: Int): String {
    val result = StringBuilder()
    var cl = l

    var pf = getNextPrime()
    var count = 0
    while (cl > 1) {
        if (cl % pf == 0) {
            count++
            cl /= pf
            if (cl == 1) {
                if (count > 1) {
                    result.append("($pf**$count)")
                } else if (count == 1) {
                    result.append("($pf)")
                }
            }
        } else {
            if (count > 1) {
                result.append("($pf**$count)")
            } else if (count == 1) {
                result.append("($pf)")
            }
            count = 0
            pf = getNextPrime(pf)
        }
    }

    return result.toString()
}

fun getNextPrime(lastPrime: Int = 1): Int {
    val from = (lastPrime + 1)
    var prime = lastPrime
    for (i in from until (2 * from)) {
        if (isNumPrime(i)) {
            prime = i
            break
        }
    }
    return prime
}

fun isNumPrime(n: Int): Boolean {
    if (n == 1) return false

    var factors = 0
    for (i in 1..(n / 2)) {
        if (n % i == 0) {
            factors++
        }
    }
    return factors == 1
}

fun factorsEff(l: Int): String {
    var n = l
    var str = ""
    for (i in 2..n) {
        var c = 0
        while (n % i == 0) {
            c++; n /= i
        }
        if (c > 1) str += "($i**$c)"
        if (c == 1) str += "($i)"
    }
    return str
}

fun factorsEff2(l: Int) = buildString {
    var cur = l
    for (x in 2..cur) {
        var count = 0
        while (cur % x == 0) {
            count++;cur /= x
        }
        if (count > 1) append("($x**$count)")
        if (count == 1) append("($x)")
    }
}
