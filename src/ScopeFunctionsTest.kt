data class Person(var name: String?=null)

fun main() {
    //https://www.howtodoandroid.com/kotlin-scope-functions/
    val person = Person("John Doe")
//
//    val also = person.also {
//
//    }
//    val apply = person.apply {
//
//    }
    val with = with(person) {
        return@with "HelloWith"
    }
//    val let = person.let {
//        return@let "HelloLet"
//    }
//    val run = person.run {
//        return@run "HelloRun"
//    }
//
//    println(also)
//    println(apply)
    println(with)
//    println(let)
//    println(run)
    testScopeFunction()
}

private fun testScopeFunction() {
    /** Function    Object Reference    Return Value    Is extension function? **/
    /** let         it                  Lambda Result   Yes **/
    /** run         this                Lambda Result   Yes **/
    /** run         -                   Lambda Result   No: called without the context object **/
    /** with        this                Lambda Result   No: takes the context object as an argument **/
    /** apply       this                Context object  Yes **/
    /** also        it                  Context object  Yes **/



    val person = Person("John Doe")
    val let = person.let {
        "${it.name} let"
    }
    println(let)

    val run1 = person.run {
        "$name run"
    }
    println(run1)

    val run2 = run {
        "Hello run"
    }
    println(run2)

    val with = with(person) {
        "Hello with"
    }
    println(with)

    val apply = person.apply {
        name = "Game"
    }
    println(apply)

    val also = person.also {
        it.name = "New Game"
    }
    println(also)

//    val numbers = mutableListOf("one", "two", "three")
//    val countEndsWithE = numbers.run {
//        add("four")
//        add("five")
//        count { it.endsWith("e") }
//    }
//    println("There are $countEndsWithE elements that end with e.")
}

//inline fun <T> T.also(block: (T) -> Unit): T {
//    block(this)
//    return this
//}
//
//inline fun <T> T.apply(block: T.() -> Unit): T {
//    block()
//    return this
//}
//
//inline fun <T, R> with(receiver: T, block: T.() -> R): R {
//    return receiver.block()
//}
//
//inline fun <T, R> T.let(block: (T) -> R): R {
//    return block(this)
//}
//
//inline fun <T, R> T.run(block: T.() -> R): R {
//    return block()
//}