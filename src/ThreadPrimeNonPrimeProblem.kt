fun main() {
    val ptr = PrimeThread()
    val pt = Thread(ptr)

    val nptr = NonPrimeThread()
    val npt = Thread(nptr)

    pt.start()
    npt.start()
}


internal open class PrimeThread : Runnable {
    override fun run() {
        for (i in 1..10000) {
            var c = 0
            var n = i
            while (n >= 1) {
                if (i % n == 0) {
                    c++
                }
                n--
            }
            if (c == 2) {
                println("Prime $i")
            }
        }
    }
}

fun primeNonPrime() {
    for (i in 1..10000) {
        var c = 0
        var n = i
        while (n >= 1) {
            if (i % n == 0) {
                c++
            }
            n--
        }
        if (c == 2) {
            println("Prime $i")
        } else {
            println("Non-Prime $i")
        }
    }
}

internal class NonPrimeThread : Runnable {
    override fun run() {
        for (i in 1..10000) {
            var c = 0
            var n = i
            while (n >= 1) {
                if (i % n == 0) {
                    c++
                }
                n--
            }
            if (c != 2) {
                println("Non-Prime $i")
            }
        }
    }
}