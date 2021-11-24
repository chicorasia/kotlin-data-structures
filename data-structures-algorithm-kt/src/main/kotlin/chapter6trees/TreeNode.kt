package chapter6trees

/**
 * This class represents a node in a Tree which stores values of type T
 */
class TreeNode<T>(val value: T) {

    /**
     * It uses a MutableList to keep track of its children
     */
    private val children: MutableList<TreeNode<T>> = mutableListOf()

    /**
     * This method adds a child node to the node.
     */
    fun add(child: TreeNode<T>) {
        children.add(child)
    }

    /**
     * This function uses the Visitor<T> typealias to traverse
     * the array depth-first.
     * Its signature is the same as
     * fun forEachDepthFirst(visit: (TreeNode<T>) -> Unit)
     * but using a typealias make it much less verbose.
     */
    fun forEachDepthFirst(visit: Visitor<T>) {
        visit(this)
        children.forEach {
            it.forEachDepthFirst(visit)
        }
    }
}

typealias Visitor<T> = (TreeNode<T>) -> Unit