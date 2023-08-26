fun main() {
    val l = "GOOG 300 542.0 B, AAPL 50 145.0 B, CSCO 250.0 29 B, GOOG 200 580.0 S"
    var sol = "Buy: 169850 Sell: 116000; Badly formed 1: CSCO 250.0 29 B ;"
    println(balanceStatements(l))
}

fun balanceStatements(lst: String): String {
    val result = ""
    val buySum = 0
    val sellSum = 0
    lst.split(",").forEach {
        val stock = it.split(" ")
        val quote = stock[0]
        val quoteQuantity = stock[1]
        val price = stock[2]
        val status = stock[3]

//        if (status == "B") {
//            buySum += price
//        } else {
//            sellSum += price
//        }
    }

    return result
}