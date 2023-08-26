fun main() {
    println(twoSum(intArrayOf(1, 2, 3), 4))
    println(twoSum(intArrayOf(1234, 5678, 9012), 14690))
    println(twoSum(intArrayOf(2, 2, 3), 4))

    println(twoSumNew(intArrayOf(1, 2, 3), 4))
    println(twoSumNew(intArrayOf(1234, 5678, 9012), 14690))
    println(twoSumNew(intArrayOf(2, 2, 3), 4))
}

fun twoSum(numbers: IntArray, target: Int): Pair<Int, Int> {
    val map = hashMapOf<Int, Int>()
    numbers.forEachIndexed { i, n ->
        val requiredNum = target - n
        if (map.containsKey(requiredNum)) {
            return Pair(map[requiredNum]!!, i)
        }
        map[n] = i
    }

    //Kotlin OSGI
    return Pair(-1, -1)
}

fun twoSumNew(numbers: IntArray, target: Int): Pair<Int, Int> {
    var a = -1
    var b = -1
    numbers.forEachIndexed { index, item ->
        val remN = target - item
        if (numbers.contains(remN)) {
            b = index
            a = numbers.indexOf(remN)
        }
    }
    return Pair(a, b)
}