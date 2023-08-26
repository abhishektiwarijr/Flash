fun main() {
    val input = arrayOf(
        "Omega",
        "Alpha",
        "Omega",
        "Alpha",
        "Omega",
        "Alpha",
        "Omega",
        "Alpha",
        "Omega",
        "Alpha",
        "Omega",
        "Alpha",
        "Omega",
        "Alpha",
        "Omega",
        "Alpha",
        "Omega",
        "Alpha",
        "Omega",
        "Beta"
    )
    val input1 = arrayOf(
        "Alpha",
        "Beta",
        "Zeta",
        "Beta",
        "Zeta",
        "Zeta",
        "Epsilon",
        "Beta",
        "Zeta",
        "Beta",
        "Zeta",
        "Beta",
        "Delta",
        "Zeta",
        "Beta",
        "Zeta",
        "Beta",
        "Zeta",
        "Beta",
        "Zeta",
        "Beta",

        )
    println(mostActive(input1).contentToString())
}

fun mostActive(customers: Array<String>): Array<String> {
    val result = arrayListOf<String>()
    customers.groupBy { it }
        .mapValues { (_, occurrences) -> occurrences.size }
        .filter {
            (it.value * 100.0) / customers.size >= 5.0
        }
        .toSortedMap()
        .forEach {
            result.add(it.key)
        }
    return result.toTypedArray()
}