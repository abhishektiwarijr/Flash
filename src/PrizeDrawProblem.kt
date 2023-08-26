fun main() {
    val st = "COLIN,AMANDBA,AMANDAB,CAROL,PauL,JOSEPH"
    val weights = intArrayOf(1, 4, 4, 5, 2, 1)
    val n = 4
    println(nthRankEff(st, weights, n))
    println(nthRankEff("Elijah,Chloe,Elizabeth,Matthew,Natalie,Jayden", intArrayOf(1, 3, 5, 5, 3, 6, 1), 2))
//    Addison,Jayden,Sofia,Michael,Andrew,Lily,Benjamin, [4, 2, 1, 4, 3, 1, 2], 8
//    Addison,Jayden,Sofia,Michael,Andrew,Lily,Benjamin, [4, 2, 1, 4, 3, 1, 2], 4
//    Elijah,Chloe,Elizabeth,Matthew,Natalie,Jayden, [1, 3, 5, 5, 3, 6, 1], 2

}

fun nthRankEff(st: String, we: IntArray, n: Int) : String {
    if (st.isBlank()) return "No participants"
    if (n > we.size) return "Not enough participants"
    return st.split(",").mapIndexed { index, name ->
        val nameSum = name.lowercase().sumOf { it.code - 96 }
        val som = name.length + nameSum
        Pair(name, som * we[index])
    }.sortedBy { it.first }.sortedByDescending { it.second }[n - 1].first
}

fun nthRank(st: String, we: IntArray, n: Int): String {
    if (st.isBlank()) return "No participants"
    val participants = st.split(",".toRegex())
    if (n > participants.size) return "Not enough participants"
    val mappedNames = participants.mapIndexed { i, name ->
        val s = name.lowercase().sumOf { it.code - 96 }
        Pair(name, (s + name.count()) * we[i])
    }
    println(mappedNames)
    val sortedMappedNames = mappedNames.sortedWith(compareBy({ -it.second }, { it.first.lowercase() }))
    println(sortedMappedNames)
    return sortedMappedNames[n - 1].first
}