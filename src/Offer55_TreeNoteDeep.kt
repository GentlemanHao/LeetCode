import java.util.*

fun main() {
    val root = TreeNode(1)

    val note2 = TreeNode(2)
    val note3 = TreeNode(3)

    root.left = note2
    root.right = note3

    val note4 = TreeNode(4)
    val note5 = TreeNode(5)

    note2.left = note4
    note2.right = note5

    val note6 = TreeNode(6)
    val note7 = TreeNode(7)

    note3.right = note6
    note5.left = note7

    println(maxDepth(root))

    /*preOrderTraverse(root)
    println()
    inOrderTraverse(root)
    println()
    postOrderTraverse(root)*/

    levelTraverse(root)
}

/**
 *        1
 *    2      3
 * 4    5       6
 *    7
 */
// 前序遍历
fun preOrderTraverse(node: TreeNode?) {
    node ?: return
    print("${node.value} ")
    preOrderTraverse(node.left)
    preOrderTraverse(node.right)
}

// 中序遍历
fun inOrderTraverse(node: TreeNode?) {
    node ?: return
    inOrderTraverse(node.left)
    print("${node.value} ")
    inOrderTraverse(node.right)
}

// 后序遍历
fun postOrderTraverse(node: TreeNode?) {
    node ?: return
    postOrderTraverse(node.left)
    postOrderTraverse(node.right)
    print("${node.value} ")
}

// 层级遍历
fun levelTraverse(node: TreeNode?) {
    node ?: return
    val queue = LinkedList<TreeNode>()
    queue.offer(node)

    while (queue.isNotEmpty()) {
        queue.poll().run {
            println(value)
            if (left != null) queue.offer(left)
            if (right != null) queue.offer(right)
        }
    }
}

// 最大深度
fun maxDepth(root: TreeNode?): Int {
    root ?: return 0

    val left = maxDepth(root.left)
    val right = maxDepth(root.right)

    return Math.max(left, right) + 1
}

// 是否是平衡二叉树
fun isBalanced(root: TreeNode?): Boolean {
    root ?: return true

    if (!isBalanced(root.left) || !isBalanced(root.right)) {
        return false
    }

    val left = maxDepth(root.left)
    val right = maxDepth(root.right)

    return Math.abs(left - right) <= 1
}


class TreeNode(val value: Int, var left: TreeNode? = null, var right: TreeNode? = null)