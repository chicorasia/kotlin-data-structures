package leetCodeBinaryTree

import chapter3linkedlist.addInReverse
import java.util.*
import kotlin.collections.ArrayDeque

class Solution {

    companion object {

        /**
         * Preorder traversal:
         * - visit the root first
         * - then the left subtree
         * - then the right subtree
         * This is a very fast algorithm but uses quite a lot of memory.
         */
        fun preorderTraversal(root: TreeNode?): List<Int> {
            val list = mutableListOf<Int>()
            root?.traversePreOrder { list.add(it) }
            return list
        }

        /**
         * InOrder traversal:
         * - then the left subtree
         * - visit the root first
         * - then the right subtree
         * This is a very fast algorithm but uses quite a lot of memory.
         */
        fun inorderTraversal(root: TreeNode?): List<Int> {
            val list = mutableListOf<Int>()
            root?.traverseInOrderNonRecursive { list.add(it) }
            return list
        }

        fun preorderTraversalNonRecursive(root: TreeNode?): List<Int> {
            val list = mutableListOf<Int>()
            root?.traversePreOrderNonRecursive { list.add(it) }
            return list
        }

        fun TreeNode.traversePreOrder(visit: Visitor<Int>) {
            visit(this.`val`)
            left?.traversePreOrder(visit)
            right?.traversePreOrder(visit)

        }

        fun postorderTraversal(root: TreeNode?): List<Int> {
            val list = mutableListOf<Int>()
            root?.traversePostOrder { list.add(it) }
            return list
        }

        /**
         * Post-order traversal, recursively
         */
        fun TreeNode.traversePostOrder(visit: Visitor<Int>) {
            left?.traversePostOrder(visit)
            right?.traversePostOrder(visit)
            visit(this.`val`)
        }

        /**
         * Traverse nodes in order recursively
         */
        fun TreeNode.traverseInOrder(visit: Visitor<Int>) {
            left?.traverseInOrder(visit)
            visit(this.`val`)
            right?.traverseInOrder(visit)
        }

        fun TreeNode.traversePreOrderNonRecursive(visit: Visitor<Int>) {
            /**
             * Create an empty stack using an ArrayDeque
             */
            val nodeStack = ArrayDeque<TreeNode>()

            /**
             * Push rootNode into the stack
             */
            nodeStack.addFirst(this)

            /**
             * While nodeStack is not empty:
             * - pop a node and visit it
             * - push right child of popped node into the stack
             * - push left child of popped node into the stack
             * Pushing the right child first we make sure the left subtree
             * is processed first.
             */
            while (nodeStack.isNotEmpty()) {
                val poppedNode = nodeStack.removeFirst()
                visit(poppedNode.`val`)
                poppedNode.right?.let { nodeStack.addFirst(it) }
                poppedNode.left?.let { nodeStack.addFirst(it) }
            }

        }

        /**
         * Iteratively traverse in order.
         * Based on https://www.techiedelight.com/inorder-tree-traversal-iterative-recursive/
         */
        fun TreeNode.traverseInOrderNonRecursive(visit: Visitor<Int>) {

            /**
             * Initiate an empty Stack
             */
            val nodeStack = ArrayDeque<TreeNode>()

            /**
             * Set the
             */
            var currentNode: TreeNode? = this

            while (nodeStack.isNotEmpty() || currentNode != null) {
                if (currentNode != null) {
                    nodeStack.addFirst(currentNode)
                    currentNode = currentNode.left
                } else {
                    currentNode = nodeStack.removeFirst()
                    visit(currentNode.`val`)
                    currentNode = currentNode.right
                }
            }

        }

    }

}

typealias Visitor<Int> = (Int) -> Unit

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}