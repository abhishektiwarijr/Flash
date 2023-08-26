fun main() {
    println(myAtoi("122"))
    println(myAtoi("-100"))
    println(myAtoi("Hello!"))
    println(myAtoi("99Hello"))
}

fun myAtoi(strNum: String): Int {
    var result = 0
    var sign = 1
    if (strNum[0] == '-') {
        sign = -1
    }
    strNum.forEach {
        val digit = it - '0'
        if (digit in 0..9) {
            result = result * 10 + digit
        }
    }
    return result * sign
}