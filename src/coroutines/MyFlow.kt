package coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun interface MyFlow<out T> {
    suspend fun collect(collector: MyFlowCollector<T>)
}

fun interface MyFlowCollector<in T> {
    suspend fun emit(value: T)
}

fun main() = runBlocking {
//    flow<Int> {
//
//    }.collect {
//
//    }

    MyFlow<Int> {
        delay(1000L)
        it.emit(1)
        delay(1000L)
        it.emit(2)
        delay(1000L)
        it.emit(3)
    }.collect {
        println(it)
    }
}