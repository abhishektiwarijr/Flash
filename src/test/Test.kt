package test

fun main() {
    println(getTotalPriceByOrder(listOf(1, 2, 3, 4, 5), listOf(5, 20, 50, 75, 90)))
}

private fun getTotalPriceByOrder(productIds: List<Long>, quantities: List<Long>): Float {
    var totalPrice = 0L
    productIds.forEachIndexed { index, productId ->
        val quantity = quantities[index]
        totalPrice += when {
            (quantity < 10) -> { //If the customer buys less than 10 items of a product, the price is $10 per item.
                (quantity * 10)
            }

            (quantity in 10..50) -> { //If the customer buys between 10 and 50 items of a product, the price is $9 per item.
                (quantity * 9)
            }

            else -> { //If the customer buys more than 50 items of a product, the price is $8 per item.
                (quantity * 8)
            }
        }
    }

    return if (totalPrice > 100) { //If the total value of the order is more than $100, the customer is eligible for a 10% discount.
        (totalPrice * 0.9f)
    } else {
        totalPrice.toFloat()
    }
}