package test

fun main() {
    val person = Person()
    println(person.age)
    person.name = "Tiwari"
    println(person.age)
}

/**
 * Problem
 */
class Person {
    var name : String = "Abhishek"
    val age : String
        get() = name
}

/**
 * Solution
 */
//class Person {
//    var name : String = "Abhishek"
//    val age : String
//        get() = name
//}