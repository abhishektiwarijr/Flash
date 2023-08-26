fun main() {
    println(
        rangeExtraction(
            intArrayOf(
                -10,
                -9,
                -8,
                -6,
                -3,
                -2,
                -1,
                0,
                1,
                3,
                4,
                5,
                7,
                8,
                9,
                10,
                11,
                14,
                15,
                17,
                18,
                19,
                20
            )
        )
    )
    // returns "-10--8,-6,-3-1,3-5,7-11,14,15,17-20"
}

fun rangeExtraction(arr: IntArray): String {
    val result = arrayListOf<String>()
    var i = 0
    var j = 1
    var n = 1
    while (j < arr.size) {
        if ((arr[j] - arr[i]) == n) {
            j++
            n++
        } else {
            n = if(n>2) {
                result.add("${arr[i]}-${arr[j-1]}")
                1
            } else if(n == 2) {
                result.add("${arr[i]}")
                result.add("${arr[i+1]}")
                1
            } else {
                result.add("${arr[i]}")
                1
            }
            i = j
            j++
        }
    }

    if(n>2) {
        result.add("${arr[i]}-${arr[j-1]}")
    } else if(n == 2) {
        result.add("${arr[i]}")
        result.add("${arr[i+1]}")
    } else {
        result.add("${arr[i]}")
    }
    return result.joinToString(",")
}

fun rangeExtractionEff1(
    arr: IntArray
): String = arr.fold(emptyList<Pair<Int, Int>>()) { ranges, x ->
    ranges.lastOrNull()
        .run { if (this != null && x - second == 1) ranges.dropLast(1) + (first to x) else ranges + (x to x) }
}.joinToString(",") { (x, y) ->
    when (y - x) {
        0 -> "$x"
        1 -> "$x,$y"
        else -> "$x-$y"
    }
}

fun rangeExtractionEff(
    arr: IntArray
): String = arr.fold(emptyList<Pair<Int, Int>>()) { rs, x ->
    rs.lastOrNull().run { if (this != null && x - second == 1) rs.dropLast(1) + (first to x) else rs + (x to x) }
}.joinToString(",") { (x, y) -> if (y - x > 1) "$x-$y" else (x..y).joinToString(",") }