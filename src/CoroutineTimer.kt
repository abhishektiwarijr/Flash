import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration

fun main() {
    //https://seymanurfirat.medium.com/kotlin-flows-on-android-8104c3ffb00
    runBlocking {
        startTimer(10L)
    }
}

private fun tickerFlow(period: Duration, initialDelay: Duration = Duration.ZERO) = flow {
    delay(initialDelay)
    while (true) {
        emit(Unit)
        delay(period)
    }
}

private suspend fun startTimer(durationInSeconds: Long) {
    var remainingSeconds = durationInSeconds
    while (remainingSeconds >= 0) {
        println("Remaining seconds = $remainingSeconds")
        delay(1000L)
        //perform Action
        remainingSeconds--
    }
    println("Timer done")
}
