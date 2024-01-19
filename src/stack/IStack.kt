package stack

interface IStack<T> {
    fun push(value: T)
    fun pop(): T

    fun peek(): T

    fun isEmpty(): Boolean

    fun size(): Int

    fun iterator(): Iterator<T>
}