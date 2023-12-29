package test

fun main() {
    val obj1 = Example.A()
    obj1.print()
    val obj2 = Example.B()
    obj2.print()
}

sealed class Example {
    class A : Example() {
        fun print() {
            println("Instance of the subclass A of sealed class Example")
        }
    }
    class B : Example() {
        fun print() {
            println("Instance of the subclass B of sealed class Example")
        }
    }
}