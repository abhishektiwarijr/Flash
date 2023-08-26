import java.lang.StringBuilder
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

fun main() {
    println(backwardsPrime(2, 100))
    println(measureTimeMillis { backwardsPrime(2, 100) })
    println(measureTimeMillis { backwardsPrime(7048500, 7048600) })

//    println(measureTimeMillis { testLoopTime() })
}

fun testLoopTime() {
    val list = (1..10000).toList()

    for (i in list) {
        if (toContinue(list[i])) continue
        if (toBreak(list[i])) break

    }


//    list.asSequence()
//        .filterNot { toContinue(it) }
//        .map { it }
//        .first { toBreak(it) }

}

fun toBreak(it: Int) = it == 60
fun toContinue(it: Int) = it == 600


fun backwardsPrime(start:Long, end:Long):String {
//    val primes = mutableListOf<Long>()
    val primes = StringBuilder()

    for (n in start..end) {
        if(n.isPrime()) {
            val reversedNum = n.reversed()
            if(reversedNum != n && reversedNum.isPrime()) {
                primes.append(n.toString())
                primes.append(" ")
            }
        }
    }

//    (start..end).forEach {n->
//        if(isPrimeX(n)) {
//            val reversedNum = reverseDigits(n)
//            if(reversedNum != n && isPrimeX(reversedNum)) {
//                primes.add(n)
//            }
//        }
//    }

    return primes.toString().trimEnd()
}

fun reverseDigits(num: Long): Long {
    var n = num
    var reversedNum = 0L
    while (n > 0L) {
        val r = n % 10L
        n /= 10L
        reversedNum = reversedNum * 10L + r
    }
    return reversedNum
}

fun isPrimeX(n : Long) : Boolean {
    if(n == 1L) return false

    var factors = 0
    for (i in 1..(n/2)) {
        if(n%i == 0L) {
            factors++
        }
    }
    return factors == 1
}

fun backwardsPrimeEff(start: Long, end: Long): String {
    return (start..end).filter(::isBackwardsPrime).joinToString(" ")
}

private fun isBackwardsPrime(number: Long): Boolean {
    val reversed = number.reversed()
    return number != reversed && number.isPrime() && reversed.isPrime()
}

private fun Long.reversed() = toString().reversed().toLong()
private fun Long.isPrime() = (2..Math.sqrt(toDouble()).toLong()).none { this % it == 0L }
