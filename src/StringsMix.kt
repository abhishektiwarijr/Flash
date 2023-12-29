fun main() {
    //1. Consider only lower case alphabets
    //2. Count the occurrences of each character in both string
    //3. Find the maximum count belongs to which string
    //4. Print it as "${string_number}:${count_times_characters}/"
    //5. Edge case, if max count is 1, ignore the character
    //6. Edge case, if max count is equal, print it as "=:${count_times_characters}/"

//    val s1 = "A aaaa bb c"
//    val s2 = "& aaa bbb c d"
//    val s1 = "Are they here"
//    val s2 = "yes, they are here"
    val s1 = "looping is fun but dangerous"
    val s2 = "less dangerous than coding"
    //expected:<1:ooo/[1:uuu/2:sss/=:nnn/1:ii/2:aa/2:dd/2:ee/=:gg]> but was:<1:ooo/[=:nnn/1:uuu/1:ii/=:gg/2:ss]>

    println(mix(s1, s2)) //expected:<[2:eeeee/2:yy/=:hh/=:rr]> but was:<[=:rr/2:eeee/=:hh]>
    println(stringMix(s1, s2)) //expected:<[2:eeeee/2:yy/=:hh/=:rr]> but was:<[=:rr/2:eeee/=:hh]>
}

fun mix(s1: String, s2: String): String {
    val mix1 = ('a'..'z').associateBy({ it }, { s1.filter { ch -> it == ch }.length })
    val mix2 = ('a'..'z').associateBy({ it }, { s2.filter { ch -> it == ch }.length })

    val result = mutableListOf<String>()
    for (ch in 'a'..'z') {
        val v1 = mix1[ch]!!
        val v2 = mix2[ch]!!
        if (v1 < 2 && v2 < 2) {
            continue
        }

        if (v1 == v2) {
            result.add("=:${ch.toString().repeat(v1)}")
        } else if (v1 > v2) {
            result.add("1:${ch.toString().repeat(v1)}")
        } else {
            result.add("2:${ch.toString().repeat(v2)}")
        }
    }

    return result.sortedWith(compareBy({ -it.length }, { it })).joinToString("/")
}


fun stringMix(s1: String, s2: String): String {
    //1. Consider only lower case alphabets
    //2. Count the occurrences of each character in both string
    //3. Find the maximum count belongs to which string
    //4. Print it as "${string_number}:${count_times_characters}/"
    //5. Edge case, if max count is 1, ignore the character
    //6. Edge case, if max count is equal, print is as "=:${count_times_characters}/"

    val s1CharCountMap = ('a'..'z').associateBy({ it }, { s1.count { ch -> it == ch } })
    val s2CharCountMap = ('a'..'z').associateBy({ it }, { s2.count { ch -> it == ch } })
    val result = mutableListOf<String>()

    for (ch in 'a'..'z') {
        val value1 = s1CharCountMap[ch]!!
        val value2 = s2CharCountMap[ch]!!
        if (value1 < 2 && value2 < 2) {
            continue
        }

        when {
            value1 == value2 -> {
                result.add("=:${ch.toString().repeat(value1)}")
            }

            value1 > value2 -> {
                result.add("1:${ch.toString().repeat(value1)}")
            }

            else -> {
                result.add("2:${ch.toString().repeat(value2)}")
            }
        }
    }

    return result.sortedWith(compareBy({ -it.length }, { it })).joinToString("/")
}


fun compareMaps(map1: Map<String, Int>, map2: Map<String, Int>): Boolean {
    // Check if the maps have the same keys
    val commonKeys = map1.keys.intersect(map2.keys)

    // Compare the values for the common keys
    for (key in commonKeys) {
        if (map1[key] != map2[key]) {
            return false
        }
    }

    // Check if the remaining keys in map1 are all zeros
    for (key in map1.keys - commonKeys) {
        if (map1[key] != 0) {
            return false
        }
    }

    // Check if the remaining keys in map2 are all zeros
    for (key in map2.keys - commonKeys) {
        if (map2[key] != 0) {
            return false
        }
    }

    // The maps are equal
    return true
}
