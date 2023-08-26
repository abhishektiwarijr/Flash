fun main() {
    var result = solution4("apples, pears # and bananas\ngrapes\nbananas !apples", charArrayOf('#', '!'))
    println(result)
    // result should == "apples, pears\ngrapes\nbananas"
}

fun solution2(input: String, markers: CharArray): String {
    println("$input:${markers.contentToString()}")
    val result = mutableListOf<String>()
    input.split('\n').forEach { str ->
        var containSymbolNot = 0
        markers.forEach {
            if (str.contains(it)) {
                containSymbolNot = 0
                result.add(str.removeRange(str.indexOf(it) until str.length).trim())
            } else {
                containSymbolNot++
            }
        }
        if(containSymbolNot == 2) {
            result.add(str.trim())
        }
    }
    return result.joinToString("\n")
}
fun solution(input: String, markers: CharArray): String {
    val splitStr = input.split("\n").toMutableList()
//    splitStr.forEachIndexed { index, s ->
//        for (marker in markers) {
//            val markerIndex = s.indexOf(marker)
//            if (markerIndex != -1) {
//                splitStr[index] = s.replaceRange(markerIndex-1, s.length, "")
//            }
//        }
//    }

    val result = input.split("\n").joinToString("\n") {s->
        var ms = s
        for (marker in markers) {
            val markerIndex = s.indexOf(marker)
            if (markerIndex != -1) {
                ms = s.replaceRange(markerIndex-1, s.length, "")
            }
        }
        ms
    }
    println(result)
    return ""
}

fun solution3(input: String, markers: CharArray): String =
    input.lines().map { line ->
        line.split(*markers).first().trimEnd()
    }.joinToString("\n")

fun solution4(input: String, markers: CharArray): String = input.split("\n").joinToString("\n") { s->
    var ms = s
    for (marker in markers) {
        val markerIndex = s.indexOf(marker)
        if (markerIndex != -1) {
            ms = s.replaceRange(markerIndex-1, s.length, "")
        }
    }
    ms
}

fun solution5(s: String, ar: CharArray) = s.lines().joinToString("\n") { it.takeWhile { !ar.contains(it) }.trim() }


