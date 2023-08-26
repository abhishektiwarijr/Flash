package kotlinquiz

//What does it print?

interface Printable {
    fun prettyPrint(): String
}

@JvmInline
value class Name(val s: String) : Printable {
    override fun prettyPrint(): String = "Let's $s!"
}

fun main() {
    val name = Name("Kotlin")
    println(name.prettyPrint())
}

//Inline classes can inherit from interfaces. This will print “Let’s Kotlin!”. Please note that inline modifier is deprecated and now value is used.