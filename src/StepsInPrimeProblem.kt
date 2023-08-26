fun main() {
    println(step(4, 130, 200))

//    println(isPrime(1))
//    println(isPrime(2))
//    println(isPrime(4))
//    println(isPrime(5))
//    println(isPrime(3))
//    println(isPrime(7))
}

fun step(step: Int, start: Int, end: Int) : String {
    var prevPrime = 0
    for (i in start..end) {
        if(isPrime(i)) {
            if((i-prevPrime) == step) {
                return "[$prevPrime, $i]"
            }
            prevPrime = i
        }
    }
    return ""
}

fun isPrime(n : Int) : Boolean {
    if(n == 1) return false

    var factors = 0
    for (i in 1..(n/2)) {
        if(n%i == 0) {
            factors++
        }
    }
    return factors == 1
}

