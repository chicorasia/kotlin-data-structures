package leetCodeBinaryTree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BinaryTreeLevelOrderTraversalSolutionTest {


    @Test
    fun givenBalancedTree_MustTraverseByLevel() {

        val root = TreeNode(3)
        val nine = TreeNode(9)
        val twenty = TreeNode(20)
        val fifteen = TreeNode(15)
        val seven = TreeNode(7)

        root.left = nine
        root.right = twenty
        twenty.left = fifteen
        twenty.right = seven

        val output = BinaryTreeLevelOrderTraversalSolution.levelOrder(root)
        val result = listOf<List<Int>>(listOf(3), listOf(9,20), listOf(15,7))
        println(output)

        assertTrue(output.equals(result))

    }

    @Test
    fun givenTreeOfOneElement_MustReturnListOfSingleItem() {
        val root = TreeNode(1)

        val output = BinaryTreeLevelOrderTraversalSolution.levelOrder(root)
        val result = listOf<List<Int>>(listOf(1))
        println(output)

        assertTrue(output.equals(result))

    }

    @Test
    fun givenEmptyTree_MustReturnEmptyList() {
        val root = null

        val output = BinaryTreeLevelOrderTraversalSolution.levelOrder(root)
        val result = emptyList<List<Int>>()
        println(output)

        assertTrue(output.equals(result))

    }

    @Test
    fun given_UnbalancedTree_MustTraverseByLevel() {
        val root = TreeNode(1)
        val two = TreeNode(2)
        val three = TreeNode(3)
        val four = TreeNode(4)
        val five = TreeNode(5)

        root.left = two
        two.left = four
        root.right = three
        three.right = five

        val output = BinaryTreeLevelOrderTraversalSolution.levelOrder(root)
        val result = listOf<List<Int>>(listOf(1), listOf(2,3), listOf(4,5))
        println(output)

        assertTrue(output.equals(result))

    }

}