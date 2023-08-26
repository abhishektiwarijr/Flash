fun main() {
    val input = intArrayOf(34, 12, 13, 1, 10, 34, 16, 34)
//    println(findThirdLargest(input))
    println(findThirdLargestEff(input))
}

private fun findThirdLargest(arr: IntArray): String {
    if (arr.size < 3) return "Invalid Input"

    //find first largest
    var first = arr.first()
    for (i in 1..arr.lastIndex) {
        if (arr[i] > first) {
            first = arr[i]
        }
    }

    //find second largest
    var second = -1
    for (i in arr) {
        if (i > second && i < first) {
            second = i
        }
    }

    //find third largest
    var third = -1
    for (i in arr) {
        if (i > third && i < second) {
            third = i
        }
    }

    return third.toString()
}

private fun findThirdLargestEff(arr: IntArray): String {
    if (arr.size < 3) return "Invalid Input"

    var first = arr.first()
    var second = Int.MIN_VALUE
    var third = Int.MIN_VALUE
    for (i in 1..arr.lastIndex) {
        if (arr[i] > first) {
            third = second
            second = first
            first = arr[i]
        } else if (arr[i] > second && arr[i] != first) {
            third = second
            second = arr[i]
        } else if (arr[i] > third && arr[i] != first && arr[i] != second) {
            third = arr[i]
        }
    }

    return "$first,$second,$third"
}