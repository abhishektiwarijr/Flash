package leetcode

fun main() {
    println(generatePermutations("cat").toString())
}

private fun generatePermutations(input : String) : List<String> {
    var result = mutableListOf<String>()
    result.add("")

    for (ch in input) {
        val newPermutations = arrayListOf<String>()
        for (perm in result) {
            for (i in 0..perm.length) {
                val newPerm = perm.substring(0, i) + ch + perm.substring(i)
                newPermutations.add(newPerm)
            }
        }
        result = newPermutations
    }

    return result
}