fun main() {
    println(addToArray(intArrayOf(1,2,0,0), 34).contentToString()) //[1,2,3,4]
    println(addToArray(intArrayOf(2,7,4), 181).contentToString()) //[4,5,5]
    println(addToArray(intArrayOf(9,9,9), 456).contentToString()) //[4,5,5]
    println(addToArray(intArrayOf(2, 1, 5), 806).contentToString()) //[1,0,2,1]
    println(
        addToArray(
            intArrayOf(1, 2, 6, 3, 0, 7, 1, 7, 1, 9, 7, 5, 6, 6, 4, 4, 0, 0, 6, 3),
            516
        ).contentToString()
    ) //[1,0,2,1]
    println(
        addToArray(
            intArrayOf(3, 8, 0, 3, 0, 2, 7, 0, 7, 6, 4, 9, 9, 1, 7, 6, 6, 1, 6, 4),
            670
        ).contentToString()
    ) //[1,0,2,1]
}

fun addToArray(nums: IntArray, k: Int): IntArray {
    var ck = k
    val result = IntArray(nums.size + 1)
    var carry = 0
    var rLastIndex = result.lastIndex

    for (i in nums.lastIndex downTo 0) {
        val n1 = ck / 10
        val l = ck - (n1 * 10)
        ck = n1
        val s = nums[i] + l + carry
        if(s == 10) {
            result[rLastIndex] = 0
            rLastIndex--
            result[rLastIndex] = 1
            break
        } else if (s > 10) {
            result[rLastIndex] = s - 10
            carry = 1
        } else {
            result[rLastIndex] = s
            carry = 0
        }
        rLastIndex--
    }
//    val sum = (nums.joinToString("").toULong() + k.toULong()).toString().splitIgnoreEmpty("").map { it.toInt() }
    return result
}

fun CharSequence.splitIgnoreEmpty(vararg delimiters: String): List<String> {
    return this.split(*delimiters).filter {
        it.isNotEmpty()
    }
}

fun getLastDigit(k : Int) {
    var ck = k
    while (ck > 0) {
        val n1 = ck / 10
        val l = ck - (n1 * 10)
        ck = n1
        println(l)
    }
}

