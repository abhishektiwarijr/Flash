package hackerrank

fun main() {
    println(birthday(arrayOf(2, 2, 1, 3, 2), 4, 2)) //2
    println(birthday(arrayOf(1, 2, 1, 3, 2), 3, 2)) //2
    println(birthday(arrayOf(1, 1, 1, 1, 1, 1), 3, 2)) //0
    println(birthday(arrayOf(4), 4, 1)) //1
}

fun birthday(s: Array<Int>, d: Int, m: Int): Int {
    var noOfWays = 0

    for (i in 0..s.size - m) {
        var j = i
        var sum = 0
        while (j < (i + m)) {
            sum += s[j]
            j++
        }

        if (sum == d) {
            noOfWays++
        }
    }

    return noOfWays
}