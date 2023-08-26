fun main() {
    val tttRegex = arrayOf(
        123,456,789,147,258,369,159,357
    )

    val strMatching = arrayOf(
        "allochirally",
        "anticovenanting",
        "barbary",
        "calelectrical",
        "entablement",
        "ethanethiol",
        "froufrou",
        "furfuryl",
        "galagala",
        "heavyheaded",
        "linguatuline",
        "mathematic",
        "monoammonium",
        "perpera",
        "photophonic",
        "purpuraceous",
        "salpingonasal",
        "testes",
        "trisectrix",
        "undergrounder",
        "untaunted"
    )
    val strNonMatching = arrayOf(
        "anticker",
        "corundum",
        "crabcatcher",
        "damnably",
        "foxtailed",
        "galvanotactic",
        "gummage",
        "gurniad",
        "hypergoddess",
        "kashga",
        "nonimitative",
        "parsonage",
        "pouchlike",
        "presumptuously",
        "pylar",
        "rachioparalysis",
        "scherzando",
        "swayed",
        "unbridledness",
        "unupbraidingly",
        "wellside",
    )
    strMatching.forEach {
        println("$it : ${it.length}")
    }
    println("\n\n================================\n\n")
    strNonMatching.forEach {
        println("$it : ${it.length}")
    }
}