import kotlin.math.sin

fun main() {
    println(multiplicationTable(3).toString())
    println(multiplicationTable(5).toString())
}

fun multiplicationTable(size: Int): Array<IntArray> {
    val tableBySize = mutableListOf<IntArray>()
    for (i in 1..size) {
        val singleTable = mutableListOf<Int>()
        for (j in 1..size) {
            singleTable.add(i * j)
        }
        tableBySize.add(singleTable.toIntArray())
    }
    return tableBySize.toTypedArray()
}

fun multiplicationTableEff3(size: Int): Array<IntArray> {
    val tableBySize = Array(size) { IntArray(size) }

    for (i in 1..size)
        for (j in 1..size)
            tableBySize[i - 1][j - 1] = i * j

    return tableBySize
}

fun multiplicationTableEff(size: Int) = Array(size) { x -> IntArray(size) { y -> (x + 1) * (y + 1) } }
fun multiplicationTableEff2(size: Int) = Array(size){i -> IntArray(size){(it + 1) * (i + 1)}}
