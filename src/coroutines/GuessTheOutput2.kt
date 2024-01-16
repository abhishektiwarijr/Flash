package coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow

fun main(): Unit = runBlocking {
    val state = MutableStateFlow('X')
    launch(Job()) {
        for (c in 'A'..'E') {
            delay(300)
            state.value = c
        }
    }
    state.collect {
        delay(300)
        println(it)
    }
}