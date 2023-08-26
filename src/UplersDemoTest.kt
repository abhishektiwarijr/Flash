fun main() {
    //find the smallest positive integer that does not occur in array
    println(smallestPositiveInt(intArrayOf(1, 3, 6, 4, 1, 2))) //5
    println(smallestPositiveInt(intArrayOf(1, 2, 3))) //4
    println(smallestPositiveInt(intArrayOf(-1, -3))) //1
}

fun smallestPositiveInt(A: IntArray): Int {
    if (A.all { it < 0 }) return 1

    var item = 1
    var result = 0
    for (i in 0..A.lastIndex) {
        if (item !in A) {
            result = item
        }
        item++
    }

    return if (result == 0) {
        item
    } else {
        result
    }
}