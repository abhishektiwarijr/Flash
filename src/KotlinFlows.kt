import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    mergeExample()
    zipExample()
    combineExample()
}

private val flowNumbers: Flow<Int> = flow {
    repeat(10) { value ->
        delay(1000)
        println("[Flow 1]: emitting $value")
        emit(value)
    }
}

private val flowChars: Flow<Char> = flow {
    var value = 'A'
    while (true) {
        delay(2000)
        println("[Flow 2]: emitting $value")
        emit(value)
        if (value == 'Z') {
            value = 'A'
        } else {
            value++
        }
    }
}


suspend fun mergeExample() {
//    val numbers = flowOf<Int>(1, 2, 3, 4)
//    val chars = flowOf<Char>('A', 'B', 'C', 'D')
//    println(merge(numbers, chars).toList())

    val merged = merge(flowNumbers, flowChars)
    println(merged.toList())
}

suspend fun combineExample() {
//    val numbers = flowOf<Int>(1, 2, 3, 4, 5)
//    val chars = flowOf<Char>('A', 'B', 'C', 'D')
//    numbers.combine(chars) { n, c -> "${n}_$c" }.collect(::println)
    flowNumbers.combine(flowChars) { n, c -> "${n}_$c" }.collect(::println)
}

suspend fun zipExample() {
//    val numbers = flowOf<Int>(1, 2, 3, 4, 5)
//    val chars = flowOf<Char>('A', 'B', 'C', 'D')
//    numbers.zip(chars) { n, c -> "${n}_$c" }.collect(::println)
    flowNumbers.zip(flowChars) {n, c -> "${n}_$c" }.collect(::println)
}