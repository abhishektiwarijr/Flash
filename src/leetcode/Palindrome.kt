package leetcode

fun main() {
    println(isPalindrome(121)) //true
    println(isPalindrome(-121)) //false
    println(isPalindrome(10)) //false
}

fun isPalindrome(x: Int): Boolean {
    var num = x
    var sum = 0
    while (num > 0) {
        val rem = num % 10
        num /= 10
        sum = sum * 10 + rem
    }
    return (sum == x)
}