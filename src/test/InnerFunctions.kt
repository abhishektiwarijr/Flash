package test

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import java.lang.reflect.ParameterizedType

fun main() {
    fun add(a : Int, b: Int) = a + b
    println(add(2, 3))
    unless(add(2, 3) < 5) {
        println("True")
    }
    exampleFunction<TestSubject>(TestSubject("WTF"))
    val type = getTypeToken<List<String>>()
    println(type) // Output: class java.lang.String
}

data class TestSubject(var name : String)

inline fun add(a : Int, b: Int) = a + b

inline fun unless(condition: Boolean, operation: () -> Unit) {
    return if (!condition) operation() else Unit
}

inline fun <T> exampleFunction(value : T) {
    //you can't access T's properties or call its functions here
    println(value!!::class.java.methods.contentToString())
}
inline fun <reified T> exampleFunctionFix(value : T) {
    //you can access T's properties or call its functions here and use 'is' checks here
}

inline fun <reified T> isInstanceOf(value: Any): Boolean {
    return value is T
}

//inline fun <reified T> getProperty(value: Any, propertyName: String): Any? {
//    if (value is T) {
//        val kClass = T::class
//        return kClass.memberProperties.find { it.name == propertyName }?.get(value)
//    }
//    return null
//}

inline fun <reified T> createInstance(): T? {
    return try {
        T::class.java.getDeclaredConstructor().newInstance()
    } catch (e: Exception) {
        null
    }
}

inline fun <reified T> getTypeToken(): Class<T> {
    val superClass = T::class.javaClass.genericSuperclass
    if (superClass is ParameterizedType) {
        val typeArguments = superClass.actualTypeArguments
        if (typeArguments.isNotEmpty()) {
            @Suppress("UNCHECKED_CAST")
            return typeArguments[0] as Class<T>
        }
    }
    throw IllegalArgumentException("Cannot determine type parameter.")
}

fun <T> printTypeName(value: T) {
    val type = value!!::class.java.genericSuperclass
    if (type is ParameterizedType) {
        val typeName = type.actualTypeArguments[0].typeName
        println("Type of value: $typeName")
    } else {
        println("Type information not available.")
    }
}

inline fun <reified T> printTypeNameReified(value: T) {
    println("Type of value: ${T::class.java.simpleName}")
}
