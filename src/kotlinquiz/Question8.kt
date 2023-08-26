package kotlinquiz

//What does it print?

interface Base2 {
    fun printMessage()
    fun printMessageLine()
}

class BaseImpl(val x: Int) : Base2 {
    override fun printMessage() { print(x) }
    override fun printMessageLine() { println(x) }
}

class Derived2(b: Base2) : Base2 by b {
    override fun printMessage() { print("abc") }
}

fun main() {
    val b = BaseImpl(10)
    Derived2(b).printMessage()
    Derived2(b).printMessageLine()
}

//It prints “abc10”. override is preferred instead of delegate object.
