import java.lang.StringBuilder

fun main() {
    println(decode("1273409kuqhkoynvvknsdwljantzkpnmfgf"))
    println(decode("105860ymmgegeeiwaigsqkcaeguicc"))
    println(decode("2460721mlptwabtlnnymizdkvfwlpwufhdsx"))
    println(decode("1877138eieaqgumigywmicwgcgg"))
}

fun decode(r: String): String {
    val alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray()
    val result = StringBuilder()
    val num = r.replace("\\D".toRegex(), "").toInt()
    val letters = r.replace("\\d".toRegex(), "")

    letters.forEach {
        val index = alphabet.indexOf(it)
        for (i in 0 until 26) {
            if (i * num % 26 == index) {
                result.append(alphabet[i])
            }
        }
    }

    if (result.length != letters.length) {
        return "Impossible to decode"
    }

    return result.toString()
}

fun decodeEff(r: String): String {
    val x = r.filter { it.isDigit() }.toInt() % 26
    if (x % 2 == 0 || x == 13) return "Impossible to decode"
    val dict = ('a'..'z').associateBy { ((it - 'a') * x % 26 + 97).toChar() }
    return r.filter { it.isLowerCase() }.map { dict.getValue(it) }.joinToString("")
}