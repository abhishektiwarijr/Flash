import java.util.concurrent.atomic.AtomicInteger

fun main() {
    towerOfHanoi(3, 1, 3)
}

/**
 * A function that outputs a sequence of steps to move n disks from the start rod to end rod
 */
fun towerOfHanoi(n: Int, start: Int, end: Int) {
    if (n == 1) {
        println("$start -> $end")
    } else {
        val other = 6 - (start + end)
        towerOfHanoi(n - 1, start, other)
        println("$start -> $end")
        towerOfHanoi(n - 1, other, end)
    }
}