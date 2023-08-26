package kotlinquiz

//What does this print?

fun main() {
    open class Shape
    class Rectangle: Shape()

    fun Shape.getName() = "Shape"
    fun Rectangle.getName() = "Rectangle"

    fun printClassName(s: Shape) {
        println(s.getName())
    }

    printClassName(Rectangle())
}


//Extension functions resolves statically. This means extension function is chosen is depending the declared type of the caller. So here, Shape is calling the extension and it will print Shape.
