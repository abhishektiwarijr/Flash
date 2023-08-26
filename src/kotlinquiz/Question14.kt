package kotlinquiz

//What does it print?

fun ordinaryFunction(block: () -> Unit) {
    println("hi!")
}
fun foo() {
    ordinaryFunction {
        //TODO : Uncomment line below
//        return
    }
}
fun main() {
    foo()
}


//It does not print anything. It will give a compile error. You can only return from a named function or anonymous function. return in lambda is not allowed.