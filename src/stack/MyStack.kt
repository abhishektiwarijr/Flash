package stack

const val DEFAULT_SIZE = 10

@Suppress("UNCHECKED_CAST")
class MyStack<T : Any>(initialSize: Int = DEFAULT_SIZE) : IStack<T> {
    private var capacity = initialSize
    private var arr: Array<Any?> = arrayOfNulls<Any?>(initialSize)
    private var top: Int = -1

    override fun push(value: T) {
        ensureCapacity()
        arr[++top] = value
    }

    private fun ensureCapacity() {
        //arr is full
        if (top == arr.size - 1) {
            capacity *= 2
            arr = arr.copyOf(capacity)
        }
    }


    override fun pop(): T {
        if (top == -1) {
            throw NoSuchElementException("Stack is empty")
        } else {
            return (arr[top--] as T)
        }
    }

    override fun peek(): T {
        if (top == -1) {
            throw NoSuchElementException("Stack is empty")
        } else {
            return (arr[top] as T)
        }
    }

    override fun isEmpty(): Boolean {
        return top == -1
    }

    override fun size(): Int {
        return top + 1
    }

    override fun iterator(): Iterator<T> {
        return StackIterator()
    }

    private inner class StackIterator : Iterator<T> {
        private var currentIndex = top

        override fun hasNext(): Boolean {
            return currentIndex > -1
        }

        override fun next(): T {
            if (hasNext()) {
                return arr[currentIndex--] as T
            } else {
                throw NoSuchElementException()
            }
        }
    }
}

fun main() {
    val myStack = MyStack<Int>()
    for (i in 1..11) {
        myStack.push(i)
    }

    val itr = myStack.iterator()
    while (itr.hasNext()) {
        println(itr.next())
    }
}