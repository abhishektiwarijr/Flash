package test

fun main() {
    val add = createAdder()
    val result = add(2, 3)
    myFun("", "") { org, portal ->
        org + portal
    }
    result.apply {
        1
    }
    println(result)
}

fun myFunTakingParameter(block: () -> Unit) {
    block()
}

private val onItemClick : (pos: Int) -> Unit = {

}

fun createMyNewAdder(): (Int, Int) -> Int {
    return { a, b -> a + b }
}

inline fun <T> T.myApply(block: T.() -> T): T {
    block()
    return this
}

inline fun <T> T.apply(block: T.() -> T): T {
    block()
    return this
}

fun createAdderFunction(): (Int, Int) -> Int {
    return { a, b -> a + b }
}

fun createAdder(): (Int, Int) -> Int {
    return { a, b -> a + b }
}

fun myFun(org: String, portal: String, fn: (String, String) -> String): String {
    return fn(org, portal)
}
