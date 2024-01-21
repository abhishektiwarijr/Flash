/**
 * The :: operator in Kotlin is used for
 * 1. function references,
 * 2. property references and
 * 3. constructor references
 */
fun main() {
    testFunctionReference()
    testConstructorReference()
    testPropertyReference()
    testMemberFunctionReference()
    testTopLevelFunctionReference()
    testExtensionFunctionReference()
}

/**
 * Function Reference Example Start
 */
fun shout() {
    println("Quack Quack..!")
}

private val functionReference : () -> Unit = ::shout

fun testFunctionReference() {
    //This is just for demo, not a good practice to use it like this
    val referencedFunction = functionReference
    referencedFunction()

    //or

    //This is how we should use
    functionReference()
}
/**
 * Function Reference Example End
 */


/**
 * Constructor Reference Example Start
 */
data class Employee(val name : String, val salary : Int)

val constructorReference : (String, Int) -> Employee = ::Employee

fun testConstructorReference() {
    val employee1 = constructorReference("John", 100_000)
    val employee2 = constructorReference("Lucy", 150_000)

    println(employee1)
    println(employee2)
}
/**
 * Constructor Reference Example End
 */


/**
 * Property Reference Example Start
 */
data class Engineer(val name : String, val trade : String)

val propertyReference : (Engineer) -> String = Engineer::trade

fun testPropertyReference() {
    val trade = propertyReference(Engineer("Jack", "The Ripper"))
    println(trade)
}
/**
 * Property Reference Example End
 */


/**
 * Member Function Reference Example Start
 */
class Calculator {
    fun add(a: Int, b: Int): Int = a + b
}
val calculator = Calculator()
val memberFunctionReference : (Int, Int) -> Int = calculator::add

fun testMemberFunctionReference() {
    println("The sum is : ${memberFunctionReference(5, 7)}")
}
/**
 * Member Function Reference Example End
 */


/**
 * Top-Level Function Reference Example Start
 */
fun topLevelFunction(message: String) {
    println("Message: $message")
}

val topLevelFunctionReference : (String) -> Unit = ::topLevelFunction

fun testTopLevelFunctionReference() {
    topLevelFunctionReference("This is secret..! Don't tell anyone.")
}
/**
 * Top-Level Function Reference Example End
 */

/**
 * Extension Function Reference Example Start
 */

fun String.capitalizeFirstLetter() : String {
    if(isNotBlank()) {
        val first = this[0].uppercase()
        return buildString {
            append(first)
            append(this@capitalizeFirstLetter.substring(1))
        }
    }
    return this
}

val extensionFunctionReference : String.() -> String = String::capitalizeFirstLetter
fun testExtensionFunctionReference() {
    println("jack".extensionFunctionReference())
}
/**
 * Extension Function Reference Example End
 */