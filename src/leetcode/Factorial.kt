package leetcode

fun main() {
    println(factorial(n = 4))
}

/**
 * The concept of tail recursion is so beautiful
 * @param n {number to calculate the factorial of}
 * @param acc {acc stores the partial factorial product
 * avoiding unnecessary multiplications after each recursive call,
 * reuses stack frames for each recursive calls}
 */
tailrec fun factorial(n: Int, acc: Long = 1): Long = when {
    n <= 1 -> acc
    else -> factorial(n - 1, n * acc)
}