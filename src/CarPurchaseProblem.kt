import kotlin.math.roundToInt

fun main() {
//    println(nbMonths(2000, 8000, 1000, 1.5))
    println(nbMonths(7500, 32000, 300, 1.55))
    //should return [6, 766] or (6, 766)
}

fun nbMonths(
    startPriceOld: Int,
    startPriceNew: Int,
    savingperMonth: Int,
    percentLossByMonth: Double
): Pair<Int, Int> {
    return if (startPriceOld >= startPriceNew) {
        Pair(0, startPriceOld - startPriceNew)
    } else {
        var myStartPriceOld: Double = startPriceOld.toDouble()
        var myStartPriceNew: Double = startPriceNew.toDouble()
        var myPercentLossByMonth = percentLossByMonth
        var noOfMonths = 0
        var availableMoney: Double
        do {
            noOfMonths++
            if (noOfMonths % 2 == 0) { myPercentLossByMonth += 0.5 }
            myStartPriceOld -= (myStartPriceOld * myPercentLossByMonth / 100)
            myStartPriceNew -= myStartPriceNew * myPercentLossByMonth / 100
            val myMoney = myStartPriceOld + (savingperMonth * noOfMonths)
            availableMoney = myMoney - myStartPriceNew
        } while (availableMoney < 0)
        Pair(noOfMonths, availableMoney.roundToInt())
    }
}

fun nbMonths1(
    startPriceOld: Int,
    startPriceNew: Int,
    savingperMonth: Int,
    percentLossByMonth: Double
): Pair<Int, Int> {
    var month = 0
    var decreaseRate: Double = 1 - (percentLossByMonth / 100)
    var newPriceOld: Double = startPriceOld.toDouble()
    var newPriceNew: Double = startPriceNew.toDouble()

    while (month * savingperMonth + newPriceOld < newPriceNew){
        month++
        if (month % 2 == 0) decreaseRate -= 0.005
        newPriceOld *= decreaseRate
        newPriceNew *= decreaseRate
    }

    return Pair(month, (month * savingperMonth + newPriceOld - newPriceNew).roundToInt())

}