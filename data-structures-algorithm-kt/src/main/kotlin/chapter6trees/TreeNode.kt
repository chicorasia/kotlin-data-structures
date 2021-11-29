package chapter6trees

import chapter5queues.ArrayListQueue
import chapter5queues.DoubleStackQueue
import sun.reflect.generics.tree.Tree


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

    /**
     * This function uses a Visitor to traverse the tree level by level.
     * Every time a node is visited its children are added to a queue.
     *
     */
    fun forEachLevelOrder(visit: Visitor<T>) {
        /**
         * Visit the current node.
         */
        visit(this)
        /**
         * Add the current node's children to a queue
         */
        val queue = DoubleStackQueue<TreeNode<T>>()
        this.children.forEach {
            queue.enqueue(it)
        }

        /**
         * Consume the queue until it's empty
         */
        var node = queue.dequeue()
        while (node != null) {

            /**
             * Every time a node is visited add its children to que queue.
             * Since the queue enforces a FIFO order, all nodes in the same level
             * will be visited before moving on to the next level.
             */
            visit(node)
            node.children.forEach {
                queue.enqueue(it)
            }
            node = queue.dequeue()
        }
    }

    /**
     * A simple BFS algorithm using Level-Order Traversal
     */
    fun search(value: T) : TreeNode<T>? {
        var result: TreeNode<T>? = null

        forEachLevelOrder {
            if (it.value == value) { result = it }
        }
        return result
    }

    /**
     * This function uses a Queue and nested while loops to
     * print each level of the tree on a separate line.
     * - Time complexity: O(n)
     * - Space complexity: O(n)
     */
    fun printEachLevel() {
        val queue = ArrayListQueue<TreeNode<T>>()
        var nodesLeftInCurrentLevel = 0
        queue.enqueue(this)

        while(!queue.isEmpty) {
            nodesLeftInCurrentLevel = queue.count

            while(nodesLeftInCurrentLevel > 0) {
                val node = queue.dequeue()
                node?.let {
                    print("${it.value} ")
                    node.children.forEach {
                        queue.enqueue(it)
                    }
                    nodesLeftInCurrentLevel--
                } ?: break
            }

            println()
        }


    }
}

typealias Visitor<T> = (TreeNode<T>) -> Unit