package hard75

fun main() {
    val sum = `add two numbers without using + or - operator`(5, 6)
    println(sum)

    listOf(5, 4, 3, 2, 1).forEach {

    }
}

private fun `add two numbers without using + or - operator`(n1 : Int, n2 : Int): Int {
    var sum = n1
    var carry = n2

    while (carry != 0) {
        val temp = sum // Store current sum

        // XOR gives the sum of bits without considering the carry
        sum = sum xor carry // XOR sums previous sum and carry,

        // AND & left shift give the carry
        carry = temp and carry // Extract carry by AND-ing previous sum and carry
        carry = carry shl 1 // Shift carry one bit to the left
    }

    return sum
}