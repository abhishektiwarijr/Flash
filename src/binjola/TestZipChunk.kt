package binjola

fun main() {
//    function1()
//    println("How are you?")
    flatMapUsage()
}

private fun function1() {
    println("Hi")
    return
}

private fun flatMapUsage() {
    val words = listOf("hello", "world")
    val characters = words.flatMap {
        it.toList()
    }
    println(characters)
}