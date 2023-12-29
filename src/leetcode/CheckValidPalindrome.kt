package leetcode

fun main() {
    //Two pointer approach
    val input = "ee,ve.e"
    println(isValidPalindrome(input))
}

fun isValidPalindrome(input: String): Boolean {
    var leftPointer = 0
    var rightPointer = input.lastIndex

    while (leftPointer < rightPointer) {
        if(input[leftPointer].isLetterOrDigit().not()) {
            leftPointer++
            continue
        }

        if(input[rightPointer].isLetterOrDigit().not()) {
            rightPointer--
            continue
        }

        if(input[leftPointer++].lowercase() != input[rightPointer--].lowercase()) {
            return false
        }
    }

    return true
}
