fun main() {
    println(iterPi2String(0.1)) // "[10, 3.0418396189]")
    println(iterPi2String(0.02)) // "[10, 3.0418396189]")
//    println(iterPi2String(0.01)) // "[100, 3.1315929036]")
//    println(iterPi2String(0.001)) // "[1000, 3.1405926538]")
}

fun iterPi2String(epsilon: Double): String {
    var i = 0
    var j = 1
    var pi = 0.0
    while (Math.abs(Math.PI - pi * 4) > epsilon) {
        if (i % 2 == 0) pi += 1.0 / j else pi -= 1.0 / j
        j += 2
        i++
    }
    return String.format("[%d, %.10f]", i, pi * 4)
}

fun Double.round(decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return Math.round(this * multiplier) / multiplier
}

fun iterPi2String2(epsilon: Double): String {
    var pi4: Double = 1.0
    var sign: Double = -1.0
    var denom: Double = 3.0
    var iterations = 1
    while (Math.abs(4.0 * pi4 - Math.PI) >= epsilon) {
        pi4 += sign * (1.0 / denom)
        sign *= -1.0
        denom += 2.0
        iterations += 1
    }
    return "[%d, %.10f]".format(iterations, 4.0 * pi4)
}

fun iterPi2String3(epsilon: Double) = calculateApproximationAndIterations(epsilon)
    .let { (iterations, approximation) ->
        "[${iterations + 1}, %.10f]".format(approximation * 4)
    }

private tailrec fun calculateApproximationAndIterations(
    epsilon: Double,
    currentIteration: Int = 0,
    currentApproximation: Double = 0.0
): Pair<Int, Double> {
    val newApproximation = currentApproximation + term(currentIteration)
    return if (Math.abs(newApproximation * 4 - Math.PI) < epsilon) {
        currentIteration to newApproximation
    } else {
        calculateApproximationAndIterations(epsilon, currentIteration + 1, newApproximation)
    }
}

private val term: (Int) -> Double = {
    val denominator = 1.0 + it * 2.0
    val sign = if (it % 2 == 0) 1.0 else -1.0
    sign / denominator
}
