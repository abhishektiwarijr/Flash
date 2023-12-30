package leetcode

fun main() {
    val noOfStairs = 4
    //To climb n number of stairs you need (n+1) fibonacci number
    println(climbStairsGoldenRatio(noOfStairs + 1))
    println(climbStairsIterative(noOfStairs))
    println(climbStairsIterative(0))
}

/**
 *Calculates the nth Fibonacci number using the Golden Ratio formula.
 */
fun climbStairsGoldenRatio(n: Int): Int {
    val sqrtOf5 = Math.sqrt(5.0)
    val goldenRatio = (1 + sqrtOf5) / 2
    return ((Math.pow(goldenRatio, n.toDouble()) - Math.pow(1 - goldenRatio, n.toDouble())) / sqrtOf5).toInt()
}

fun climbStairsIterative(n: Int): Int {
    if(n == 0) return 0
    if(n == 1) return 1

    var oneStepBack = 1
    var twoStepBack = 1
    var currentWays = 0

    for (i in 2..n) {
        currentWays = twoStepBack + oneStepBack
        twoStepBack = oneStepBack
        oneStepBack = currentWays
    }

    return currentWays
}