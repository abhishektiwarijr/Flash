package heap

import java.util.PriorityQueue

class PQHeap<T : Comparable<T>> private constructor(comparator: Comparator<T>) : HeapI<T> {
    private val priorityQueue: PriorityQueue<T> = PriorityQueue(comparator)

    companion object {
        fun <T : Comparable<T>> minHeap() = PQHeap(MinHeapComparator<T>())
        fun <T : Comparable<T>> maxHeap() = PQHeap(MaxHeapComparator<T>())
    }

    override val size: Int
        get() = priorityQueue.size

    override fun add(value: T) = priorityQueue.add(value)

    override fun pop(): T = priorityQueue.poll()

    override fun peek(): T = priorityQueue.peek()

    override fun toList(): List<T> = priorityQueue.toList()

    fun remove(value: T): Boolean = priorityQueue.remove(value)
}