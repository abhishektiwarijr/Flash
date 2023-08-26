package kotlinquiz

//What does it print?

val lazyValue: String by lazy {
    println("computed!")
    "Hello"
}

fun main() {
    println(lazyValue)
    println(lazyValue)
}

//It prints:

//computed!
//Hello
//Hello

//In the first call, lambda passed to lazy() is executed. In the second call, it does not execute the lambda, and just returns the previously calculated and stored value.