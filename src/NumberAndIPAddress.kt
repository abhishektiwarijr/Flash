fun main() {
//    println(numberAndIPAddress("167773121")) //10.0.3.193
//    println(numberAndIPAddress("10.3.3.193")) //167969729
    println(numberAndIPAddress("175.14.2.126")) //167969729
}

fun numberAndIPAddress(s: String): String {
    return if(s.contains(".")) {
        s.split(".").fold("") { acc, str ->
            acc + str.toULong().toString(2).padStart(8, '0')
        }.toLong(2).toString()
    } else {
        s.toULong().toString(2).padStart(Int.SIZE_BITS, '0').chunked(8).joinToString(".") {
            it.toLong(2).toString()
        }
    }
}