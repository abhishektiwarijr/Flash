interface Identity

@JvmInline
value class Name(val fullName : String) : Identity

fun asInline(name : Name) {}
fun <T> asGeneric(name : T) {}
fun asInterface(identity: Identity) {}
fun asNullable(name : Name?) {}

fun <T> id(name : T) : T = name

fun main() {

    val myList = listOf(1, "hello", 3.14) // List of mixed types
    printElements(myList) // Works with star projection

    val myMixedList = mutableListOf<Any>()
    storeAnything(myMixedList)
    println(myMixedList) // Output: [10, Kotlin, true]

    val name = Name("Rex")

    asInline(name)      //unboxed: used as Name itself
    asGeneric(name)     //boxed: used as generic type T
    asInterface(name)   //boxed: used as type Identity
    asNullable(name)    //boxed: used as Name?, which is different from Name

    // below, 'name' first is boxed (while being passed to 'id') and then
    // unboxed (when returned from 'id')
    // In the end, 'x' contains unboxed representation (just 'Rex'), as 'name'
    val x = id(name)
}

fun printElements(list: List<*>) {
    for (element in list) {
        if(element is Int) {
            println(element + 1)
            continue
        }
        println(element) // Accessing elements without knowing their specific type
    }
}

fun storeAnything(list: MutableList<Any>) {
    list.add(10)  // Adding an integer
    list.add("Kotlin") // Adding a string
    list.add(true)   // Adding a boolean
}
