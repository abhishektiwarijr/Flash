package leetcode

fun main() {
    val s1  = "abc"
    val s2  = "baxyzabc"
    println(checkInclusion(s1, s2))
}

private fun checkInclusion(s1: String, s2: String) : Boolean {
    if(s1.length > s2.length) return false

    val s1Map = MutableList(26) { 0 }
    val s2Map = MutableList(26) { 0 }

    s1.forEachIndexed {index, char ->
        s1Map[index] = char.code - 'a'.code + 1
        s2Map[index] = char.code - 'a'.code + 1
    }
    var matches = 0
    for (i in 0 until 26) {
        matches += if(s1Map[i] == s2Map[i]) 1 else 0
    }
    for ((l, r) in (s1.length until s2.length).withIndex()) {
        if(matches == 26) return true

        var index = s2[r].code - 'a'.code
        s2Map[index] += 1

        if(s1Map[index] == s2Map[index]) {
            matches += 1
        } else if((s1Map[index] + 1) == s2[index].code) {
            matches -= 1
        }

        index = s2[l].code - 'a'.code
        s2Map[index] -= 1

        if(s1Map[index] == s2Map[index]) {
            matches += 1
        } else if((s1Map[index] - 1) == s2[index].code) {
            matches -= 1
        }
    }

    return false
}