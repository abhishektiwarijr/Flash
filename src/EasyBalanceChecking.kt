import java.math.RoundingMode
import java.text.DecimalFormat

fun main() {
    val b3 = "1781.00\n" +
            "001 Books ;! 24.81 ?;\n" +
            "002 Beauty  3.20 \n" +
            "003 Flowers  19.00 \n" +
            "004 Picture  12.00 \n" +
            "005 Perfume  128.00 \n" +
            "006 Meat ;! 12.22 ?;\n" +
            "007 Meat ;! 12.00 ?;\n" +
            "008 Video  11.00 \n" +
            "009 Photos  3.20 \n" +
            "010 Pen  120.90 \n" +
            "1132.00\n" +
            "001 Fruits  17.00 \n" +
            "002 Car ;! 93.50 ?;\n" +
            "003 Tyres ;! 12.22 ?;\n" +
            "004 Video ;! 12.22 ?;\n" +
            "005 Music  128.00 \n" +
            "006 Music ;! 13.65 ?;\n" +
            "1002.00\n" +
            "001 Books  12.22 \n" +
            "002 Grocery  120.30 \n" +
            "003 Photos ;! 20.00 ?;\n" +
            "004 Flowers ;! 11.00 ?;\n" +
            "005 Vegetables ;! 34.00 ?;\n" +
            "006 Music  3.20 \n" +
            "007 Perfume ;! 17.60 ?;\n" +
            "008 Grocery ;! 12.22 ?;\n" +
            "1329.00\n" +
            "001 Beauty ;! 54.00 ?;\n" +
            "002 Hairdresser  93.50 \n" +
            "003 Stamps ;! 19.00 ?;\n" +
            "004 Fruits ;! 120.30 ?;\n" +
            "005 Beauty  110.73 \n" +
            "006 Picture ;! 19.00 ?;\n" +
            "007 Pen ;! 54.00 ?;\n" +
            "008 Video ;! 19.00 ?;\n" +
            "009 Picture ;! 24.81 ?;\n" +
            "833.00\n" +
            "001 Car ;! 13.10 ?;\n" +
            "002 Gasoline  3.20 \n" +
            "003 Beauty ;! 17.00 ?;\n" +
            "004 Vegetables ;! 93.50 ?;\n" +
            "005 Gasoline ;! 11.00 ?;\n" +
            "006 Video ;! 17.00 ?;\n" +
            "007 Market  34.00 \n" +
            "008 Pen  11.00 \n" +
            "009 Meat  120.30 \n" +
            "010 Grocery  128.00 \n" +
            "1235.00\n" +
            "001 Music ;! 17.50 ?;\n" +
            "002 Tyres ;! 93.50 ?;\n" +
            "003 Photos  12.22 \n" +
            "004 Car  24.81 \n" +
            "005 Hairdresser  120.30 \n" +
            "1971.00\n" +
            "001 Vegetables  17.00 \n" +
            "002 Meat  13.65 \n" +
            "003 Fruits ;! 71.41 ?;\n" +
            "004 Tyres  11.00 \n" +
            "005 Perfume  120.90 \n" +
            "006 Books ;! 110.73 ?;\n" +
            "007 Perfume ;! 24.81 ?;\n" +
            "008 Books  17.60 \n" +
            "009 Music ;! 110.73 ?;\n" +
            "010 Stamps  120.90 \n" +
            "1372.00\n" +
            "001 Stamps  120.90 \n" +
            "002 Fruits ;! 34.00 ?;\n" +
            "003 Pen  12.00 \n" +
            "004 Photos ;! 20.00 ?;\n" +
            "005 Photos  17.60 \n" +
            "006 Fruits  93.50 \n" +
            "007 Books  128.00 \n" +
            "008 Market ;! 20.00 ?;\n" +
            "009 Pen ;! 93.50 ?;\n" +
            "010 Car ;! 120.90 ?;\n" +
            "1390.00\n" +
            "001 Perfume  120.30 \n" +
            "002 Gasoline ;! 24.81 ?;\n" +
            "003 Meat ;! 120.30 ?;\n" +
            "004 Picture ;! 19.00 ?;\n" +
            "005 Flowers ;! 17.50 ?;\n" +
            "006 Perfume ;! 11.00 ?;\n" +
            "007 Hairdresser ;! 93.50 ?;\n" +
            "1197.00\n" +
            "001 Stamps ;! 20.00 ?;\n" +
            "002 Car ;! 19.00 ?;\n" +
            "003 Pen  54.00 \n" +
            "004 Picture  110.73 \n" +
            "005 Gasoline  128.00 \n" +
            "1815.00\n" +
            "001 Flowers ;! 120.90 ?;\n" +
            "002 Photos ;! 24.81 ?;\n" +
            "003 Tyres ;! 12.00 ?;\n" +
            "004 Fruits ;! 12.00 ?;\n" +
            "005 Video  24.81 \n" +
            "006 Gasoline ;! 13.65 ?;\n" +
            "007 Flowers ;! 19.00 ?;\n" +
            "008 Perfume  24.81 \n" +
            "009 Photos ;! 24.81 ?;\n" +
            "1946.00\n" +
            "001 Market  120.90 \n" +
            "002 Perfume ;! 12.00 ?;\n" +
            "003 Pen  34.00 \n" +
            "004 Music ;! 13.65 ?;\n" +
            "005 Photos  13.10 \n" +
            "006 Photos ;! 13.65 ?;\n" +
            "007 Gasoline  12.00 \n" +
            "008 Fruits ;! 17.50 ?;\n" +
            "009 Tyres  17.00 \n" +
            "1894.00\n" +
            "001 Video ;! 71.41 ?;\n" +
            "002 Stamps ;! 12.00 ?;\n" +
            "003 Hardware  128.00 \n" +
            "004 Picture ;! 11.00 ?;\n" +
            "005 Music ;! 24.81 ?;\n" +
            "006 Music ;! 19.00 ?;\n" +
            "007 Gasoline  17.50 \n" +
            "1827.00\n" +
            "001 Photos ;! 120.90 ?;\n" +
            "002 Stamps ;! 17.00 ?;\n" +
            "003 Beauty  54.00 \n" +
            "004 Flowers  17.60 \n" +
            "005 Vegetables ;! 120.30 ?;\n" +
            "006 Hardware ;! 17.60 ?;\n" +
            "007 Perfume  110.73 \n" +
            "008 Stamps  120.90 \n" +
            "009 Fruits ;! 3.20 ?;\n" +
            "010 Market ;! 71.41 ?;\n" +
            "1102.00\n" +
            "001 Grocery ;! 11.00 ?;\n" +
            "002 Stamps ;! 110.73 ?;\n" +
            "003 Meat  19.00 \n" +
            "004 Music  13.65 \n" +
            "005 Vegetables ;! 120.30 ?;\n" +
            "006 Stamps ;! 12.00 ?;\n" +
            "007 Music  12.22 \n" +
            "008 Photos  24.81 \n" +
            "1607.00\n" +
            "001 Picture ;! 19.00 ?;\n" +
            "002 Tyres ;! 13.10 ?;\n" +
            "003 Beauty ;! 20.00 ?;\n" +
            "004 Photos ;! 24.81 ?;\n" +
            "005 Tyres ;! 120.90 ?;\n" +
            "006 Books  13.10 \n" +
            "007 Video  20.00 \n" +
            "008 Market  13.10 \n" +
            "009 Hairdresser ;! 17.50 ?;\n" +
            "010 Video ;! 93.50 ?;\n" +
            "1890.00\n" +
            "001 Video  13.65 \n" +
            "002 Pen ;! 12.00 ?;\n" +
            "003 Beauty ;! 13.10 ?;\n" +
            "004 Music ;! 11.00 ?;\n" +
            "005 Flowers ;! 20.00 ?;\n" +
            "1374.00\n" +
            "001 Video  120.30 \n" +
            "002 Hardware ;! 11.00 ?;\n" +
            "003 Fruits ;! 20.00 ?;\n" +
            "004 Hardware  17.60 \n" +
            "005 Stamps  13.10 \n" +
            "006 Car  3.20 \n" +
            "823.00\n" +
            "001 Grocery  120.30 \n" +
            "002 Fruits ;! 128.00 ?;\n" +
            "003 Meat  17.00 \n" +
            "004 Vegetables  17.60 \n" +
            "005 Meat  110.73 \n" +
            "1115.00\n" +
            "001 Hairdresser ;! 34.00 ?;\n" +
            "002 Hardware  13.10 \n" +
            "003 Beauty ;! 17.60 ?;\n" +
            "004 Pen  110.73 \n" +
            "005 Stamps ;! 19.00 ?;\n" +
            "006 Picture ;! 71.41 ?;\n" +
            "007 Gasoline  12.00 \n" +
            "1063.00\n" +
            "001 Beauty ;! 3.20 ?;\n" +
            "002 Hardware  34.00 \n" +
            "003 Perfume  17.60 \n" +
            "004 Perfume  120.90 \n" +
            "005 Stamps  19.00 \n" +
            "006 Hardware  120.30 \n" +
            "007 Video  128.00 \n" +
            "008 Stamps  12.22 \n" +
            "009 Photos ;! 24.81 ?;\n" +
            "010 Hairdresser  34.00 \n" +
            "826.00\n" +
            "001 Grocery ;! 17.60 ?;\n" +
            "002 Hardware ;! 12.22 ?;\n" +
            "003 Fruits ;! 17.00 ?;\n" +
            "004 Video  19.00 \n" +
            "005 Video ;! 93.50 ?;\n" +
            "006 Gasoline  13.65 \n" +
            "007 Vegetables ;! 3.20 ?;\n" +
            "008 Perfume ;! 19.00 ?;\n" +
            "009 Meat  128.00 \n" +
            "1285.00\n" +
            "001 Music  120.90 \n" +
            "002 Car  128.00 \n" +
            "003 Fruits  13.10 \n" +
            "004 Perfume ;! 13.65 ?;\n" +
            "005 Music  17.60 \n" +
            "006 Tyres  34.00 \n" +
            "007 Car  11.00 \n" +
            "008 Car ;! 34.00 ?;\n" +
            "1005.00\n" +
            "001 Pen ;! 54.00 ?;\n" +
            "002 Music ;! 17.60 ?;\n" +
            "003 Flowers ;! 13.65 ?;\n" +
            "004 Vegetables  12.22 \n" +
            "005 Vegetables  24.81 \n" +
            "006 Gasoline ;! 12.00 ?;\n" +
            "007 Tyres  3.20 \n" +
            "008 Stamps ;! 20.00 ?;\n" +
            "009 Beauty  20.00 \n" +
            "010 Stamps  3.20 \n" +
            "1671.00\n" +
            "001 Music ;! 54.00 ?;\n" +
            "002 Picture  13.65 \n" +
            "003 Beauty ;! 110.73 ?;\n" +
            "004 Hardware ;! 13.65 ?;\n" +
            "005 Beauty  24.81 \n" +
            "006 Video  17.50 \n" +
            "007 Beauty  11.00 \n" +
            "008 Market ;! 110.73 ?;\n" +
            "1366.00\n" +
            "001 Photos  13.65 \n" +
            "002 Flowers ;! 34.00 ?;\n" +
            "003 Car ;! 54.00 ?;\n" +
            "004 Music ;! 24.81 ?;\n" +
            "005 Gasoline  24.81 \n" +
            "006 Grocery ;! 12.22 ?;\n" +
            "007 Perfume ;! 24.81 ?;\n" +
            "008 Pen  93.50"

    val b0 = "1647.00\n" +
            "001 Picture  12.00 \n" +
            "002 Market ;! 13.10 ?;\n" +
            "003 Pen  93.50 \n" +
            "004 Gasoline  19.00 \n" +
            "005 Pen ;! 13.65 ?;"
    val b1 =
        "1000.00!=\n125 Market !=:125.45\n126 Hardware =34.95\n127 Video! 7.45\n128 Book :14.32\n129 Gasoline ::16.10\n"
    val b1sol =
        "Original Balance: 1000.00\\r\\n125 Market 125.45 Balance 874.55\\r\\n126 Hardware 34.95 Balance 839.60\\r\\n127 Video 7.45 Balance 832.15\\r\\n128 Book 14.32 Balance 817.83\\r\\n129 Gasoline 16.10 Balance 801.73\\r\\nTotal expense  198.27\\r\\nAverage expense  39.65"
    val b2 =
        "1233.00\n125 Hardware;! 24.80?\n123 Flowers 93.50;\n127 Meat 120.90\n120 Picture 34.00\n124 Gasoline 11.00\n" + "123 Photos;! 71.40?\n122 Picture 93.50\n132 Tyres;! 19.00,?;\n129 Stamps; 13.60\n129 Fruits{} 17.60\n129 Market;! 128.00?\n121 Gasoline;! 13.60?"
    val b2sol =
        "Original Balance: 1233.00\r\n125 Hardware 24.80 Balance 1208.20\r\n123 Flowers 93.50 Balance 1114.70\r\n127 Meat 120.90 Balance 993.80\r\n120 Picture 34.00 Balance 959.80\r\n124 Gasoline 11.00 Balance 948.80\r\n123 Photos 71.40 Balance 877.40\r\n122 Picture 93.50 Balance 783.90\r\n132 Tyres 19.00 Balance 764.90\r\n129 Stamps 13.60 Balance 751.30\r\n129 Fruits 17.60 Balance 733.70\r\n129 Market 128.00 Balance 605.70\r\n121 Gasoline 13.60 Balance 592.10\r\nTotal expense  640.90\r\nAverage expense  53.41"
//    println(balance(b0))
//    println(balance(b1))
    println(balance(b3))
//    println(b0)
}

fun balance(book: String): String {
    var total = 0.0
    val spaceRegex = "\\s+".toRegex()
    val amountRegex = "\\d+\\.?\\d?".toRegex()
    val lines = book.trim().replace(Regex("""[^\w\d\s.]"""), "").split("\n")
    var balance = amountRegex.find(lines.first())?.value?.toDoubleOrNull() ?: 0.0
    val result = mutableListOf<String>()

    result.add("Original Balance: ${formatRounded(balance)}")

    for (line in lines.drop(1)) {

        val (checkNumber, category, amount) = line.split(spaceRegex)
        balance -= amount.toDouble()
        total += amount.toDouble()

        result.add("$checkNumber $category $amount Balance ${formatRounded(balance)}")
    }

    val average = total / (lines.size - 1)
    result.add("Total expense  ${formatRounded(total)}")
    result.add("Average expense  ${formatRounded(average)}")

    return result.joinToString("\\r\\n")
}

private fun formatRounded(balance: Double) = String.format("%.2f", balance)

//val df = DecimalFormat("0").apply {
////    roundingMode = RoundingMode.HALF_DOWN
//    maximumFractionDigits = 2
//    minimumFractionDigits = 2
//}
//fun Float.format() = df.format(this).toFloat()


