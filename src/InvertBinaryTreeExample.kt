import java.util.*

data class TreeNode(
    val data: Int,
    var leftChild: TreeNode? = null,
    var rightChild: TreeNode? = null,
)

fun main() {
    val leaf1 = TreeNode(1)
    val leaf2 = TreeNode(3)
    val leaf3 = TreeNode(6)
    val leaf4 = TreeNode(9)

    val rootChildLeft = TreeNode(2, leaf1, leaf2)
    val rootChildRight = TreeNode(7, leaf3, leaf4)

    val root = TreeNode(4, rootChildLeft, rootChildRight)

    invertTreeRecursive(root)

    invertTreeIterative(root)
}

fun invertTreeRecursive(rootNode: TreeNode?) {
    if (rootNode == null) return

    //swapping nodes
    val temp = rootNode.leftChild
    rootNode.leftChild = rootNode.rightChild
    rootNode.rightChild = temp

    invertTreeRecursive(rootNode.leftChild)
    invertTreeRecursive(rootNode.rightChild)
}

fun invertTreeIterative(root: TreeNode?) {
    val queue = LinkedList<TreeNode>()

    if (root != null) {
        queue.add(root)
    }

    while (queue.isNotEmpty()) {
        val currentNode = queue.poll()

        currentNode.leftChild?.let {
            queue.add(it)
        }

        currentNode.rightChild?.let {
            queue.add(it)
        }

        val temp = currentNode.leftChild
        currentNode.leftChild = currentNode.rightChild
        currentNode.rightChild = temp
    }
}

