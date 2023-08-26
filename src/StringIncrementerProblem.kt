fun main() {
    println(incrementString("foobar000"))
    println(incrementString("foobar999"))
    println(incrementString("foobar00999"))
    println(incrementString("foo"))
    println(incrementString("foobar001"))
    println(incrementString("foobar1"))
    println(incrementString("1"))
    println(incrementString(""))
    println(incrementString("009"))

    println(incrementString("fo99obar99")) //fo99ob[100]00
}

fun incrementString(str: String) : String {
    val i = str.takeLastWhile { it.isDigit() }
    return str.dropLast(i.length) + ((i.toIntOrNull() ?: 0) + 1).toString().padStart(i.length, '0')
}