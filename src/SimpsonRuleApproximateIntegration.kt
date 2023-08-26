import kotlin.math.sin

fun main() {
    println(simpson(290))
    println(simpson(72))
}

fun simpson(n: Int): Double {
    val a = 0.0
    val b = Math.PI
    val h = (b - a) / n

    var thirdTerm = 0.0
    for (i in (1..(n / 2))) {
        thirdTerm += fox(a + ((2 * i - 1) * h))
    }
    var fourthTerm = 0.0
    for (i in (1 until (n / 2))) {
        fourthTerm += fox(a + (2 * i * h))
    }

    return ((b - a) / (3 * n)) * (fox(a) + fox(b) + (4 * thirdTerm) + (2 * fourthTerm))
}

fun fox(x: Double): Double {
    return (3 * Math.pow(sin(x), 3.0)) / 2
}

fun f(x:Double) = 1.5 * Math.pow(sin(x), 3.0)

fun simpsonEff(n: Int): Double {
    val a = 0.0
    val b = Math.PI
    
    val h = (b-a)/n
    val p = (1..n/2).map { i -> f(a+(2*i-1)*h) }.sum()
    val q = (1 until n/2).map { i -> f(a+2*i*h) }.sum()
    return h/3*(f(a)+f(b)+4*p+2*q)
}
