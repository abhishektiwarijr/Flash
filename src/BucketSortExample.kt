import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val input = floatArrayOf(
        0.78f, 0.17f, 0.39f, 0.26f, 0.72f, 0.94f, 0.21f, 0.12f, 0.23f, 0.68f
    )
    val arr = floatArrayOf(
        0.897.toFloat(),
        0.565.toFloat(),
        0.656.toFloat(),
        0.1234.toFloat(),
        0.665.toFloat(),
        0.3434.toFloat()
    )

    bucketSort(input)
    println(input.contentToString())
}

/**
 * If all elements are uniformly distributed across the buckets,
 * and each bucket contains roughly the same number of elements,
 * then k (the average number of elements in each bucket) is proportional to n/k.
 * Therefore, the overall time complexity is approximately O(n) + O(n log (n/k)) + O(n).
 */
fun bucketSort(input: FloatArray) {
    val n = input.size
    if(n <= 0) return

    //Create n empty buckets
    val buckets: Array<ArrayList<Float>> = Array(n) { ArrayList<Float>() }

    // 2) Put array elements in different buckets
    //Time Complexity : O(n)
    for (i in 0 until n) {
        val idx = (input[i] * n).toInt()
        buckets[idx].add(input[i])
    }

    // 3) Sort individual buckets
    //Time Complexity : O(k * log k)
    for (i in 0 until n) {
        buckets[i].sort()
    }

    // 4) Concatenate all buckets into arr[]
    //Time Complexity : O(n)
    var index = 0
    for (i in 0 until n) {
        for (j in 0 until buckets[i].size) {
            input[index++] = buckets[i][j]
        }
    }
}