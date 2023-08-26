fun main() {
//    println(howMuch(1, 100))
    println(howMuch(10000, 9950)) //<[[[M: 9991 B: 1427 C: 1110]]]> but was:<[[]]>
    //[[M: 37 B: 5 C: 4][M: 100 B: 14 C: 11]]
}

fun howMuch(m: Int, n: Int): String {
    var mm = m
    var nn = n
    if (m > n) {
        mm = n
        nn = m
    }
    val prices = arrayListOf<String>()
    for (i in mm..nn) {
        if ((i - 2) % 7 == 0 && (i - 1) % 9 == 0) {
            val cb = (i - 2) / 7
            val cc = (i - 1) / 9
            prices.add(
                "[M: $i B: $cb C: $cc]"
            )
        }
    }
    val result = java.lang.StringBuilder()
    result.append("[")
    prices.forEach {
        result.append(it)
    }
    result.append("]")
    return result.toString()
}

fun howmuch(m:Int, n:Int) = (Math.min(m, n)..Math.max(m, n))
    .filter { (it - 1) % 9 == 0 && (it - 2) % 7 == 0 }
    .map { "[M: $it B: ${(it - 2) / 7} C: ${(it - 1) / 9}]" }
    .joinToString("", "[", "]")