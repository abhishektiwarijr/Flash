package heap

class Heap private constructor(
    size: Int,
    seed: Int,
    val compare: (Int, Int) -> Boolean
) {
    private var heapSize = 0
    private val array = IntArray(size + 1).also { it[0] = seed }

    companion object {
        private const val FRONT = 1
        private const val MAX_SIZE_ERROR = "At max size"
        private const val EMPTY_HEAP_ERROR = "Heap is empty"

        fun minHeap(size: Int = 10): Heap = Heap(size, Int.MIN_VALUE) { a, b -> a < b }
        fun maxHeap(size: Int = 10): Heap = Heap(size, Int.MAX_VALUE) { a, b -> a > b }

        private fun parent(i: Int) = i shr 1
        private fun left(i: Int) = i shl 1
        private fun right(i: Int) = left(i) + 1
    }

    fun pop(): Int {
        require(heapSize > 0) { error(EMPTY_HEAP_ERROR) }

        val popped = peek()
        array[FRONT] = array[heapSize--]
        heapify(FRONT)
        return popped
    }

    fun peek() = if (heapSize > 0) array[1] else error(EMPTY_HEAP_ERROR)

    fun size() = heapSize

    fun add(value: Int) {
        require(heapSize < array.size - 1) { error(MAX_SIZE_ERROR) }

        array[++heapSize] = value
        var current = heapSize
        var parent = parent(current)
        while (parent != 0 && compare(array[current], array[parent])) {
            swap(parent, current)
            current = parent.also { parent = parent(parent) }
        }
    }

    operator fun plusAssign(value : Int) {
        add(value)
    }

    fun toList(): List<Int> = array.drop(1).take(size())

    private fun swap(a: Int, b: Int) {
        array[a] = array[b].also { array[b] = array[a] }
    }

    private tailrec fun heapify(i : Int) {
        val left = left(i)
        val right = right(i)

        var ordered = when {
            left <= heapSize && compare(array[i], array[left]) -> i
            left <= heapSize -> left
            else -> i
        }

        if(right <= heapSize && compare(array[ordered], array[right]).not()) {
            ordered = right
        }

        if(ordered != i) {
            swap(ordered, i)
            heapify(ordered)
        }
    }

    override fun toString() = toList().joinToString(separator = ",", prefix = "[", postfix = "]")
}