fun main() {
    println(myAtoi("122"))
    println(myAtoi("-100"))
    println(myAtoi("Hello!"))
    println(myAtoi("99Hello"))
    testMapWithSameKeyMultipleTimes()
}

fun testMapWithSameKeyMultipleTimes() {
    val map = mutableMapOf<String, String>(
        "A" to "Abhishek",
        "B" to "Bhuvnesh",
        "C" to "Chitransh",
        "D" to "Durgesh"
    )
    map["A"] = "Aman"
    
    println(map)
}

fun myAtoi(strNum: String): Int {
    var sign = 1
    if (strNum[0] == '-') {
        sign = -1
    }

    var result = 0
    strNum.forEach {
        val digit = it - '0'
        if (digit in 0..9) {
            result = result * 10 + digit
        }
    }
    return result * sign
}