fun main() {
    println(blackOrWhiteKey(1)) //"white"
    println(blackOrWhiteKey(5)) //"black"
    println(blackOrWhiteKey(12)) //"black"
    println(blackOrWhiteKey(42)) //"white"
    println(blackOrWhiteKey(88)) //"white"
    println(blackOrWhiteKey(89)) //"white"
    println(blackOrWhiteKey(92)) //"white"
    println(blackOrWhiteKey(100)) //"black"
    println(blackOrWhiteKey(111)) //"white"
    println(blackOrWhiteKey(200)) //"black"
    println(blackOrWhiteKey(2017)) //"white"
}

fun blackOrWhiteKey(keyPressCount: Int): String {
    val kpc = keyPressCount % 88

//    val kpc = (keyPressCount - 1) % 88
//    var result = ""
//    for (i in 0 until kpc) {
//        if (i % 7 == 1 || i % 7 == 4) {
//            result = "black"
//        } else {
//            result = "white"
//        }
//    }
    return piano[kpc]
}

private val piano : List<String> by lazy {
    buildPiano()
}

private fun buildPiano(): List<String> {
    val piano = arrayListOf<String>()
    for (i in 1 .. 88) {
        if (i % 7 == 1 || i % 7 == 4) {
            piano.add("black")
        } else {
            piano.add("white")
        }
    }
    return piano
}
