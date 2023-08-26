package kotlinquiz

//What does it print?

class C {
    private fun getObject() = object {
        val x: String = "x"
    }

    fun printX() {
        println(getObject().x)
    }
}
fun main() {
    val c = C()
    c.printX()
}

//It prints “x”. When an anonymous object is used as a type of a local or private but not inline declaration (function or property), all its members are accessible via this function or property: