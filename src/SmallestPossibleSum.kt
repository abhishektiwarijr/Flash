fun main() {
    println(solutionX(longArrayOf(6,9,21)))
    println(solutionX(longArrayOf(1,21,55)))
    println(solutionX(longArrayOf(3,13,23,7,83)))
    println(solutionX(longArrayOf(71,71,71,71,71,71,71,71,71,71,71,71,71)))
    println(solutionX(longArrayOf(11,22)))
    println(solutionX(longArrayOf(5,17)))
    println(solutionX(longArrayOf(4,16,24)))
    println(solutionX(longArrayOf(9)))
}

fun solution(numbers: LongArray): Long {
    var i = 0
    while (!allItemsAreSame(numbers)) {
        for (j in numbers) {
            //if X[i] > X[j] then X[i] = X[i] - X[j]
            if (numbers[i] > j) {
                    numbers[i] = numbers[i] - j
            }
        }
        i++
        if (i > numbers.size-1) {
            i = 0
        }
    }
    return numbers.first() * numbers.size
}

fun allItemsAreSame(arr: LongArray): Boolean {
    return arr.all { it == arr.first() }
}

private tailrec fun gcd(x: Long, y: Long): Long = if (y == 0L) x else gcd(y, x % y)
fun solutionX(numbers: LongArray)  = numbers.fold(0L, ::gcd) * numbers.size
