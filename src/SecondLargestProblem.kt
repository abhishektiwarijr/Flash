fun main() {
    val input = intArrayOf(12, 35, 1, 10, 35, 34, 1)
    println(findSecondLargest(input))




//    input.also {
//
//    }
//    input.apply {
//
//    }
//    input.let {
//
//    }
//    input.run {
//
//    }
//    with(input) {
//
//    }
}

fun findSecondLargest(arr: IntArray): String {
    if(arr.size < 2) return "Invalid Input"

    var first = arr.first()
    var second = Int.MIN_VALUE
    for (i in 1..arr.lastIndex) {
        if(arr[i] > first) {
            second = first
            first = arr[i]
        } else if(arr[i] > second && arr[i] != first) {
            second = arr[i]
        }
    }
    return second.toString()
}
