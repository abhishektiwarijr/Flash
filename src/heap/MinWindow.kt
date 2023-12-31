package heap

class MinWindow(private val windowSize: Int = 10) {
    private var minHeap = Heap.minHeap(windowSize)
    private val maxHeap = Heap.maxHeap(windowSize)

    fun size() = minHeap.size()
    fun min() = if (size() > 0) minHeap.peek() else Int.MIN_VALUE
    fun max() = if (size() > 0) maxHeap.peek() else Int.MAX_VALUE

    fun add(value: Int) {
        if (minHeap.size() < windowSize) {
            minHeap.add(value)
            maxHeap.add(value)
        } else if (value <= max()) {
            maxHeap.pop()
            maxHeap.add(value)
            // If the Heap had a remove we could adjust the minHeap...but instead will replace
            val newMinHeap = Heap.minHeap(windowSize)
            maxHeap.toList().forEach {
                newMinHeap.add(it)
            }
            minHeap = newMinHeap
        }
    }

    fun toList() = minHeap.toList().sorted()

    override fun toString(): String {
        return "{limit=$windowSize, size=${size()}, min=${min()}, max=${max()}, members=${toList()}}"
    }
}