package b

import accessmodifiers.Employee

class TestVisibilityOutside(
    name: String, email: String, salary: String, id: String
) : Employee(name, email, salary, id) {

    fun test() {
        salary = "100000"
    }
}

fun main() {
    val e = TestVisibilityOutside(
        "Abhishek",
        "abhishek.tiwari@obsidiam.com",
        "100000",
        "Obs_11"
    )

    println(e.name)
    println(e.id)
}