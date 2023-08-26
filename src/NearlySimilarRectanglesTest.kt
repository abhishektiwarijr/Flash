fun main() {
    println(
        nearlySimilarRectangles(
            arrayOf(
                arrayOf<Long>(4, 8),
                arrayOf<Long>(15, 30),
                arrayOf<Long>(25, 50),
            )
        )
    )

    println(
        nearlySimilarRectangles(
            arrayOf(
                arrayOf<Long>(2, 1),
                arrayOf<Long>(10, 7),
                arrayOf<Long>(9, 5),
                arrayOf<Long>(6, 9),
                arrayOf<Long>(7, 3),
            )
        )
    )
}

fun nearlySimilarRectangles(sides: Array<Array<Long>>): Long {
    if(sides.isEmpty() || sides.size > Math.pow(10.0, 5.0)) return 0

    var i = 0
    var j = 1
    var nearlySimilarRectangles = 0L
    while (i < sides.lastIndex) {
        val first = sides[i]
        val second = sides[j]
        if ((first[0].toDouble() / second[0]) == (first[1].toDouble() / second[1])) {
            nearlySimilarRectangles++
        }
        if (j == sides.lastIndex) {
            i++
            j = i + 1
        } else {
            j++
        }
    }
    return nearlySimilarRectangles
}