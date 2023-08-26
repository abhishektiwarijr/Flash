package sealed


fun main() {

}

sealed class A {
    class B : A()
    class C : A()
}

class D : A() {
    val name: String? = null
}

