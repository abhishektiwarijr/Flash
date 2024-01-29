import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() : Unit = runBlocking {
    val stateFlow = MutableStateFlow(0)
    launch {
        delay(500)
        stateFlow.value = 1
        delay(500)
        stateFlow.value = 2
        delay(500)
        stateFlow.value = 2
        delay(500)
        stateFlow.value = 1
        delay(500)
        stateFlow.value = 3
    }
    stateFlow.collect {
        println(it)
    }
}