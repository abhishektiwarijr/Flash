package kotlinquiz

//What does it print?

fun foo2() {
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return
        print(it)
    }
    println("Hello!")
}

fun main() {
    foo2()
}

//It prints “12”. It returns from the nearest enclosing function.
