import java.math.BigInteger

fun main() {
    height(0.toBigInteger(), 14.toBigInteger()) // 0
    height(2.toBigInteger(), 0.toBigInteger()) //= 0
    height(2.toBigInteger(), 14.toBigInteger()) // 105
    height(7.toBigInteger(), 20.toBigInteger()) // 137979
}

fun height(n: BigInteger, m: BigInteger): BigInteger {
    if(n == 0.toBigInteger() || m == 0.toBigInteger()) return 0.toBigInteger()


    return n
}