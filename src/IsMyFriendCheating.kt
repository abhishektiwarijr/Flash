fun main() {
    println(removNb(10).contentDeepToString()) //"[[6, 7], [7, 6]]"
    println(removNb(26).contentDeepToString()) //"[[15, 21], [21, 15]]"
    println(removNb(101).contentDeepToString()) //"[[55, 91], [91, 55]]"
    println(removNb(102).contentDeepToString()) //"[[70, 73], [73, 70]]"
    println(removNb(100).contentDeepToString()) //"[]"
}


fun removNb(n: Long): Array<LongArray> {
    val sumOfN: Long = n * (n + 1) / 2
    val result = arrayListOf<LongArray>()

    for (i in 1..n) {
        val j = (sumOfN - i) / (i + 1)
        if(j <= n && (i * j) == (sumOfN - i - j)){
            result.add(longArrayOf(i, j))
        }
    }


//    for (i in 1..n) {
//        val j = (sumOfN - i) / (i + 1)
//        if (j <= n && i * j == (sumOfN - i - j)) {
//            result.add(longArrayOf(i, j))
//        }
//    }

    return result.toTypedArray()
}

fun removNbEff(n: Long) = (1..n).fold(ArrayList<LongArray>()) { result, a ->
    val sum = (n * (n + 1)) / 2
    val b = (sum - a) / (a + 1)
    if (sum - b - a == b * a && b <= n) result.add(arrayOf(a, b).toLongArray())
    result
}.toTypedArray()
