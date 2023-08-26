data class Person(var name: String?=null)

fun main() {
    //https://www.howtodoandroid.com/kotlin-scope-functions/
    val person = Person("John Doe")

    val also = person.also {

    }
    val apply = person.apply {

    }
    val with = with(person) {
        return@with "HelloWith"
    }
    val let = person.let {
        return@let "HelloLet"
    }
    val run = person.run {
        return@run "HelloRun"
    }

    println(also)
    println(apply)
    println(with)
    println(let)
    println(run)
}

inline fun <T> T.also(block: (T) -> Unit): T {
    block(this)
    return this
}

inline fun <T> T.apply(block: T.() -> Unit): T {
    block()
    return this
}

inline fun <T, R> with(receiver: T, block: T.() -> R): R {
    return receiver.block()
}

inline fun <T, R> T.let(block: (T) -> R): R {
    return block(this)
}

inline fun <T, R> T.run(block: T.() -> R): R {
    return block()
}
