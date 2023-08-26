import java.lang.StringBuilder

fun main() {
    println(dec2FactString(36288000L)) //"A0000000000"
    println(dec2FactString(2982L)) //"4041000"
    println(dec2FactString(463L)) //"341010"

    println(factString2Dec("341010")) //463L
    println(factString2Dec("4042100")) //2990L
    println(factString2Dec("27A0533231100")) //1273928000L
}

private val encode = listOf(('0'..'9').toList(), ('A'..'Z').toList()).flatten()

fun dec2FactString(n: Long): String {
    var value = n
    var counter = 1
    val array = mutableListOf<Char>()
    while (value > 0) {
        array.add(encode[(value % counter).toInt()])
        value /= counter
        counter++
    }
    return array.asReversed().joinToString("")
}

fun factString2Dec(str: String): Long {
    return str.reversed().mapIndexed { index, c ->
        encode.indexOf(c) * (index.downTo(1L).takeIf {
            it.isEmpty().not()
        }?.reduce { acc, i -> acc * i } ?: 0)
    }.sum()
}


fun fac(n: Int): Long = if (n == 1) 1 else if (n <= 0) 0 else n * fac(n - 1)
fun c2d(char: Char) = if (char in '0'..'9') char.toInt() - '0'.toInt() else char.toInt() - 'A'.toInt() + 10
fun d2c(n: Long): Char = if (n in 0..9) (n + '0'.toInt()).toChar() else (n + 'A'.toInt() - 10).toChar()
fun fS2D(str: String) = str.reversed().mapIndexed { i, c -> c2d(c) * fac(i) }.sum()
fun d2FS(n: Long) = generateSequence(0 to '0') { (i, c) -> if (n < fac(i + 1)) null else
    i + 1 to d2c(n % fac(i + 2) / fac(i+1)) }.map { it.second }.joinToString("").reversed()
