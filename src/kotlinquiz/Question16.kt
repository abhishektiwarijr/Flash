package kotlinquiz

//What does it print?

fun foo3() {
    listOf(1, 2, 3, 4, 5).forEach lit@{
        if (it == 3) return@lit
        print(it)
    }
    print(" Hello!")
}

fun main() {
    foo3()
}

//It prints “1245 Hello!”. Using the label, lambda will return from the label.