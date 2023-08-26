package kotlinquiz

//What does it print?

inline fun inlined(block: () -> Unit) {
    println("hi!")
}
fun foo4() {
    inlined {
        return
    }
}
fun main() {
    foo4()
}

//It prints “hi!”. return in lambda passed to an inlined function is allowed, because return can also be inlined.