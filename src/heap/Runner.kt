package heap

fun main() {
    val heap = Heap.minHeap(20)

    heap += 42
    heap += 5
    heap += 7

    println(heap.toString())

    // Peek at the min
    if (heap.peek() == 5) {
        println("Yup....worked")
    }

    // Pop items
    val min = heap.pop()

    // Peek at the new min
    if (min == 5 && heap.peek() == 7) {
        println("Yup....worked")
    }
}