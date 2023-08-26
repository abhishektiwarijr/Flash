fun main() {
    val label = "Abhishek Tiwari"
    println(label.split(" ").fold("") { acc, s -> acc + s.first().uppercase() })
    println(label.split(" ").reduce { acc, s -> acc.first().uppercase() + s.first().uppercase() })
}