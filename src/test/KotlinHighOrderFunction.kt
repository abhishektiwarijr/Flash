package test

fun main() {
    var a = 1
    var b = 2
    val c = (a < b) `?` b `|` a


    val multiplier = createMultiplier()
    multiplier(1, 3)

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

infix fun<T> T.`|`(other : T) = other

infix fun<T> Boolean.`?`(other: T) = if (this) {
    other
} else {

}


infix fun <T> T.choose(other : T) = if(this is Boolean) {
    if (this) this else other
} else {
    throw IllegalArgumentException("choose can only be used with booleans")
}


fun myFunTakingParameter(block: () -> Unit) {
    block()
}

private val onItemClick: (pos: Int) -> Unit = {

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

fun createMultiplier() : (Int, Int) -> Int {
    return { a, b -> a * b }
}