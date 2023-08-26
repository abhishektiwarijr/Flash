
val multipleOf7 = "^(0|(10((0|11)(1|00))*(10|(0|11)01)|11)(01*0(0|101|1(1|00)((0|11)(1|00))*(10|(0|11)01)))*1)+$"
fun main() {
    println(closest(strng = "103 123 4444 99 2000").contentDeepToString())
    println(closest(strng = "294748 92 236912 86 185687 30 233059 2 87792 154 8").contentDeepToString())
    println(closest(strng = "80 71 62 53").contentDeepToString())
    println(closest(strng = "202174 186 177039 94 189002 66 94235 112 326314 66 48").contentDeepToString())
}
fun closest(strng: String): Array<IntArray> {
    val strngArray = strng.split(" ")
    val weighted = strngArray.mapIndexed { index, i -> intArrayOf(i.toCharArray().sumOf { num -> num - '0' }, index, i.toInt()) }.sortedWith(compareBy({ it[0] }, { it[1] }))
    val diff = (0 until weighted.size - 1).minByOrNull { Math.abs(weighted[it + 1][0] - weighted[it][0]) }
    return weighted.slice(diff!!..diff + 1).toTypedArray()
}