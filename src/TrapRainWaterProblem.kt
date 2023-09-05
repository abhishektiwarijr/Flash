fun main() {
    println(trapRainWater(intArrayOf(3,0,2,0,4)))
}

fun trapRainWater(arr : IntArray) : Int {
    var result = 0

    // For every element of the array
    // except first and last element
    for (i in 1 until arr.lastIndex) {
        //find max left
        var left = arr[i]
        for (j in 0 until i) {
            left = Math.max(left, arr[j])
        }

        //find max right
        var right = arr[i]
        for (j in i+1 until arr.size) {
            right = Math.max(right, arr[j])
        }

        //update the maximum water value
        result += Math.min(left, right) - arr[i]
    }

    return result
}