fun interface MakeCoffee {
    operator fun invoke(sugarAmount: Double, milkAmount: Double, coffeeAmount: Double)
}

fun makeCoffee(sugarAmount: Double, milkAmount: Double, coffeeAmount: Double) {
    //TODO Some implementation
}

/**
 * How do you return your makeCoffee as MakeCoffee?
 */
fun main() {
    
}

/**
 * Solution
 */
fun provideMakeCoffee(): MakeCoffee = MakeCoffee(::makeCoffee)