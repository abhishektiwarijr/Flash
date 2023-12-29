data class Node<T>(var data: T, var next: Node<T>? = null) {
    override fun toString(): String {
        return ""
    }
}

fun main() {
    val a = Node<String>("A", null)
    val b = Node<String>("B", null)
    val c = Node<String>("C", null)
    a.next = b
    b.next = c
    val n1 = Node<String>("1", null)
    c.next = n1
    val n2 = Node<String>("2", null)
    n1.next = n2
    val n3 = Node<String>("3", null)
    n2.next = n3
    val n4 = Node<String>("4", null)
    n3.next = n4
    val n5 = Node<String>("5", null)
    n4.next = n5
    val n6 = Node<String>("6", null)
    n5.next = n6
    val n7 = Node<String>("7", null)
    n6.next = n7
    val n8 = Node<String>("8", null)
    n7.next = n8
    val n9 = Node<String>("9", null)
    n8.next = n9
    val n10 = Node<String>("10", null)
    n9.next = n10
    val n11 = Node<String>("11", null)
    n10.next = n11
    val n12 = Node<String>("12", null)
    n11.next = n12
    n12.next = n1

    println(loopSize(a))

    /**
     * A,
     * B,
     * C,
     * 1,
     * 2,
     * 3,
     * 4,
     * 5,
     * 6,
     * 7,
     * 8,
     * 9,
     * 10,#$
     * 11,
     * 12,
     * **/
}

fun <T> loopSize(n: Node<T>): Int {
    var oneStep: Node<T>? = n
    var twoStep: Node<T>? = n.next
    var nodeCount = 0
    while (oneStep != twoStep) {
        oneStep = oneStep?.next
        twoStep = twoStep?.next?.next
    }

    if (oneStep == twoStep) {
        oneStep = oneStep?.next
        nodeCount++
        while (oneStep != twoStep) {
            nodeCount++
            oneStep = oneStep?.next
        }
    }
    return nodeCount
}


fun <T> loopSize1(n: Node<T>): Int {
    // floyd's
    var tortoise = n.next
    var hare = n.next?.next

    while (hare != tortoise) {
        tortoise = tortoise?.next
        hare = hare?.next?.next
    }

    var lamda = 1
    hare = tortoise?.next
    while (tortoise != hare) {
        hare = hare?.next
        lamda = lamda + 1
    }

    return lamda
}

fun <T> loopSize2(node: Node<T>?) = with(LinkedHashSet<Node<T>?>()) {
    var n = node
    while (add(n)) n = n?.next
    size - takeWhile { it != n }.count()
}