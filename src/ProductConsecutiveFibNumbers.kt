fun main() {
    println(productFib(714).contentToString())
//    println(productFib(800).contentToString())
}

fun productFib(prod: Long): LongArray {
    var a = 0L
    var b = 1L

    while (prod > (a * b)) {
        a = b
        b += a
    }

    return longArrayOf(a, b, (prod == a * b).toLong())
}

fun Boolean.toLong() = if (this) 1L else 0L
