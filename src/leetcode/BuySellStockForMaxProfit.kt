package leetcode

fun main() {
//    val inputPrices = intArrayOf(7, 1, 5, 3, 6, 4)
    val inputPrices = intArrayOf(1,2,4,2,5,7,2,4,9,0,9)
//    val inputPrices = intArrayOf(7, 6, 4, 3, 1)
    println(buySellStockForMaxProfit(inputPrices))
}

fun buySellStockForMaxProfit(prices: IntArray): Int {
    var maxProfit = 0
    var buyPriceIndex = 0
    var sellPriceIndex = 1

    while (sellPriceIndex < prices.size) {
        if (prices[buyPriceIndex] < prices[sellPriceIndex]) {
            maxProfit = Math.max(prices[sellPriceIndex] - prices[buyPriceIndex], maxProfit)
        } else {
            buyPriceIndex = sellPriceIndex
        }
        sellPriceIndex++
    }

    return maxProfit
}
