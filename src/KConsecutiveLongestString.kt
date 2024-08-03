fun main() {
    println(longestConsec(arrayOf<String>("zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"), 2) == "abigailtheta")
    println(longestConsec(arrayOf<String>("ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"), 1) == "oocccffuucccjjjkkkjyyyeehh")
    println(longestConsec(arrayOf<String>("tree", "foling", "trashy", "blue", "abcdef", "uvwxyz"), 2) == "folingtrashy")
    println(longestConsec(arrayOf<String>("ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"), 1) == "oocccffuucccjjjkkkjyyyeehh")
}

fun longestConsec(strarr:Array<String>, k:Int):String {
    var i = 0
    var max = 0
    val str = StringBuilder()
    val result = StringBuilder()
    while (i <= (strarr.size - k)) {
        for (x in i until  (i+k)) {
            str.append(strarr[x])
        }
        val count = str.count()
        if(count > max) {
            max = count
            result.clear()
            result.append(str)
        }
        str.clear()
        i++
    }
    return result.toString()
}

fun longestConsecEff(strarr:Array<String>, k:Int):String {
    val n = strarr.size
    return if (n == 0 || k > n || k <= 0) ""
    else strarr.asSequence()
        .windowed(k)
        .map { it.joinToString("") }
        .maxBy { it.length }
}

fun longestConsec1(strarr:Array<String>, k:Int):String = if(k<=0||k>strarr.count()) "" else strarr.toList().windowed(k).map{it.joinToString("")}.maxBy{it.length}

fun longestConsec2(strarr: Array<String>, k: Int) =
    (0..strarr.size - k).map {
        strarr.slice(it until it + k).joinToString("")
    }.maxBy { it.length }.orEmpty()
