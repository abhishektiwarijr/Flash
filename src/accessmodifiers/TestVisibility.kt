package accessmodifiers

import kotlinx.coroutines.flow.MutableSharedFlow

fun main() {
    val e = Employee(
        "Abhishek",
        "abhishek.tiwari@obsidiam.com",
        "100000",
        "Obs_11"
    )

    println(e.name)
    println(e.id)
}