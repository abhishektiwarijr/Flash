data class Node(var data: String, var next: Node? = null) {
    override fun toString(): String {
        return ""
    }
}

fun main() {
    val a = Node("A", null)
    val b = Node("B", null)
    val c = Node("C", null)
    a.next = b
    b.next = c
    val n1 = Node("1", null)
    c.next = n1
    val n2 = Node("2", null)
    n1.next = n2
    val n3 = Node("3", null)
    n2.next = n3
    val n4 = Node("4", null)
    n3.next = n4
    val n5 = Node("5", null)
    n4.next = n5
    val n6 = Node("6", null)
    n5.next = n6
    val n7 = Node("7", null)
    n6.next = n7
    val n8 = Node("8", null)
    n7.next = n8
    val n9 = Node("9", null)
    n8.next = n9
    val n10 = Node("10", null)
    n9.next = n10
    val n11 = Node("11", null)
    n10.next = n11
    val n12 = Node("12", null)
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

fun loopSize(n: Node): Int {
    var oneStep : Node? = n
    var twoStep : Node? = n.next
    var nodeCount = 0
    while (oneStep != twoStep) {
        oneStep = oneStep?.next
        twoStep = twoStep?.next?.next
    }

    if(oneStep == twoStep) {
        oneStep = oneStep?.next
        nodeCount++
        while (oneStep != twoStep) {
            nodeCount++
            oneStep = oneStep?.next
        }
    }
    return nodeCount
}


fun loopSize1(n: Node): Int {
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

fun loopSize2(node: Node?) = with(LinkedHashSet<Node?>()) {
    var n = node
    while (add(n)) n = n?.next
    size - takeWhile { it != n }.count()
}