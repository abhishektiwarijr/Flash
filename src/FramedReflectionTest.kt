fun main() {
//    println("*********\n* olleH *\n* dlroW *\n*********")
//    println("************\n* srawedoC *\n************")

//    println(mirror("Codewars"))
//    println(mirror("Hello World"))

    /*

    ************
    * sjuohlw  *
    * cjp      *
    * eapmmsq  *
    * rntaog   *
    * oasevz   *
    * qhtzpizh *
    * kh       *
    ************

    ************
    * sjuohlw *
    * cjp *
    * eapmmsq *
    * rntaog *
    * oasevz *
    * qhtzpizh *
    * kh *
    ************

     */

    println(mirror("wlhoujs pjc qsmmpae goatnr zvesao hzipzthq hk"))
}

fun mirror(text: String): String {
    val splitText = text.split(" ")
    val maxLength = (splitText.maxByOrNull { it.count() }?.length ?: 0) + 4

    return buildString {
        repeat(maxLength) {
            append("*")
        }
        appendLine()
        append(splitText.joinToString(separator = "\n") {
            "* ${it.reversed().padEnd(maxLength-4, padChar = ' ')} *"
        })
        appendLine()
        repeat(maxLength) {
            append("*")
        }
    }
}

fun mirror1(text: String): String {
    val lines = text.split(" ")
    val length = lines.map { it.length }.max() ?: 0
    val mirrored = lines.map{ "* " + it.reversed().padEnd(length, ' ') + " *"}
    return mirrored.joinToString("\n","*".repeat(length + 4) + "\n","\n" + "*".repeat(length + 4))
}

fun mirror2(text: String): String {
    val lines = text.split(" ")
    val frameL = lines.maxBy { it.length }.length + 4
    return lines.joinToString("\n", "*".repeat(frameL) + "\n", "\n" + "*".repeat(frameL)) {
        "* ${it.reversed().padEnd(frameL - 4, ' ')} *"
    }
}

fun mirror3(text: String): String {
    val x = text.split(" ").map { it.reversed() }
    val m = x.maxOf { it.length }
    val r = "*".repeat(m+4)
    return "$r\n"+x.joinToString("\n"){ "* ${it.padEnd(m,' ')} *"}+"\n$r"
}

fun mirror4(text: String): String {
    val words = text.split(" ")
    val length = words.maxBy { it.length }?.length ?: 0
    return words.map { "* " + it.padStart(length).reversed() + " *" }
        .joinToString("\n", "*".repeat(length + 4) + "\n", "\n" + "*".repeat(length + 4))
}

fun mirror5(text: String): String {
    val words = text.split(' ')
    val frame = "*".repeat(words.maxBy{ it.length }!!.length + 4)
    return words.joinToString("\n", "$frame\n", "\n$frame") { "* ${it.reversed().padEnd(frame.length - 4)} *" }
}