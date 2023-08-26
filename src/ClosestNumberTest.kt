import kotlin.math.absoluteValue

fun main() {
    closestNumber("103 123 4444 99 2000")
//    closestNumber("294748 92 236912 86 185687 30 233059 2 87792 154 8")
//    closestNumber("80 71 62 53")
//    closestNumber("202174 186 177039 94 189002 66 94235 112 326314 66 48")
}


fun closestNumber(str: String) {
    val numbers = str.split(" ").map { it.toInt() }
//    val map = mutableMapOf<String, Int>()

    var i = 0
    var j = 1
    var k = 0
    var oldDiff = Int.MAX_VALUE
    var numStr = ""
    while (i < numbers.lastIndex) {
        val newDiff = (numbers[i] - numbers[j]).absoluteValue
        if(newDiff <= oldDiff) {
            oldDiff = newDiff
            numStr = "${numbers[i]} ${numbers[j]}"
        }

        i = k
        j++
        if(j == numbers.lastIndex) {
            k++
            j = i + 1
        }
    }
    println(numStr)

//    for (i in 0..numbers.lastIndex) {
//        for (j in (i+1)..numbers.lastIndex) {
//            val diff = numbers[i] - numbers[j]
//            map["${numbers[i]} ${numbers[j]}"] = diff.absoluteValue
//        }
//    }

//    println(map.minByOrNull { it.value }?.key)
}