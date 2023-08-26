import kotlin.math.max

fun main() {
    println(maxSequence(listOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    // should be 6: listOf(4, -1, 2, 1)
    println(maxSequence(listOf(-2, 2, 5, -11, 6)))
    // should be 7: listOf(2, 5)
}

fun maxSequence(arr: List<Int>): Int {
    var maxSum = 0
    var currentSum = maxSum

    for (i in 1 until arr.size) {
        val sumTillNow = arr[i] + currentSum
        currentSum = if (sumTillNow > arr[i]) {
            sumTillNow
        } else {
            arr[i]
        }
        maxSum = if (currentSum > maxSum) {
            currentSum
        } else {
            maxSum
        }
    }
    return maxSum
}

fun maxSubArraySum(numList: List<Int>): Int {
    var maxSoFar = 0
    var maxEndingHere = 0
    for (num in numList) {
        maxEndingHere += num
        if (maxEndingHere < 0)
            maxEndingHere = 0
        else if (maxSoFar < maxEndingHere) {
            maxSoFar = maxEndingHere
        }
    }
    return maxSoFar
}


fun maxSequenceEff(arr: List<Int>): Int {
    var max = 0
    arr.indices.forEach { outer ->
        (outer..arr.size).forEach { inner ->
            max = max(arr.subList(outer, inner).sum(), max)
        }
    }
    return max
}

fun maxSequenceEff2(arr: List<Int>): Int = when {
    arr.isEmpty() -> 0
    arr.none { it > 0 } -> 0
    else -> arr.mapIndexed { index, _ -> arr.windowed(index + 1).map { it.sum() }.maxOrNull() }.filterNotNull()
        .maxOrNull() ?: 0
}
