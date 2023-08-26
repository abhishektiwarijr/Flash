fun main() {
//    println(generateBinaryStrings(1))
    println(generateBinaryStrings(2))
    //val expected = listOf("00", "01", "10", "11")
}

// Implement additional functions and classes here if required
val binaryStr = mutableListOf<String>()
fun generateBinaryStrings(length: Int): List<String> {
    binaryStr.clear()
    generateBinaryStrings("", length)
    return binaryStr
}


fun generateBinaryStrings(s: String, n: Int) {
    if(s.length == n) {
        binaryStr.add(s)
    } else {
        generateBinaryStrings(s + 0, n)
        generateBinaryStrings(s + 1, n)
    }
}
