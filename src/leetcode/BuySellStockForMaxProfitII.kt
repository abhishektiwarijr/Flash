package leetcode

fun main() {
    val prices = intArrayOf(7, 1, 5, 3, 6, 4)
    println("Maximum Profit is : ${bestTimeToBuyAndSellStockForMaximumProfit2(prices)}")

    val prices2 = intArrayOf(1,2,3,4,5)
    println("Maximum Profit is : ${maxProfit(prices2)}")
}

/**
 * This solution is based on the best solution from Leetcode
 */
fun maxProfit(prices: IntArray): Int {
    var profit = 0
    for (i in 1..prices.lastIndex) {
        if (prices[i] > prices[i - 1]) {
            profit += prices[i] - prices[i - 1]
        }
    }
    return profit
}

/**
 * I came up with this solution, doesn't seem fancy I know 😅
 */
fun bestTimeToBuyAndSellStockForMaximumProfit2(prices: IntArray): Int {
    //Pick the first minimum and buy
    //Sell at first maximum unless you hit a new minimum
    //If you hit a new minimum then repeat

    var totalProfit = 0
    var currentMaxProfit = 0

    var buyIndex = 0
    var sellIndex = 1

    while (sellIndex < prices.size) {
        if(prices[buyIndex] < prices[sellIndex]) {
            currentMaxProfit = Math.max(currentMaxProfit, prices[sellIndex] - prices[buyIndex])
            val nextBreakThrough = (sellIndex + 1) < prices.size && prices[sellIndex + 1] < prices[sellIndex]
            if(nextBreakThrough) {
                totalProfit += currentMaxProfit
                currentMaxProfit = 0
                buyIndex = sellIndex + 1
                sellIndex++
            }
        } else {
            buyIndex = sellIndex
        }
        sellIndex++
    }


    return totalProfit + currentMaxProfit
}