fun main() {
    println(findNb(56396345062501)) //-1
    println(findNb(6132680780625)) //2225
    println(findNb(28080884739601)) //-1
}

fun findNb(m: Long): Long {
    var n = 0L
    var total = 0L

    while (total < m) {
        n += 1
        total += Math.pow(n.toDouble(), 3.0).toLong()
    }

    return if (total == m) {
        n
    } else -1
}

fun findNbEff(m: Long): Long {
    var n: Long = 0
    var cubeSize: Long = 0
    while (cubeSize < m) {
        cubeSize += n * n * n
        n++
    }
    return if (cubeSize == m) n - 1 else -1
}

fun findNbEff2(m: Long): Long {
    var sum = 0L
    return generateSequence(1L) { it + 1 }
        .onEach { sum += it*it*it }
        .takeWhile { sum <= m }
        .lastOrNull { sum == m }
        ?: -1
}

//48.0+38.9+39.9+42.2+47.3+52.1+59.5+57.2+55.4+62.0+59.0+52.9
//      "London: 48.0,38.9,39.9,42.2,47.3,52.1,59.5,57.2,55.4,62.0,59.0,52.9"
//      "London: 58.0,38.9,49.9,42.2,67.3,52.1,59.5,77.2,55.4,62.0,69.0,52.9" +