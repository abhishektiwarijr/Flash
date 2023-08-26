fun main() {
//    println(bingo(arrayOf("ABC" to 65, "HGR" to 74, "BYHT" to 74), 2))
//    println(bingo(arrayOf("ABC" to 65, "HGR" to 74, "BYHT" to 74), 1))
//    println(bingo(arrayOf("HGTYRE" to 74, "BE" to 66, "JKTY" to 74), 3))

    println(
        bingo(
            arrayOf(
                "NPCUHQBS" to 76,
                "PCNDNU" to 78,
                "VECJ" to 74,
                "IGSO" to 88,
                "KTOXC" to 68,
                "WJBEUE" to 80,
                "DXQI" to 71,
            ), 3
        )
    )
}

fun bingo(ticket: Array<Pair<String, Int>>, win: Int): String {
    var myWin = 0
    ticket.forEach {
        if(it.first.toCharArray().any { ch -> (ch.code == it.second) }) {
            myWin += 1
        }
    }
    return if (myWin >= win) {
        "Winner!"
    } else {
        "Loser!"
    }
}

fun bingo1(ticket: Array<Pair<String, Int>>, win: Int) =
    if (ticket.count { it.second.toChar() in it.first } >= win) "Winner!" else "Loser!"

fun bingo2(ticket: Array<Pair<String, Int>>, win: Int) =
    if (ticket.count { pair -> pair.first.any { it.code == pair.second } } >= win) "Winner!" else "Loser!"

fun bingo3(ticket: Array<Lot>, win: Int) = if(ticket.count(Lot::isMiniWin) >= win) "Winner!" else "Loser!"
private typealias Lot = Pair<String, Int>
private val Lot.isMiniWin get() = first.any { it.code == second }

