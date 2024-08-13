/**
 * TODO Write a program to give the following output for the given input.
 * E.g. 1 - Input = a1b10 Output = abbbbbbbbbb
 * E.g. 2 - Input = b3c6d15 Output = bbbccccccddddddddddddddd
 *
 * Number varies from 1 to 99
 */
fun main() {
//    val input = "b3c6d15"
    val input = "a1b10"
    var letter = ""
    var digit = 0
    val output = StringBuilder()
    input.forEach {
        if(it.isDigit()) {
            digit = digit * 10 + it.digitToInt()
        } else {
            if(letter.isNotBlank()) {
                repeat(digit) {
                    output.append(letter)
                }
                digit = 0
            }
            letter = it.toString()
        }
    }
    if(digit != 0) {
        repeat(digit) {
            output.append(letter)
        }
        digit = 0
    }
//    println(output.toString())
//    println(printOutputEff(input))
    println(printOutputEff2(input))
}

fun printOutputEff(input: String): String {
    val regex = Regex("(\\D)(\\d+)")
    val output = regex.replace(input) { matchResult ->
        matchResult.groupValues[1].repeat(matchResult.groupValues[2].toInt())
    }
    return output
}

fun printOutputEff2(input: String) : String {
    val output = buildString {
        var currentChar: Char? = null
        var currentCount = 0
        input.forEach { char ->
            when {
                char.isDigit() -> currentCount = currentCount * 10 + char.digitToInt()
                currentChar != null -> {
                    repeat(currentCount) { append(currentChar) }
                    currentChar = char
                    currentCount = 0
                }
                else -> currentChar = char
            }
        }
        currentChar?.let { repeat(currentCount) { append(currentChar) } }
    }
    return output
}