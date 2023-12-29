package binjola

fun main() {
    val myShop = Shop(
        "Etsy", listOf<Customer>(
            Customer(
                "Abhishek", City("Noida"), listOf<Order>(
                    Order(
                        listOf<Product>(
                            Product("A", 100.0),
                            Product("B", 80.0),
//                            Product("C", 90.0),
//                            Product("D", 110.0),
                        ), true
                    )
                )
            ),
            Customer(
                "Anurag", City("Delhi"), listOf<Order>(
                    Order(
                        listOf<Product>(
                            Product("A", 100.0),
                            Product("B", 80.0),
                            Product("C", 90.0),
                        ), true
                    )
                )
            ),
            Customer(
                "Adarsh", City("Gurugram"), listOf<Order>(
                    Order(
                        listOf<Product>(
                            Product("A", 100.0),
                            Product("B", 80.0),
                        ), true
                    )
                )
            )
        )
    )
    myShop.`Return all products that were ordered by at least 1 customer`().forEach {
        println(it.name)
    }
}

//1.
fun Shop.`Return the list of customers , sorted in descending by no of orders they have made`(): List<Customer> {
    return customers.sortedByDescending { it.orders.size }
}

//2.
fun Shop.`Find all the different cities the customers are from`(): Set<City> {
    return customers.map { it.city }.toSet()
}

//3.
fun Shop.`Find the customers living in a given city`(city: City): List<Customer> {
    return customers.filter { it.city.name == city.name }
}

//4.
fun Shop.`Return true if all customers are from given city`(city: City): Boolean {
    return customers.all { it.city.name == city.name }
}

//5.
fun Shop.`Return true if there is at least one customer from a given city`(city: City): Boolean {
    return customers.any { it.city.name == city.name }
}

//6.
fun Shop.`Return the number of customers from a given city`(city: City): Int {
    return customers.count { it.city.name == city.name }
}

//7.
fun Shop.`Return a customer who lives in a given city , or null if there is none`(city: City): Customer? {
    return customers.find { it.city.name == city.name }
}

//8.
fun Shop.`Return a customer who has placed the maximum amount of orders`(): Customer? {
    return customers.maxByOrNull { it.orders.count() }
}

//9.
fun `Return the most expensive product that has been ordered by the given customer`(customer: Customer): Product? {
    return customer.orders.flatMap { it.products }.maxByOrNull { it.price }
}

//10.
fun `Return sum of prices for all the products ordered by a given customer`(customer: Customer): Double {
    return customer.orders.flatMap { it.products }.sumOf { it.price }
}

//11.
fun Shop.`Build a map from the customer name to the customer`(): Map<String, Customer> {
    return customers.associateBy { it.name }
}

//12.
fun Shop.`Build a map from the customer to their city`(): Map<Customer, City> {
    return customers.associateWith { it.city }
}

//13.
fun Shop.`Build a map from the customer name to their city`(): Map<String, City> {
    return customers.associate { it.name to it.city }
}

//14.
fun Shop.`Build a map that stores the customers living in a given city`(): Map<City, List<Customer>> {
    return customers.groupBy { it.city }
}

//15.
fun Shop.`Return customers who have more undelivered orders than delivered`(): Set<Customer> {
    return customers.filter {
        val (delivered, undelivered) = it.orders.partition { order -> order.isDelivered }
        undelivered.size > delivered.size
    }.toSet()
}

//16.
fun Customer.`Return all product the given Customer has ordered`(): List<Product> {
    return orders.flatMap { it.products }
}

//17.
fun Shop.`Return all products that were ordered by at least 1 customer`(): Set<Product> {
    return customers.flatMap {
        it.`Return all product the given Customer has ordered`()
    }.toSet()
}

//18.
fun Shop.`Return the set of products that were ordered by all customers`(): Set<Product> {
    val allProducts = customers.flatMap {
        it.`Return all product the given Customer has ordered`()
    }.toSet()
    return customers.fold(allProducts) { orderByAll, customer ->
        orderByAll.intersect(customer.`Return all product the given Customer has ordered`())
    }
}

//19.
fun `Find the most expensive product among all the delivered products ordered by the customer`(customer: Customer): Product? {
    return customer.orders.filter { it.isDelivered }.flatMap { it.products}.maxByOrNull { it.price }
}

//20.
fun Shop.`Count the amount of times a product was ordered, Note that a customer may order the same product several times`(product: Product): Int {
    return customers.flatMap { it.orders }.flatMap { it.products }.count { it.name == product.name }
}



fun oldCode(
    collection: Collection<String>
): Collection<String>? {
    val groupsByLength = mutableMapOf<Int, MutableList<String>>()
    for (s in collection) {
        var strings: MutableList<String>? = groupsByLength[s.length]
        if (strings == null) {
            strings = mutableListOf()
            groupsByLength[s.length] = strings
        }
        strings.add(s)
    }

    var maximumSizeOfGroup = 0
    for (group in groupsByLength.values) {
        if (group.size > maximumSizeOfGroup) {
            maximumSizeOfGroup = group.size
        }
    }

    for (group in groupsByLength.values) {
        if (group.size == maximumSizeOfGroup) {
            return group
        }
    }
    return null
}

fun newCode(collection: Collection<String>): Collection<String>? {
    val groupsByLength = collection.groupBy { it.length }

    val maximumSizeOfGroup = groupsByLength.values.map { group -> group.size }.max()

    return groupsByLength.values.firstOrNull { group -> group.size ==  maximumSizeOfGroup }
}


