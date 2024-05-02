//https://blog.devgenius.io/practical-ideas-of-kotlin-currying-e5d4b182cbb0

/**
 * Converting a function to the form f(x)(y) is called currying
 * in honor of the mathematician Haskell Curry.
 */
fun main() {
    println(curryingSum(2)(3))
    println(curryingMultiple(2)(3))
}

val curryingSum : (Int) -> (Int) -> Int = { x -> { y -> x + y } }

fun normalMultiple(a : Int, b : Int) : Int = (a * b)

/**
 * Currying just transforms multiple arguments into a series
 * of methods that work with a single argument only.
 */
fun curryingMultiple(a : Int) : (Int) -> Int {
    return fun(b : Int) : Int {
        return a * b
    }
}