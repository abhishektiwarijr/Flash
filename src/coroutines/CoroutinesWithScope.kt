package coroutines

import kotlinx.coroutines.*


fun main(): Unit = runBlocking {
    coroutineScopeManualTrackingExample()
    coroutineScopeAutomaticTrackingExample()
}

fun coroutineScopeAutomaticTrackingExample() = runBlocking {
    coroutineScope {
        launch {
            delay(1000L)
            println("Will I be printed?")
        }
        launch {
            delay(2000L)
            println("Sorry I am late, Will I be printed?")
        }
        // You can continue with other code here while the coroutine is running
    }

    // The coroutineScope will automatically wait for all launched coroutines to complete
    println("Coroutine scope completed")
}

fun coroutineScopeManualTrackingExample() = runBlocking {
    //Here we are keeping track of all the jobs manually
    val scope = CoroutineScope(Dispatchers.Default + Job())
    val job1 = scope.launch {
        loadData1()
    }
    val job2 = scope.launch {
        loadData2()
    }
    job1.join()
    job2.join()
}

suspend fun loadData1() {
    while (true) {
        delay(300L)
        println("I am working do not disturb...!")
    }
}

suspend fun loadData2() {
    delay(5000L)
    throw CancellationException()
}