package hackerrank

fun main() {
//    val scores = intArrayOf(10, 5, 20, 20, 4, 5, 2, 25, 1) //2, 4
//    val scores = intArrayOf(3, 4, 21, 36, 10, 28, 35, 5, 24, 42) //4, 0
    val scores = intArrayOf(12, 24, 10, 24) //1, 1

    var highestScore = scores.first()
    var lowestScore = scores.first()
    var noOfTimesMin = 0
    var noOfTimesMax = 0

    scores.drop(1).forEach { score ->
        if (score > highestScore) {
            highestScore = score
            noOfTimesMax++
        }
        if (score < lowestScore) {
            lowestScore = score
            noOfTimesMin++
        }
    }

    println("$noOfTimesMax $noOfTimesMin")
}