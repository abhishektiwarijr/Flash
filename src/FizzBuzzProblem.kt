fun main() {
//    println((1..100).map { i ->
//        mapOf(0 to i, i % 3 to "Fizz", i % 5 to "Buzz", i % 15 to "FizzBuzz")[0]
//    })
    fizzBuzz(15)
}

fun fizzBuzz(n: Int): Unit {
    for (i in 1..n) {
        when {
            i%15 == 0 -> println("FizzBuzz")
            i%3 == 0 -> println("Fizz")
            i%5 == 0 -> println("Buzz")
            else -> println(i)
        }
    }

}