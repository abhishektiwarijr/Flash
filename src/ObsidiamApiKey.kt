fun main() {
    val x = "C0lt3f1n4nci3r4_S3cr3t_P4ssw0rd1".chunked(4).toMutableList()
    var start = 0
    var size = x.size
    val str = StringBuilder("")
    for (i in x.indices) {
        if (i < 4) {
            if (i % 2 == 0) {
                str.append(x[size-- - 1])
            } else {
                str.append(x[start++])
            }
        } else {
            if (i % 2 == 0) {
                str.append(x[start++])
            } else {
                str.append(x[size-- - 1])
            }
        }
    }
    println(str)
    val y = str.chunked(4).toMutableList()
    val strY = StringBuilder("")
    strY.append(y[1])
    strY.append(y[3])
    strY.append(y[4])
    strY.append(y[6])
    strY.append(y[7])
    strY.append(y[5])
    strY.append(y[2])
    strY.append(y[0])

    println(strY)
}