fun main() {
    println(fromNb2Str(779, intArrayOf(8, 7, 5, 3))) //"-3--2--4--2-"
    println(fromNb2Str(187, intArrayOf(8, 7, 5, 3))) //"-3--5--2--1-"
    println(fromNb2Str(259, intArrayOf(8, 7, 5, 3))) //"-3--0--4--1-"
    println(fromNb2Str(15, intArrayOf(8, 6, 5, 3))) //"Not applicable"
    println(fromNb2Str(15, intArrayOf(3, 2))) //"Not applicable"
    println(fromNb2Str(1484429358, intArrayOf(97, 31, 17, 13, 11, 8, 5, 3, 2))) //"Not applicable"
}

fun fromNb2Str(n: Int, sys: IntArray): String {
    if (sys.fold(1) { acc, i -> acc * i } < n) return "Not applicable"

    var i = 0
    var j = 1
    while (i != sys.lastIndex - 1) {
        if (areCoPrime(sys[i], sys[j])) {
            if (j == sys.lastIndex) {
                i++
                j = i + 1
            }
            j++
            continue
        } else {
            return "Not applicable"
        }
    }

    return sys.joinToString("--", "-", "-") {
        (n % it).toString()
    }
}

fun areCoPrime(n1: Int, n2: Int): Boolean {
    return gcd(n1, n2) == 1
}

tailrec fun gcd(a: Int, b: Int): Int {
    if (a == 0 || b == 0) return 0
    if (a == b) return a

    return if (a > b) {
        gcd(a - b, b)
    } else {
        gcd(a, b - a)
    }
}

fun fromNb2StrEff(n: Int, sys: IntArray) =
    if (sys.reduce { acc, i -> acc * i } < n || !isCoPrime(sys)) "Not applicable"
    else sys.joinToString("--", "-", "-") { (n % it).toString() }

fun isCoPrime(sys: IntArray): Boolean {
    for (i in sys.indices) {
        for (j in (i + 1)..sys.lastIndex) {
            if ((2..sys[j]).filter { sys[j] % it == 0 }.any { sys[i] % it == 0 })
                return false
        }
    }
    return true
}

fun gcdEff(a: Int, b: Int): Int {
    if (b == 0) {
        return a
    }
    return gcdEff(b, a % b)
}

fun hasOnlyCoprimePairs(numbers: IntArray): Boolean {
    for (i in 0 until numbers.size - 1) {
        for (j in i + 1 until numbers.size) {
            if (gcd(numbers[i], numbers[j]) != 1) {
                return false
            }
        }
    }
    return true
}

fun fromNb2StrEff2(n: Int, sys: IntArray): String {
    if (!hasOnlyCoprimePairs(sys)) return "Not applicable"
    var arr = ""
    for (i in sys) {
        arr += i.toString() + ""
    }
    var result = ""
    var theTotal = 1
    for (i in sys) {
        theTotal *= i
    }
    if (n > theTotal) {
        return "Not applicable"
    }
    for (num in sys) {
        val remainder = "-" + (n % num).toString() + "-"
        result += remainder
    }
    return result
}
