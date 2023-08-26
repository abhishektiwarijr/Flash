package kotlinquiz

//What does this print?

fun main() {
    class Example {
        fun printFunctionType() { println("Class method") }
    }

    fun Example.printFunctionType() { println("Extension function") }

    Example().printFunctionType()
}

//If the same method is defined as a member function and an extension function, member function always wins. So it will print Class method.