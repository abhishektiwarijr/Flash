package leetcode

import java.util.*

fun main() {
//    println(generatePermutations("abc").toString())
//    permute("abc", 0, 2)
//    val s1 = "ab"
//    val s2 = "eidbaooo"
//    println(checkInclusion(s1, s2))
//    findPerm("abc").forEach {
//        println(it)
//    }
    println(permutations("Tiwari"))

}

fun permutations(str : String) : List<String> {
    val results = mutableListOf<String>()
    if(str.length == 1) { return listOf(str) }

    for(i in 0..str.lastIndex) {
        val firstChar = str[i]
        val remaining = str.substring(0, i) + str.substring(i + 1)
        val remainingPerms = permutations(remaining)
        for(j in 0..remainingPerms.lastIndex) {
            results.add(firstChar + remainingPerms[j])
        }
    }

    return results
}


fun findPerm(str : String) : List<String> {
    if(str.length == 1) return listOf(str)

    val all = mutableListOf<String>()

    for (i in 0..str.lastIndex) {
        val currentLetter = str[i]
        val remainingLetters = str.slice(0 until i) + str.substring(i + 1)
        val permsOfRemainingLetters = findPerm(remainingLetters)

        permsOfRemainingLetters.forEach {
            all.add(currentLetter + it)
        }
    }

    return all
}

fun permute(s : String, l : Int, r : Int) {
    if(l == r) {
        println(s)
    } else {
        var str = s
        for(i in l..r) {
            str = swap(str, l, i)
            permute(str, l+1, r)
            str = swap(str, l, i)
        }
    }
}

fun swap(str: String, l : Int, r : Int) : String {
    val charArr = str.toCharArray()
    charArr[l] = charArr[r].also {
        charArr[r] = charArr[l]
    }
    return String(charArr)
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


private fun checkInclusion(s1 : String, s2 : String) : Boolean {
    if(s1.length > s2.length) return false

    val s1Count = IntArray(26) { 0 }
    val s2Count = IntArray(26) { 0 }

    for (i in s1.indices) {
        s1Count[s1[i] - 'a'] = s1Count[s1[i] - 'a'] + 1
        s2Count[s2[i] - 'a'] = s2Count[s2[i] - 'a'] + 1
    }

    var left = 0
    var right = s1.length

    while (right < s2.length) {
        if(matches(s1Count, s2Count)) {
            return true
        }

        s2Count[s2[right] - 'a']++
        s2Count[s2[left] - 'a']--

        left++
        right++
    }

    return matches(s1Count, s2Count)
}

private fun matches(s1Count : IntArray, s2Count : IntArray) : Boolean {
    for (i in s1Count.indices) {
        if(s1Count[i] != s2Count[i]) {
            return false
        }
    }
    return true
}