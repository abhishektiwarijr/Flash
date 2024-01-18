fun main() {
    println(myAtoi("122"))
    println(myAtoi("-100"))
    println(myAtoi("Hello!"))
    println(myAtoi("99Hello"))
    println(myAtoi("   -42"))
    println(myNewAtoi("words and 987"))
    println(myNewAtoi("-91283472332"))
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

fun myNewAtoi(numStr : String) : Int {
    var result = 0L
    var sign = 1
    for (ch in numStr) {
        if(ch == ' ') continue
        if(ch == '+') continue
        if(ch == '-') {
            sign = -1
            continue
        }
        val digit = ch - '0'
        if(digit in 0..9) {
            result = result * 10 + digit
        } else {
            break
        }
    }
    result *= sign
    return if (result < Int.MIN_VALUE) {
        Int.MIN_VALUE
    } else if(result > Int.MAX_VALUE) {
        Int.MAX_VALUE
    } else {
        result.toInt()
    }
}