fun main() {
    val input1 = arrayOf("red", "green", "red", "blue", "blue")
//    result = 2 (1 red pair + 1 blue pair)

    val input2 = arrayOf("red", "red", "red", "red", "red", "red")
//    result = 3 (3 red pairs)
//    makeGlovesPair(input2)
//    val a =  charArrayOf('a', 'b', 'c', 'd', 'f')
//    val b = charArrayOf('O', 'Q', 'R', 'S')
//    println(findMissingLetter(a))
//    println(findMissingLetter(b))
    print(solve(12, 20, 18, 45, 30, 60).joinToString())
}

fun findMissingLetter(array: CharArray): Char {
    var missingLetter = ' '
    for (i in 1 until array.size) {
        val first = array[i-1].code
        val next = array[i].code
        if(next - first == 2) {
            missingLetter = ((next + first)/2).toChar()
        }
    }
    return missingLetter
}

fun solve(a:Int, b:Int, c:Int, alpha:Int, beta:Int, gamma:Int):IntArray {
    val xc = a * Math.cos(alpha * Math.PI / 180) - b * Math.sin(beta * Math.PI / 180) - c * Math.cos(gamma * Math.PI / 180)
    val yc = a * Math.sin(alpha * Math.PI / 180) + b * Math.cos(beta * Math.PI / 180) - c * Math.sin(gamma * Math.PI / 180)
    val oc = Math.round(Math.sqrt(xc*xc + yc * yc))
    var toc = Math.atan2(yc, xc) * 180 / Math.PI
    val degree = Math.floor(toc)
    toc = (toc - degree) * 60
    val minute = Math.floor(toc)
    val second = Math.floor((toc - minute) * 60)
    return intArrayOf(oc.toInt(), degree.toInt(), minute.toInt(), second.toInt())

//    val u = alpha * Math.PI / 180
//    val v = beta * Math.PI / 180
//    val w = gamma * Math.PI / 180
//    val x = a * Math.cos(u) - b * Math.sin(v) - c * Math.cos(w)
//    val y = a * Math.sin(u) + b * Math.cos(v) - c * Math.sin(w)
//    val t = Math.atan2(y, x) * 180 / Math.PI
//    val r = Math.hypot(y, x)
//    return intArrayOf(Math.round(r).toInt(), t.toInt(), (t*60).toInt()%60, (t*3600).toInt()%60)
}

fun findMissingLetterX(array: CharArray) = (array.first()..array.last()).first { it !in array }


fun String.toAscii() = this.map { it.code }.joinToString()


fun numberOfPairs(gloves:List<String>) : Int {
//    gloves.groupingBy{ it }.eachCount().values.sumOf{ it / 2 }
    val mutableInput = gloves.toMutableList()
    val result = mutableMapOf<String, Int>()
    while (mutableInput.isNotEmpty()) {
        val currentItem = mutableInput[0]
        mutableInput.removeAt(0)
        val pairIndex = mutableInput.indexOf(currentItem)
        if(pairIndex != -1) {
            if(result.contains(currentItem)) {
                val count = result[currentItem]!! + 1
                result[currentItem] = count
            } else {
                result[currentItem] = 1
            }
            mutableInput.remove(mutableInput[pairIndex])
        }
    }

    return result.values.sum()
}

fun makeGlovesPair(input: Array<String>) {
    val mutableInput = input.toMutableList()
    val result = mutableMapOf<String, Int>()
    while (mutableInput.isNotEmpty()) {
        val currentItem = mutableInput[0]
        mutableInput.removeAt(0)
        val pairIndex = mutableInput.indexOf(currentItem)
        if(pairIndex != -1) {
            if(result.contains(currentItem)) {
                val count = result[currentItem]!! + 1
                result[currentItem] = count
            } else {
                result[currentItem] = 1
            }
            mutableInput.remove(mutableInput[pairIndex])
        }
    }

    val resultStr = result.keys.joinToString(" + ") {
        if(result[it]!! > 1) {
            "${result[it]!!} $it pairs"
        } else {
            "1 $it pair"
        }
    }

    println("${result.values.sum()} ($resultStr)")
}

private fun Array<String>.anyContains(s: String) = any { it.contains(s) }
fun inArray(a1: Array<String>, a2: Array<String>) = a1.filter(a2::anyContains).toSortedSet().toTypedArray()

fun inArrayX(array1: Array<String>, array2: Array<String>): Array<String> {
    return array1.filter{e->array2.any{it.contains(e)}}.distinct().sorted().toTypedArray()
}

fun isInArray(a1: Array<String>, a2: Array<String>) {
    //    val a1 = arrayOf("arp", "live", "strong")
//    val a2 = arrayOf("lively", "alive", "harp", "sharp", "armstrong")
    val a1 = arrayOf("tarp", "mice", "bull", "live")
    val a2 = arrayOf("lively", "alive", "harp", "sharp", "armstrong", "alive")
    val rSet = mutableSetOf<String>()
    a1.forEach { x ->
        a2.forEach { y ->
            if (x in y) {
                rSet.add(x)
            }
        }
    }
}

