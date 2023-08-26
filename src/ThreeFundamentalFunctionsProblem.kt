fun main() {
    var i = 3
    until({ i++ < 5 }) {

    }
}

inline fun unless(condition: Boolean, operation: () -> Unit) = if (!condition) operation() else Unit

inline fun until(condition: () -> Boolean, operation: () -> Unit) {
    while (!condition()) operation()
}

inline fun forceRun(operation: () -> Unit) = try {
    operation()
} catch (e: Exception) {
}