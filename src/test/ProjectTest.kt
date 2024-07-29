package test


data class Event(val eventName: String, val timeStamp: Long? = null)

fun main() {
    val usageEvents = mutableMapOf<String, List<Event>>(
        "A" to listOf(
            Event("A1", 1),
            Event("A2", 2),
            Event("A1", 3),
            Event("A2", 4),
        ),
        "B" to listOf(
            Event("B1", 1),
            Event("B2", 2),
        ),
        "C" to listOf(
            Event("C1", 1),
            Event("C2", 2),
            Event("C1", 3),
            Event("C2", 4),
        ),
        "D" to listOf(
            Event("D1", 1),
        ),
        "E" to listOf(
            Event("E2", 1),
        ),
    )

    usageEvents.forEach { t, u ->
        val subList = u.groupBy { it.eventName }
        subList.forEach { v, w ->
            w.forEach {

            }
        }
    }

    val finalList = listOf<Event>(
        Event("A1", 1),
        Event("A1", 3),
        Event("A2", 2),
        Event("A2", 4),
        Event("B1", 1),
        Event("B2", 2),
        Event("C1", 1),
        Event("C1", 3),
        Event("C2", 2),
        Event("C2", 4),
        Event("D1", 1),
    )

    val myAdder = createAdder()


//    usageEvents.forEach { t, u ->
//        println(u
//            .groupBy { it.eventName }
//            .flatMap { it.value }
//        )
//    }
    usageEvents.flatMap { it.value }.forEach {
        println(it)
    }
}