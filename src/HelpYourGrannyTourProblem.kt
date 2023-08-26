fun main() {
    val friends1 = arrayOf("A1", "A2", "A3", "A4", "A5", "A6")
    val fTowns1 = arrayOf(
        arrayOf("A1", "X1"),
        arrayOf("A2", "X2"),
        arrayOf("A3", "X3"),
        arrayOf("A4", "X4"),
        arrayOf("A5", "X5")
    )
    val distTable1: MutableMap<String, Double> = HashMap()
    distTable1["X1"] = 100.0
    distTable1["X2"] = 200.0
    distTable1["X3"] = 250.0
    distTable1["X4"] = 300.0
    distTable1["X5"] = 320.0
    println(tour(friends1, fTowns1, distTable1))

    //Test 2
    val friends2 = arrayOf("B1", "B2")
    val fTowns2 = arrayOf(
        arrayOf("B1", "Y1"),
        arrayOf("B2", "Y2"),
        arrayOf("B3", "Y3"),
        arrayOf("B4", "Y4"),
        arrayOf("B5", "Y5")
    )
    val distTable2: MutableMap<String, Double> = HashMap()
    distTable2["Y1"] = 50.0
    distTable2["Y2"] = 70.0
    distTable2["Y3"] = 90.0
    distTable2["Y4"] = 110.0
    distTable2["Y5"] = 150.0

    println(tour(friends2, fTowns2, distTable2))
}

fun tour(arrFriends: Array<String>, ftwns: Array<Array<String>>, h: Map<String, Double>): Int {
    var sum = 0.0
    val availableTowns = mutableListOf<String>()
    arrFriends.map { f ->
        ftwns.forEach { ft ->
            if (f == ft[0]) {
                availableTowns.add(ft[1])
            }
        }
    }

    availableTowns.forEachIndexed { index, value ->
        when (index) {
            0 -> {
                sum += h[value]!!
            }

            availableTowns.lastIndex -> {
                val hyp = h[value]!!
                val per = h[availableTowns[index - 1]]!!
                val base = Math.sqrt(Math.pow(hyp, 2.0) - Math.pow(per, 2.0))
                sum += base
                sum += h[value]!!
            }

            else -> {
                val hyp = h[value]!!
                val per = h[availableTowns[index - 1]]!!
                val base = Math.sqrt(Math.pow(hyp, 2.0) - Math.pow(per, 2.0))
                sum += base
            }
        }
    }

    return sum.toInt()
}

fun tour1(arrFriends: Array<String>, ftwns: Array<Array<String>>, h: Map<String, Double>): Int {

    val towns = ftwns.map { Pair(it[0], it[1]) }.toMap()
    val visits = arrFriends.mapNotNull { towns.get(it) }
    val distances = visits.mapNotNull { h.get(it) }.toMutableList().apply { add(last()) }
    val circuit = mutableListOf<Double>().apply { addAll(distances) }

    if (distances.size > 1) (1..distances.size - 2).forEach { ind ->
        val a = distances[ind - 1]
        val c = distances[ind]
        val b = Math.sqrt(c * c - a * a)
        circuit[ind] = b
    }
    return circuit.sum().toInt()
}

fun tour2(arrFriends: Array<String>, ftwns: Array<Array<String>>, h: Map<String, Double>) =
    ftwns.filter { it.first() in arrFriends }.map { it.last() }.let { ft ->
        (ft.windowed(2).map { (h[it.last()]!!.sqr() - h[it.first()]!!.sqr()).sqrt() }
            .sum() + h[ft.first()]!! + h[ft.last()]!!).toInt()
    }

fun Double.sqr() = this * this
fun Double.sqrt() = Math.sqrt(this)
