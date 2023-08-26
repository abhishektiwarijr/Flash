fun main() {
    println(solution(10))
    println(solution(20))
}

fun solution(number: Int): Int {
    var sum = 0
    for (i in 1 until number) {
        if (i % 3 == 0 || i % 5 == 0) {
            sum += i
        }
    }
    return sum
}

fun solution1(number: Int) = (1 until number).filter { it % 3 == 0 || it % 5 == 0 }.sum()
fun solution2(number: Int): Int = (3 until number).filter { it % 3 == 0 || it % 5 == 0 }.sum()

