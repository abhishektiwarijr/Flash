package hard75

fun main() {
    println(mergeAlternately(word1 = "abc", word2 = "pqr") == "apbqcr")
    println(mergeAlternately(word1 = "ab", word2 = "pqrs") == "apbqrs")
    println(mergeAlternately(word1 = "abcd", word2 = "pq") == "apbqcd")
}

fun mergeAlternately(word1: String, word2: String): String {
    val small: String
    val large: String
    if (word1.length <= word2.length) {
        small = word1
        large = word2
    } else {
        small = word2
        large = word1
    }
    val sb = StringBuilder()
    var i = 0
    while (i < small.length) {
        sb.append(word1[i])
        sb.append(word2[i])
        i++
    }
    sb.append(large.substring(i, large.length))
    return sb.toString()
}

fun mergeAlternately1(word1: String, word2: String): String {
    val result = StringBuilder()
    var i = 0
    while (i < word1.length || i < word2.length) {
        if (i < word1.length) {
            result.append(word1[i])
        }
        if (i < word2.length) {
            result.append(word2[i])
        }
        i++
    }
    return result.toString()
}
