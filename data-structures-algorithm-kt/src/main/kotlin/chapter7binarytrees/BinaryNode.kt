package chapter7binarytrees

import java.lang.Integer.max

typealias Visitor<T> = (T) -> Unit

/**
 * The node in a Binary Tree
 */
class BinaryNode<T>(val value: T) {

    var leftChild: BinaryNode<T>? = null
    var rightChild: BinaryNode<T>? = null

    override fun toString() = diagram(this)

    /**
     * Helps visualize a tree in the console
     */
    private fun diagram(node: BinaryNode<T>?,
                        top: String = "",
                        root: String = "",
                        bottom: String = ""): String {
        return node?.let {
            if (node.leftChild == null && node.rightChild == null) {
                "$root${node.value}\n"
            } else {
                diagram(node.rightChild, "$top ", "$top+--", "$top¦ ") +
                        root + "${node.value}\n" + diagram(node.leftChild,
                    "$bottom¦ ", "$bottom+--", "$bottom ")
            }
        } ?: "${root}null\n"
    }

    /**
     * This function traverses the binary tree in order using recursion.
     * - If the node has a left child, recursively visit it first
     * - Visit the current node
     * - If the node has a right child, recursively visit it
     */
    fun traverseInOrder(visit: Visitor<T>) {
        leftChild?.traverseInOrder(visit)
        visit(value)
        rightChild?.traverseInOrder(visit)
    }

    /**
     * This function traverses the binary tree in "pre-order" fashion using recursion.
     * - Visit the current node first
     * - Visit left child recursively
     * - Visit right child recursively
     */
    fun traversePreOrder(visit: Visitor<T>) {
        visit(value)
        leftChild?.traversePreOrder(visit)
        rightChild?.traversePreOrder(visit)
    }

    /**
     * This function traverses the binary tree in "pre-order" fashion using recursion.
     * - Visit left child recursively
     * - Visit right child recursively
     * - Finally, visit the current node!
     */

    fun traversePostOrder(visit: Visitor<T>) {
        leftChild?.traversePostOrder(visit)
        rightChild?.traversePostOrder(visit)
        visit(value)
    }

    /**
     * Use recursion to calculate the tree height.
     * If the node is null return -1
     * Time complexity: O(n)
     */
    fun height(node: BinaryNode<T>? = this) : Int {
        return node?.let {
            1 + max(height(node.leftChild),height(node.rightChild))
         } ?: -1
    }

    /**
     * A traverse pre-order funtion that visits the null nodes as well.
     * It is used for serialization and desserialization of a binary tree.
     */
    fun traversePreOrderWithNulls(visit: Visitor<T?>) {
        visit(value)
        leftChild?.traversePreOrderWithNulls(visit) ?: visit(null)
        rightChild?.traversePreOrderWithNulls(visit) ?: visit(null)
    }

    /**
     * This function uses serializes a binary tree using pre-order traversal
     * - Time complexity: O(n)
     * - Space complexity: O(n)
     */
    fun serialize(node: BinaryNode<T> = this) : MutableList<T?> {
        val list = mutableListOf<T?>()
        node.traversePreOrderWithNulls { list.add(it) }
        return list
    }
}