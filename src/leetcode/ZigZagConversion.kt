package leetcode

fun main() {
    val s = "PAYPALISHIRING"
    val numRows = 3
    println(zigzagConversion(s = s, numRows = numRows)) //PAHNAPLSIIGYIR
}

fun zigzagConversion(s: String, numRows: Int) : String {
    if(numRows == 1) return s

    val result = StringBuilder()
    val n = s.length

    val increment = 2 * (numRows - 1)

    for (row in 0 until numRows) {
        for(i in row until n step increment) {
            result.append(s[i])

            //Dealing with middle rows
            if(row > 0 && row < (numRows - 1) && ((i + increment) - (2 * row)) < n) {
                result.append(s[((i + increment) - (2 * row))])
            }
        }
    }


    return result.toString()
}