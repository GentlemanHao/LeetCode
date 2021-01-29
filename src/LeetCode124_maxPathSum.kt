import bean.TreeNode

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

    println(maxPathSum(root))
}

private var sum = Int.MIN_VALUE

fun maxPathSum(root: TreeNode?): Int {
    root ?: return 0
    dfs(root)
    return sum
}

fun dfs(root: TreeNode?): Int {
    root ?: return 0

    val left = Math.max(0, dfs(root.left))
    val right = Math.max(0, dfs(root.right))

    sum = Math.max(sum, root.value + left + right)

    return root.value + Math.max(left, right)
}