package heap

interface HeapI<T : Comparable<T>> {
    val size: Int
    fun add(value: T): Boolean
    fun pop(): T
    fun peek(): T
    fun toList(): List<T>
}