fun main() {
    println(top3("a a a  b  c c  d d d d  e e e e e"))
    println(top3("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e"))
    println(top3("  //wont won't won't "))
    println(top3("  , e   .. "))
    println(top3("..."))
    println(
        top3(
            sequenceOf(
                "In a village of La Mancha, the name of which I have no desire to call to",
                "mind, there lived not long since one of those gentlemen that keep a lance",
                "in the lance-rack, an old buckler, a lean hack, and a greyhound for",
                "coursing. An olla of rather more beef than mutton, a salad on most",
                "nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra",
                "on Sundays, made away with three-quarters of his income."
            ).joinToString("\n")
        )
    )
}

fun top3(s: String): List<String> {
    return s.lowercase().replace("[^a-zA-Z']+".toRegex(), " ")
        .trim()
        .split(" ")
        .groupingBy { it }
        .eachCount()
        .entries
        .sortedByDescending { it.value }
        .take(3)
        .map { it.key }
}

fun top3Eff(s: String) = "'?[a-z]['a-z]*".toRegex().findAll(s.lowercase()).map{it.value}.groupingBy{it}.eachCount().entries.sortedByDescending{it.value}.take(3).map{it.key}

private val wordExpression = Regex("[a-z']*[a-z][a-z']*")

fun top3Eff2(s: String): List<String> =
    wordExpression.findAll(s.lowercase()).map { it.value }
        .groupingBy { it }.eachCount().toList()
        .sortedByDescending { it.second }.take(3).map { it.first }
