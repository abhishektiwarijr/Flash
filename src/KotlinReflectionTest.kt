import kotlin.reflect.full.memberProperties

class KotlinReflectionTest(private val text : String) {
    fun printText() {
        println(text)
    }
}
fun main() {
    val kotlinReflectionTest = KotlinReflectionTest("Hello, Reflection")
    val kClass = kotlinReflectionTest::class
    println(kClass) // This will print 'ExampleClass'

    //Exploring Class Properties with Reflection
    val properties = kClass.memberProperties
    properties.forEach {
        println(it.name)
    }

    //Calling Functions Dynamically
    val kFunction = KotlinReflectionTest::printText
    kFunction.call(kotlinReflectionTest)
}
