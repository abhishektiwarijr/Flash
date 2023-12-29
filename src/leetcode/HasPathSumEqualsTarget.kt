package leetcode

import TreeNode

/**
 * Given a binary tree and a targetValue, return true if there exist a path
 * from root to leaf where the sum of the elements is equal to target
 */
fun main() {
    val targetValue = 22
    val binaryTreeRoot = TreeNode(
        data = 5,
        leftChild = TreeNode(
            data = 4,
            leftChild = TreeNode(
                data = 11,
                rightChild = TreeNode(2)
            )
        ),
        rightChild = TreeNode(
            data = 8,
            leftChild = TreeNode(13),
            rightChild = TreeNode(4)
        )
    )

    println(hasPathSum(binaryTreeRoot, targetValue))
}

fun hasPathSum(root: TreeNode, targetValue: Int): Boolean {
    return hasPathSumHelper(root, sum = 0, targetValue)
}

fun hasPathSumHelper(node: TreeNode?, sum: Int, targetValue: Int): Boolean {
    if (node == null) return false

    var sumCopy = sum
    sumCopy += node.data

    if (node.leftChild == null && node.rightChild == null) {
        return sumCopy == targetValue
    }

    return hasPathSumHelper(node.leftChild, sumCopy, targetValue)
            || hasPathSumHelper(node.rightChild, sumCopy, targetValue)

}
