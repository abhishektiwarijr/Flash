fun main() {
    println(encode("abcdef")) //4bcd3f
}

fun encode(source: String?): String {
    if (source.isNullOrBlank()) return ""

    val dict = mapOf<Char, String>(
        'a' to "4",
        'e' to "3",
        'l' to "1",
        'm' to "/^^\\",
        'o' to "0",
        'u' to "(_)",
    )

    return source.map {
        if (dict.containsKey(it.lowercaseChar())) {
            dict[it.lowercaseChar()]
        } else it
    }.joinToString("")
}

fun encodeEff(source: String?): String =
    (source ?: "").map {
        when (it.lowercaseChar()) {
            'a' -> "4"
            'e' -> "3"
            'l' -> "1"
            'm' -> "/^^\\"
            'o' -> "0"
            'u' -> "(_)"
            else -> it
        } }.joinToString("")
