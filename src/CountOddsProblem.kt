fun main() {
    println(countOdds(3,7))
    println(countOdds(8,10))
}

fun countOdds(low: Int, high: Int): Int {
    var count = 0
    for (i in (low..high)) {
        if(i%2 == 1) {
            count++
        }
    }
    return count
}