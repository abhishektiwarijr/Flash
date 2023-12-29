package test

fun main() {
//    executeWithLogging {
//        return
//    }
//    println("Hi")

//    executeWithCrossinline {
//        return
//    }
//    println("There")

    processLambdas({
        println("Inline Lambda")
    }, {
        println("NoInline Lambda")
    })
    println("Hi..!")
}

inline fun executeWithLogging(log: () -> Unit) {
    println("Start")
    log() // The lambda passed to 'log' is inlined here
    println("End")
}


inline fun executeWithCrossinline(crossinline block: () -> Unit) {
    // You cannot use 'return' here in 'block'
    println("Before")
    block()
    println("After")
}

inline fun processLambdas(inlineLambda: () -> Unit, noinline noInlineLambda: () -> Unit) {
    // 'inlineLambda' is inlined here
    // 'noInlineLambda' is not inlined
    inlineLambda()
    noInlineLambda()
}

