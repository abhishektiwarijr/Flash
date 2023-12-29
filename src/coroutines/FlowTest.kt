package coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlin.system.measureTimeMillis

//suspend fun main() {
//    val element = Component("1", tableType = TableType.A)
//    val scope = CoroutineScope(SupervisorJob())
//    val time = measureTimeMillis {
//        val result = getRealComponent(
//            scope = scope,
//            listOf(
//                element,
//                element.copy(id = "2", tableType = TableType.B),
//                element.copy(id = "3", tableType = TableType.API),
//                element.copy(id = "4", tableType = TableType.B),
//                element.copy(id = "5", tableType = TableType.API),
//                element.copy(id = "6", tableType = TableType.API),
//            )
//        ).firstOrNull()
//        println(result?.joinToString())
//    }
//    println("total time is $time")
//}

fun main() = runBlocking {
    val element = Component("1", tableType = TableType.A)
    val scope = CoroutineScope(SupervisorJob())
    val time = measureTimeMillis {
        val result = getRealComponent(
            scope = scope,
            listOf(
                element,
                element.copy(id = "2", tableType = TableType.B),
                element.copy(id = "3", tableType = TableType.API),
                element.copy(id = "4", tableType = TableType.B),
                element.copy(id = "5", tableType = TableType.API),
                element.copy(id = "6", tableType = TableType.API),
                element.copy(id = "7", tableType = TableType.B),
                element.copy(id = "8", tableType = TableType.API),
                element.copy(id = "9", tableType = TableType.API),
            )
        )
        result.collectLatest {
            println(it)
        }


    }
    println("total time is $time")
}

typealias ComponentId = String

//fun getRealComponent(scope: CoroutineScope, components: List<Component>) = flow {
//    val componentMap: Map<ComponentId, Component> = components.associateBy { it.id }
//    val result: List<Any> = componentMap.values.map {
//        when (it.tableType) {
//            TableType.A -> it.copy(data = "A")
//            TableType.B -> it.copy(data = "B")
//            TableType.C -> it.copy(data = "c")
//            TableType.API -> {
//                scope.async(Dispatchers.IO) { hitApi(it) }
//            }
//        }
//    }
//    result.filterIsInstance<Deferred<Component>>().awaitAll()
//    val finalResult = result.map {
//        if (it is Deferred<*>) {
//            (it.await() as Component)
//        } else it as Component
//    }
//    emit(finalResult.toList())
//}

fun getRealComponent(scope: CoroutineScope, components: List<Component>) = flow {
    val result: List<Any> = components.map {
        when (it.tableType) {
            TableType.A -> it.copy(data = "A")
            TableType.B -> it.copy(data = "B")
            TableType.C -> it.copy(data = "C")
            TableType.API -> {
                scope.launch(Dispatchers.IO) {
                    emit(hitApi(it))
                }
            }
        }
    }
//    result.filterIsInstance<Deferred<Component>>().awaitAll()
//    val finalResult = result.map {
//        if (it is Deferred<*>) {
//            (it.await() as Component)
//        } else it as Component
//    }
    emit(result.toList())
}

suspend fun hitApi(component: Component): Component {
    delay(2000)
    return component.copy(data = "response")
}

enum class TableType {
    A, B, C, API
}

data class Component(
    val id: String,
    val shouldFetchFromApi: Boolean = false,
    val tableType: TableType = TableType.A,
    val data: Any = ""
)