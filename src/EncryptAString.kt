fun main() {
    println(decrypt(encrypt("abhishek")))
    println(decrypt("zysrhsvp"))
}

private fun encrypt(str: String): String {
    return str.map {
        if (it.isLowerCase()) {
            (122 - (it.code - 97)).toChar()
        } else {
            (90 - (it.code - 65)).toChar()
        }
    }.joinToString("")
}

private fun decrypt(str: String): String {
    return str.map {
        if (it.isLowerCase()) {
            (97 + (97 - (it.code - 25))).toChar()
        } else {
            (65 + (65 - (it.code - 25))).toChar()
        }
    }.joinToString("")
}

