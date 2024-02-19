package coroutines

import kotlinx.coroutines.*

fun main() {
    val coroutineScope = CoroutineScope(SupervisorJob())
    coroutineScope.launch {
        var deferred2 : Deferred<String>? = null
        val deferred1 = coroutineScope.async {
            "Task 1 result: ${deferred2?.await()}"
        }
        deferred2 = coroutineScope.async {
            "Task 2 result: ${deferred1.await()}"
        }

        try {
            println(deferred1.await())
            println(deferred2.await())
        } catch (e : Exception) {
            e.printStackTrace()
        }
    }
}