import java.lang.StringBuilder

fun main() {
    println(encode(2012)) //MMXII
    println(encode(2008)) //MMVIII
    println(encode(1996)) //MCMXCVI
    println(encode(1990)) //MCMXC
    println(encode(1666)) //MDCLXVI
    println(encode(1000)) //M
    println(encode(440)) //CDXL
    println(encode(36)) //XXXVI

    println(numerals)
}

val numberToSymbolMap = mapOf<Int, String>(
    1 to "I",
    4 to "IV",
    5 to "V",
    9 to "IX",
    10 to "X",
    40 to "XL",
    50 to "L",
    90 to "XC",
    100 to "C",
    400 to "CD",
    500 to "D",
    900 to "CM",
    1000 to "M",
)

fun encode(n: Int): String {
    if (n < 1 || n > 3999) return ""
    val result = StringBuilder()

    var nc = n
    while (nc > 0) {
        if((nc - 1000) < 0) {
            if((nc - 900) < 0) {
                if((nc - 500) < 0) {
                    if((nc - 400) < 0) {
                        if((nc - 100) < 0) {
                            if((nc - 90) < 0) {
                                if((nc - 50) < 0) {
                                    if((nc - 40) < 0) {
                                        if((nc - 10) < 0) {
                                            if((nc - 9) < 0) {
                                                if((nc - 5) < 0) {
                                                    if((nc - 4) < 0) {
                                                        nc--
                                                        result.append("I")
                                                    } else {
                                                        nc = 0
                                                        result.append("IV")
                                                    }
                                                } else {
                                                    nc -= 5
                                                    result.append("V")
                                                }
                                            } else {
                                                nc = 0
                                                result.append("IX")
                                            }
                                        } else {
                                            nc -= 10
                                            result.append("X")
                                        }
                                    } else {
                                        nc -= 40
                                        result.append("XL")
                                    }
                                } else {
                                    nc -= 50
                                    result.append("L")
                                }
                            } else {
                                nc -= 90
                                result.append("XC")
                            }
                        } else {
                            nc -= 100
                            result.append("C")
                        }
                    } else {
                        nc -= 400
                        result.append("CD")
                    }
                } else {
                    nc -= 500
                    result.append("D")
                }
            } else {
                nc -= 900
                result.append("CM")
            }
        } else {
            nc -= 1000
            result.append("M")
        }
    }

    return result.toString()
}

fun encodeEffRec(num: Int): String {
    tailrec fun encodeAux(num: Int, acc: String): String =
        if (num == 0) acc else {
            val (k, v) = numerals.first { it.second <= num }
            encodeAux(num - v, acc + k)
        }
    return encodeAux(num, "")
}

fun encodeEff(num: Int): String {
    var number = num
    var str = ""
    for (i in romanNumerals) {
        while(number >= i.value) {
            str += i.key
            number -= i.value
        }
    }
    return str
}

val symToNumMap = mapOf<String, Int>(
    "M" to 1000, "CM" to 900,
    "D" to 500, "CD" to 400,
    "C" to 100, "XC" to 90,
    "L" to 50, "XL" to 40,
    "X" to 10, "IX" to 9,
    "V" to 5, "IV" to 4,
    "I" to 1,
)

val romanNumerals = mapOf(
    "M" to 1000,"CM" to 900,
    "D" to 500,"CD" to 400,
    "C" to 100,"XC" to 90,
    "L" to 50,"XL" to 40,
    "X" to 10,"IX" to 9,
    "V" to 5,"IV" to 4,
    "I" to 1
)

val numerals = listOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I").zip(
    listOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
)
