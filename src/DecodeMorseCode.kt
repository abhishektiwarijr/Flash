fun main() {
    println(decodeMorse(".... . -.--   .--- ..- -.. ."))
}

val morseDecoder = mapOf<String, String>(
    ".-" to "A",
    "-..." to "B",
    "-.-." to "C",
    "-.." to "D",
    "." to "E",
    "..-." to "F",
    "--." to "G",
    "...." to "H",
    ".." to "I",
    ".---" to "J",
    "-.-" to "K",
    ".-.." to "L",
    "--" to "M",
    "-." to "N",
    "---" to "O",
    ".--." to "P",
    "--.-" to "Q",
    ".-." to "R",
    "..." to "S",
    "-" to "T",
    "..-" to "U",
    "...-" to "V",
    ".--" to "W",
    "-..-" to "X",
    "-.--" to "Y",
    "--.." to "Z",
    ".----" to "1",
    "..---" to "2",
    "...--" to "3",
    "....-" to "4",
    "....." to "5",
    "-...." to "6",
    "--..." to "7",
    "---.." to "8",
    "----." to "9",
    "-----" to "0",
    "" to " ",
    ".-.-.-" to ".",
    "--..--" to ",",
    "---..." to ".",
    "..--.." to "?",
    "-.-.--" to "!",
    "...---..." to "SOS",
    "-....-" to "''",
    "-..-." to "/",
    "-.--.-" to "()",
    ".--.-." to "@",
    "-...-" to "="
)

fun decodeMorse(code: String) = code
    .trim()
    .replace("  ", " ")
    .split(" ")
    .map { morseDecoder[it] ?: " " }
    .joinToString("")


//fun decodeMorse(code: String): String {
//    //Your code goes here!
//    //A map, MorseCode, is available
//    val words = code.split("   ")
//    val outputString = StringBuilder()
//    for (word in words) {
//        val letters = word.split(" ")
//        for (letter in letters) {
//            outputString.append(MorseCode.getOrDefault(letter, ""))
//        }
//        outputString.append(' ')
//    }
//    return outputString.toString().trim()
//}