package leetcode

/**
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
 */

fun main() {
//    println(romanToInt("III")) //3
//    println(romanToInt("LVIII")) //58
    println(romanToInt("MCMXCIV")) //1994
}


val symToNumMap = mapOf<String, Int>(
    "M" to 1000, "CM" to 900,
    "D" to 500, "CD" to 400,
    "C" to 100, "XC" to 90,
    "L" to 50, "XL" to 40,
    "X" to 10, "IX" to 9,
    "V" to 5, "IV" to 4,
    "I" to 1, "" to 0,
)

fun romanToInt(s: String): Int {
    val str = s.split("").filter { it.isNotBlank() }
    //https://dev.to/seanpgallivan/solution-roman-to-integer-567f
    var sum = 0
    for (i in str.lastIndex downTo 0) {
        val num = symToNumMap[str[i]]!!
        if (4 * num < sum) {
            sum -= num
        } else {
            sum += num
        }
    }

    return sum
}

fun romanToIntBad(s: String): Int {
    val str = s.split("").filter { it.isNotBlank() }
    var sum = 0

    for (i in 0..str.lastIndex) {
        val next = str[i]
        val prev = if(i > 0) str[i-1] else ""

        sum += if (symToNumMap[next]!! > symToNumMap[prev]!!) {
            symToNumMap[next]!! - (symToNumMap[prev]!! * 2)
        } else {
            symToNumMap[next]!!
        }
    }

    return sum
}