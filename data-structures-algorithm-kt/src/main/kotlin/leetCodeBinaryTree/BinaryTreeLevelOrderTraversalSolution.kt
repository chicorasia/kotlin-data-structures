package leetCodeBinaryTree

import java.util.*

class BinaryTreeLevelOrderTraversalSolution {

    companion object {


        /**
         * A solution for BFS with counter
         */
        fun levelOrderNotGoodEnough(root: TreeNode?): List<List<Int>> {

            if (root == null) return emptyList()

            val queue = ArrayDeque<TreeNode>()
            var nodesLeftInCurrentLevel = 0
            val list = mutableListOf<List<Int>>()

            queue.add(root)

            while (queue.isNotEmpty()) {
                nodesLeftInCurrentLevel = queue.size

                val levelResult = mutableListOf<Int>()
                while (nodesLeftInCurrentLevel > 0) {
                    val node = queue.removeFirst()
                    node.let {
                        levelResult.add(node.`val`)
                        it.left?.let { leftChild ->
                            queue.addLast(leftChild)
                        }
                        it.right?.let { rightChild ->
                            queue.addLast(rightChild)
                        }
                        nodesLeftInCurrentLevel--
                    }
                }
                list.add(levelResult)
            }


            return list
        }

        /**
         * A solution for BFS with counter.
         */
        fun levelOrder(root: TreeNode?): List<List<Int>> {

            val queue = ArrayDeque<TreeNode>()
            val list = mutableListOf<List<Int>>()

            root?.let { queue.add(it) }

            while (queue.isNotEmpty()) {
                val nodesLeft = queue.size
                val levelResult = arrayListOf<Int>()

                for (i in 1..nodesLeft) {
                    with(queue.removeFirst()) {
                        let {
                            it.left?.let { leftChild ->
                                queue.addLast(leftChild)
                            }
                            it.right?.let { rightChild ->
                                queue.addLast(rightChild)
                            }
                        }
                        levelResult.add(`val`)
                    }
                }
                list.add(levelResult)
            }


            return list
        }

    }

}

typealias ListVisitor<Int> = (Int, Int) -> Unit
