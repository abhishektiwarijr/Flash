import java.io.File

fun main() {
    var sum = 0
    val sumArray = mutableListOf<Int>()
    File("src/calories_input.txt").forEachLine {
        if(it == "") {
            sumArray.add(sum)
            sum = 0
        } else {
            sum += it.toInt()
        }
    }
    println(sumArray.max())
}