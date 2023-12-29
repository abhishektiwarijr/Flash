fun main() {
    println(spiralize(5).contentDeepToString())
}

const val ONE = 1.toByte()

fun spiralizeEff(n: Int): Array<ByteArray> {
    val result = Array(n) { ByteArray(n) }

    var x = 0
    var y = 0
    var mode = 1 // 0 move left, 1 move right, 2 move down, 3 move up
    var isDone = false
    var noSteps = false

    while (!isDone) {
        when (mode) {
            0 -> if ((x > 0 && (result[y][x - 1] == ONE || result[y - 1][x - 1] == ONE)) || x < 0) {
                x++
                mode = 3
                isDone = noSteps
                noSteps = true
            } else {
                noSteps = false
                result[y][x--] = ONE
            }
            1 -> if ((x < n - 1 && (result[y][x + 1] == ONE || result[y + 1][x + 1] == ONE)) || x >= n)  {
                x--
                mode = 2
                isDone = noSteps
                noSteps = true
            } else {
                noSteps = false
                result[y][x++] = ONE
            }
            2 -> if ((y < n - 1 && result[y + 1][x] == ONE) || y >= n) {
                y--
                mode = 0
                isDone = noSteps
                noSteps = true
            } else {
                noSteps = false
                result[y++][x] = ONE
            }
            3 -> if ((y > 0 && result[y - 1][x] == ONE) || y < 0) {
                y++
                mode = 1
                isDone = noSteps
                noSteps = true
            } else {
                noSteps = false
                result[y--][x] = ONE
            }
        }
    }

    return result

}
fun spiralize(n: Int): Array<ByteArray> {
    val result = Array(n) { ByteArray(n) { 0 } }

    var i = n
    var j = 0

    do {
        if (j > 0) result[j][j-1] = 1
        for (i1 in j until i) result[j][i1] = 1
        for (i1 in j until i) result[i1][i-1] = 1
        for (i1 in i - 1 downTo j + 1) result[i - 1][i1] = 1
        for (i1 in i - 1 downTo j + 2) result[i1][j] = 1

        i-=2
        j+=2
    } while (i > j)

    return result
}