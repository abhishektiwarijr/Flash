/**
 * Name Shadowing or Shadowing
 * https://stackoverflow.com/questions/49680040/why-does-kotlin-allow-variable-declarations-with-the-same-name-as-a-parameter-in/49688168#49688168
 */
fun main() {
//    Name Shadowing
//    The outer i (val i = 1) is just being shadowed by the inner loop.
//    The variables are different, so answer is:
//    yes it is possible and valid. You can verify this by printing after the loop:

    val i = 1
    for (i in 1..10) print(i)

    println()
    print(i)
}

data class Foo(override val name : String) : API(name)

open class API(open val name: String)

class ShadyPerson(name: String, age: Int){
    var name = name
    var age = age
}