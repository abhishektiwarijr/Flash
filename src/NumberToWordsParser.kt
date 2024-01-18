import kotlin.math.absoluteValue

const val QUADRILLION = 1_000_000_000_000_000
const val TRILLION = 1_000_000_000_000
const val BILLION = 1_000_000_000
const val MILLION = 1_000_000
const val THOUSAND = 1_000

fun main() {
    println(convertNumberToWords(0))
    println(convertNumberToWords(1))
    println(convertNumberToWords(16))
    println(convertNumberToWords(45))
    println(convertNumberToWords(99))
    println(convertNumberToWords(100))
    println(convertNumberToWords(118))
    println(convertNumberToWords(123))
    println(convertNumberToWords(200))
    println(convertNumberToWords(219))
    println(convertNumberToWords(500))
    println(convertNumberToWords(800))
    println(convertNumberToWords(999))
    println(convertNumberToWords(1_000))
    println(convertNumberToWords(1_100))
    println(convertNumberToWords(-1100))
    println(convertNumberToWords(1_123))
    println(convertNumberToWords(1_500))
    println(convertNumberToWords(1_999))
    println(convertNumberToWords(2_000))
    println(convertNumberToWords(9_000))
    println(convertNumberToWords(9_876))
    println(convertNumberToWords(9_999))
    println(convertNumberToWords(10_000))
    println(convertNumberToWords(10_001))
    println(convertNumberToWords(700_000))
    println(convertNumberToWords(1_000_000))
    println(convertNumberToWords(2_000_000))
    println(convertNumberToWords(3_000_200))
    println(convertNumberToWords(9_000_000))
    println(convertNumberToWords(9_001_000))
    println(convertNumberToWords(123_456_789))
    println(convertNumberToWords(1_234_567_890))
    println(convertNumberToWords(2_147_483_647))
    println(convertNumberToWords(3_000_000_010L))
    println(convertNumberToWords(3_123_123_123_123L))
    println(convertNumberToWords(321_123_123_123_123L))
    println(convertNumberToWords(1_321_123_123_123_123L))
}

fun convertNumberToWords(num: Long): String {
    var number = num
    if (number == 0L) return "Zero"

    val result = StringBuilder()

    //In case of negative number
    if (number < 0) {
        result.append("Minus ")
        number = number.absoluteValue
    }

    val quadrillion = number / QUADRILLION
    val trillion = (number % QUADRILLION) / TRILLION
    val billion = (number % TRILLION) / BILLION
    val million = (number % BILLION) / MILLION
    val thousand = (number % MILLION) / THOUSAND
    val remainder = number % THOUSAND

    if (quadrillion > 0) {
        result.append("${convertToWordsLessThanThousands(quadrillion)} Quadrillion ")
    }

    if (trillion > 0) {
        result.append("${convertToWordsLessThanThousands(trillion)} Trillion ")
    }

    if (billion > 0) {
        result.append("${convertToWordsLessThanThousands(billion)} Billion ")
    }

    if (million > 0) {
        result.append("${convertToWordsLessThanThousands(million)} Million ")
    }

    if (thousand > 0) {
        result.append("${convertToWordsLessThanThousands(thousand)} Thousand ")
    }

    if (remainder > 0) {
        result.append(convertToWordsLessThanThousands(remainder))
    }

    return result.toString().trim()
}

val units = arrayOf("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine")
val teens = arrayOf(
    "Ten",
    "Eleven",
    "Twelve",
    "Thirteen",
    "Fourteen",
    "Fifteen",
    "Sixteen",
    "Seventeen",
    "Eighteen",
    "Nineteen"
)
val tens = arrayOf("Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety")

fun convertToWordsLessThanThousands(number: Long): String {
    val hundred = number / 100
    val remainder = number % 100

    val result = StringBuilder()

    if (hundred > 0) {
        result.append("${units[(hundred - 1).toInt()]} Hundred ")
    }

    if (remainder in 10..19) {
        result.append(teens[(remainder - 10).toInt()])
    } else {
        if (remainder >= 20) {
            result.append("${tens[(remainder / 10 - 2).toInt()]} ")
        }

        if (remainder % 10 > 0) {
            result.append(units[(remainder % 10 - 1).toInt()])
        }
    }

    return result.toString().trim()
}