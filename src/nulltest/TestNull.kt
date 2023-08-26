package nulltest

fun main() {
    val network = Network()
    if (network.networkManagement != null) {
        println("Is not null")
    } else {
        println("Is null")
    }
}