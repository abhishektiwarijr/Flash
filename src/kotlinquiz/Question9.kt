package kotlinquiz

//What does it print?

interface Base3 {
    val message: String
    fun print()
}

class BaseImpl2(val x: Int) : Base3 {
    override val message = "BaseImpl: x = $x"
    override fun print() { println(message) }
}

class Derived3(b: Base3) : Base3 by b {
    // This property is not accessed from b's implementation of `print`
    override val message = "Message of Derived"
}

fun main() {
    val b = BaseImpl2(10)
    val derived = Derived3(b)
    derived.print()
    println(derived.message)
}


//It prints:

//BaseImpl: x = 10
//Message of Derived

//Overridden members are not get called from members of delegate object. So it prints “BaseImpl: x = 10” instead of “Message of Derived” when derived.print() is called.