fun main(args: Array<String>) {
//    val size = readln().toInt()
//    val nums = readln().split(' ').run { IntArray(size) { get(it).toInt() } }
////    val nums = readln().split(' ').map { it.toInt() }
//
//
//
//    val product = IntArray(size) { 1 }
//    var prefix = 1
//    var suffix = 1
//
//    for (i in 0 until size) {
//        product[i] *= prefix
//        prefix *= nums[i]
//
//        product[size - i - 1] *= suffix
//        suffix *= nums[size - i - 1]
//    }
//
//
//    println(product.joinToString(" "))

//    val input = "A man, a plan, a canal: Panama"
    val input = "race a car"
    println(isPalindrome(input))
}

fun isPalindrome(s: String): Boolean {
    var left = 0
    var right = s.length - 1

    while (left < right) {
        val chLeft = s[left]
        val chRight = s[right]

        while (left < right && isAlphaNumeric(chLeft).not()) left++
        while (right > left && isAlphaNumeric(chRight).not()) right--

        if(chLeft.lowercase() != chRight.lowercase()) {
            return false
        }

        left++
        right--
    }

    return true
}

val CAPITAL_ALPHA_RANGE = 'A'..'Z'
val SMALL_ALPHA_RANGE = 'a'..'z'
val NUMBER_DIGIT_RANGE = '0'..'9'

fun isAlphaNumeric(ch : Char) : Boolean {
    return ch in CAPITAL_ALPHA_RANGE  || ch in SMALL_ALPHA_RANGE || ch in NUMBER_DIGIT_RANGE
}