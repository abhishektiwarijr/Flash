package kotlinquiz

//What does it print?

fun main() {
    val list1 = listOf(1,2,3,4).filter {
        val shouldFilter = it > 3
        shouldFilter
    }

    val list2 = listOf(1,2,3,4).filter {
        val shouldFilter = it > 3
        return@filter shouldFilter
    }

    println(list1)
    println(list2)
}

//It prints the same in both println:

//4
//4

//You can explicitly return a value from the lambda using the qualified return syntax. Otherwise, the value of the last expression is implicitly returned.