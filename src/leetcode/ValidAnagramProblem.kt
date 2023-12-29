package leetcode

import twoSumNew
import java.util.*
import kotlin.collections.HashMap

fun main() {
    val s = "anagram"
    val t = "nagaram"
    println(isAnagramEff(s, t))
}

fun isAnagramEff(s: String, t: String): Boolean {
    if(s.length != t.length) return false

    val map = HashMap<Char, Int>()

    for (ch in s) map[ch] = 1 + map.getOrDefault(ch , 0)

    for (ch in t) {
        var current = map.getOrDefault(ch, 0)
        if(current < 1) return false
        map[ch] = --current
    }

    s.chars().sorted().toArray().contentEquals(t.chars().sorted().toArray())

    return true
}

fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false

    val sMap = mutableMapOf<Char, Int>()
    val tMap = mutableMapOf<Char, Int>()

    for (i in s.indices) {
        sMap[s[i]] = 1 + sMap.getOrDefault(s[i], 0)
        tMap[t[i]] = 1 + tMap.getOrDefault(t[i], 0)
    }

    for (ch in sMap.keys) {
        if (sMap[ch] != tMap.getOrDefault(ch, defaultValue = 0)) {
            return false
        }
    }

    return true
}
