fun main() {
//    println(decodeRoman("")) //0
//    println(decodeRoman("I")) //1
//    println(decodeRoman("XXI")) //21
//    println(decodeRoman("MMVIII")) //2008
//    println(decodeRoman("MDCLXVI")) //1666
    println(decodeRoman("MMMDCCCLXXIX")) //3879
}

val romanNumeral = mapOf<String, Int>(
    "M" to 1000, "CM" to 900,
    "D" to 500, "CD" to 400,
    "C" to 100, "XC" to 90,
    "L" to 50, "XL" to 40,
    "X" to 10, "IX" to 9,
    "V" to 5, "IV" to 4,
    "I" to 1
)


fun decodeRoman(str: String): Int {
    if (str.isBlank()) return 0
    val romanStr = str.split("").filter { it.isNotBlank() }

    var num = 0
    for (i in 0..romanStr.lastIndex) {
        val next = romanNumeral[romanStr[i]]!!
        val previous = if (i > 0) romanNumeral[romanStr[i - 1]]!! else 0
        num += if (next > previous) {
            (next - (previous * 2))
        } else {
            next
        }
    }
    return num

}

fun decodeRomanEff(str: String): Int =
    str.replace("CM", " 900 ")
        .replace("M", " 1000 ")
        .replace("CD", " 400 ")
        .replace("D", " 500 ")
        .replace("XC", " 90 ")
        .replace("C", " 100 ")
        .replace("XL", " 40 ")
        .replace("L", " 50 ")
        .replace("IX", " 9 ")
        .replace("X", " 10 ")
        .replace("IV", " 4 ")
        .replace("V", " 5 ")
        .replace("III", " 3 ")
        .replace("II", " 2 ")
        .replace("I", " 1 ")
        .split(" ")
        .filter { it.isNotEmpty() }
        .sumOf { it.toInt() }

fun decodeRomanEff2(str: String): Int {
    var ans = 0
    var prev = '_'
    for (token in str) {
        when (token) {
            'I' -> ans += 1
            'V' -> ans += if (prev == 'I') 3 else 5
            'X' -> ans += if (prev == 'I') 8 else 10
            'L' -> ans += if (prev == 'X') 30 else 50
            'C' -> ans += if (prev == 'X') 80 else 100
            'D' -> ans += if (prev == 'C') 300 else 500
            'M' -> ans += if (prev == 'C') 800 else 1000
        }
        prev = token
    }
    return ans
}