import kotlin.math.pow

fun main() {
    println(digPow(89, 1)) //should return 1 since 8¹ + 9² = 89 = 89 * 1
    println(digPow(92, 1)) //should return -1 since there is no k such as 9¹ + 2² equals 92 * k
    println(digPow(695, 2)) //should return 2 since 6² + 9³ + 5⁴= 1390 = 695 * 2
    println(digPow(46288, 3)) //should return 51 since 4³ + 6⁴+ 2⁵ + 8⁶ + 8⁷ = 2360688 = 46288 * 51
}

fun digPow(n: Int, p: Int): Int {
    var tp = p
    var tn = n
    val numArr = mutableListOf<Int>()
    while (tn>0) {
        numArr.add(0, tn%10)
        tn/=10
    }
    val sum = numArr.sumOf {
        Math.pow(it.toDouble(), (tp++).toDouble())
    }.toInt()
    return if((sum % n) == 0) {
        sum/n
    } else -1
}

fun digPowEff(n: Int, p: Int) = n.toString().mapIndexed { i, c -> c.toString().toDouble().pow(p + i).toInt() }.sum().let { if (it % n == 0) it / n else -1 }
