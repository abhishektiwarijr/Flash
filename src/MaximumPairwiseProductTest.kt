fun main() {
    println(maximumPairwiseProduct(intArrayOf(7, 5, 14, 2, 8, 8, 10, 1, 2, 3)))
    println(maximumPairwiseProduct(intArrayOf(1_000_000, 1_000_000)))
}

fun maximumPairwiseProduct(a: IntArray): Long {
    var maxOne = 0
    var maxTwo = 0
    for (i in a) {
        if (i > maxOne) {
            maxTwo = maxOne
            maxOne = i
        } else if(i > maxTwo) {
            maxTwo = i
        }
    }
    return maxOne.toLong() * maxTwo.toLong()
}
