package leetcode

import buildSequence

fun main() {
//    println(fibMemoized(n = 4))
    println(fibonacci(n = 4))
//    println(fib(n = 30))
}

val memo = HashMap<Int, Int>()
fun fibMemoized(n: Int): Int {
    return memo.getOrPut(n) {
        if(n <= 1) n
        else fibMemoized(n - 1) + fibMemoized(n - 2)
    }
}

fun fibonacciSum(n: Int): Int {
    return if(n < 2) n else fibonacciSum(n, 2, 0, 1)
}

private fun fibonacciSum(n: Int, currentIteration: Int, prev2: Int, prev1: Int): Int {
    if (n == currentIteration) return prev2 + prev1
    val res = prev2 + prev1
    return fibonacciSum(n, currentIteration + 1, prev1, res)
}

tailrec fun fib(n : Int, a:Int = 0, b:Int = 1) : Int {
    return if(n == 0) a
    else fib(n - 1, b, a + b)
}


fun fibonacci(n : Int): Int {
    if(n <= 1) return n

    var a = 0
    var b = 1

    repeat(n - 1) {
        a = b.also { b += a }
    }

    return b
}