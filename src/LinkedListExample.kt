data class MyNode<T>(var value: T, var nextNode: MyNode<T>? = null) {
    override fun toString() : String {
        return if(nextNode != null) {
            "$value -> ${nextNode.toString()}"
        } else {
            "$value -> null"
        }
    }
}

fun main() {
    val head = MyNode(value = 10, MyNode(value = 20, MyNode(value = 30)))
    println(head)
    println(reverseLinkedList(head))

}

fun <T>reverseLinkedList(head: MyNode<T>) : MyNode<T> {
    if(head.nextNode == null) return head

    var prev: MyNode<T>? = null
    var curr : MyNode<T>? = head
    var next = curr?.nextNode

    while (curr != null) {
        curr.nextNode = prev
        prev = curr
        curr = next
        next = next?.nextNode
    }

    return prev!!
}
