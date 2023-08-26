import java.util.*


fun main() {

}

fun plus(o1: Optional<Int>, o2: Optional<Int>): Optional<Int> =
    `for` {
        val i1: Int = bind(o1)
        val i2: Int = bind(o2)
        yield(i1 + i2)
    }

//fun <T> `for`(lambda: suspend SequenceScope<Optional<T>>.() -> Unit): Optional<T> {
//    return sequence<Optional<T>> { lambda() }.first()
//}
//suspend inline fun <reified T:Any> SequenceScope<Optional<T>>.yield(value: T) = yield(Optional.of(value))

suspend inline fun <reified T : Any, U : Any> SequenceScope<Optional<T>>.bind(value: Optional<U>): U {
    if (!value.isPresent) {
        yield(Optional.empty())
    }
    return value.get()
}


fun <T : Any> `for`(lambda: suspend SequenceScope<Optional<T>>.() -> Unit): Optional<T> = iterator(lambda).next()

//suspend inline fun <reified T : Any, V : Any> SequenceScope<Optional<T>>.bind(value: Optional<V>): V {
//    if (!value.isPresent) yield(none())
//    return value.get()
//}
suspend inline fun <reified T : Any> SequenceScope<Optional<T>>.yield(value: T) = yield(Optional.of(value))


//infix fun Int.`**`(exponent: Int): Int = toDouble().pow(exponent).toInt()


val sequence = sequence {
    val start = 0
    // yielding a single value
    yield(start)
    // yielding an iterable
    yieldAll(1..5 step 2)
    // yielding an infinite sequence
    yieldAll(generateSequence(8) { it * 3 })
}
