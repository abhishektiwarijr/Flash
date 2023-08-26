fun main() {
//    print(getPINs("11").toString())
    print(getPINs2("369").toString())
}
val adj = mapOf(
    '1' to setOf('1', '2', '4'),
    '2' to setOf('2', '1', '3', '5'),
    '3' to setOf('3', '2', '6'),
    '4' to setOf('4', '1', '5', '7'),
    '5' to setOf('5', '2', '4', '6', '8'),
    '6' to setOf('6', '3', '5', '9'),
    '7' to setOf('7', '4', '8'),
    '8' to setOf('8', '0', '5', '7', '9'),
    '9' to setOf('9', '6', '8'),
    '0' to setOf('0', '8')
)

fun getPINs(observed: String): List<String> {
    return observed.map { adj[it] }
        .toTypedArray()
        .fold(listOf(listOf<Char>())) { acc, set ->
            acc.flatMap { list ->
                set?.map {
                        element -> list + element
                } ?: listOf() }
        }.toSet().map { String(it.toCharArray()) }
}

val digitOptions = listOf(
    listOf("0", "8"),
    listOf("1", "2", "4"),
    listOf("1", "2", "3", "5"),
    listOf("2", "3", "6"),
    listOf("1", "4", "5", "7"),
    listOf("2", "4", "5", "6", "8"),
    listOf("3", "5", "6", "9"),
    listOf("4", "7", "8"),
    listOf("0", "5", "7", "8", "9"),
    listOf("6", "8", "9")
)

fun getPINs2(observed: String): List<String> {
    var results = listOf("")
    for (digit in observed) {
        results = results.flatMap { result ->
            digitOptions[digit.toString().toInt()]
                .map { result + it }
        }
    }
    return results
}

