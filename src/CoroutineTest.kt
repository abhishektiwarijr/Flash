import kotlinx.coroutines.*

fun main() = runBlocking {
//    val exceptionHandler = CoroutineExceptionHandler {cc, exception ->
//        println("Exception Caught: $exception")
//    }
//    val supervisorJob = SupervisorJob()
//    val scope = CoroutineScope(coroutineContext + supervisorJob + exceptionHandler)
//
//    val job1 = scope.launch {
//        delay(1000L)
//        println("Job 1 completed")
//    }
//
//    val job2 = scope.launch {
//        delay(500L)
//        throw RuntimeException("Job 2 failed")
//    }
//
//    val job3 = scope.launch {
//        delay(2000L)
//        println("Job 3 completed")
//    }
//
//    supervisorJob.join()

    normalJobExample()
}

suspend fun doTask1(): Int {
    delay(1000L)
    throw Exception("task 1 is failed")
}

suspend fun doTask2(): Int {
    delay(1500L)
    return 47
}

suspend fun doWork(num: Int) {
    delay(2000L)
    println("$num Work Done")
}

suspend fun printHelloWorld() = coroutineScope {
    launch {
        delay(2000L)
        println("World 2!")
    }
    launch {
        delay(1000L)
        println("World 1!")
    }
    throw IllegalArgumentException("Bang!")
    println("Hello")
}

suspend fun jobExample() = coroutineScope {
    val job = launch {
        delay(1000L)
        println("World!")
    }
    println("Hello")
    job.join() //wait until child coroutine completes
    println("Completed")
}

suspend fun cpuIntensiveExample() = coroutineScope {
    repeat(50_000) {
        launch {
            delay(5000L)
            println(".")
        }
    }
}

suspend fun normalJobExample() {
    val job = Job()
    val coroutineScope = CoroutineScope(Dispatchers.IO + job)

    val job1 = coroutineScope.launch { fetchDataFromNetwork("url1") }
    val job2 = coroutineScope.launch { fetchDataFromNetwork("url2") }
    val job3 = coroutineScope.launch { fetchDataFromNetwork("url3") }
    val job4 = coroutineScope.launch { fetchDataFromNetwork("url4") }
    val job5 = coroutineScope.launch { fetchDataFromNetwork("url5") }
    val job6 = coroutineScope.launch { fetchDataFromNetwork("url6") }
    val job7 = coroutineScope.launch { fetchDataFromNetwork("url7") }
    val job8 = coroutineScope.launch { fetchDataFromNetwork("url8") }

    job.join()

//        joinAll(job1, job2, job3)

//    delay(500L)
//    println("Cancelling the job!")
//    job.cancelAndJoin()
}

suspend fun fetchDataFromNetwork(url: String) {
    println("Before Delay ${Thread.currentThread().name} $url")
    delay(3000L)
    println("After Delay ${Thread.currentThread().name} $url")
}

fun supervisorJobExample() = runBlocking {
    val supervisorJob = SupervisorJob()
    val scope = CoroutineScope(coroutineContext + supervisorJob)

    val job1 = scope.launch { updateUIPart1() }
    val job2 = scope.launch { updateUIPart2() }
    val job3 = scope.launch { updateUIPart3() }

    joinAll(job1, job2, job3)
}

suspend fun updateUIPart1() {
    delay(1000L)
    println("UI Part 1 updated")
}

suspend fun updateUIPart2() {
    delay(1000L)
    throw RuntimeException("UI Part 2 update failed")
}

suspend fun updateUIPart3() {
    delay(1000L)
    println("UI Part 3 updated")
}
