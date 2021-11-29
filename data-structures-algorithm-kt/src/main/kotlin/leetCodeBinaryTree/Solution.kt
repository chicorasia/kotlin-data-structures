package leetCodeBinaryTree

import chapter3linkedlist.addInReverse

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

        fun TreeNode.traversePreOrder(visit: Visitor<Int>) {
            visit(this.`val`)
            left?.traversePreOrder(visit)
            right?.traversePreOrder(visit)

        }

    }

}

typealias Visitor<Int> = (Int) -> Unit

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}