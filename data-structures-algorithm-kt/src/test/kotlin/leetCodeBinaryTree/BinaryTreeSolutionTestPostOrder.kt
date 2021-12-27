package leetCodeBinaryTree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BinaryTreeSolutionTestPostOrder {

    @Test
    fun givenUnbalancedTree_MustReturnListinPostOrder() {

        val root = TreeNode(1)
        val two = TreeNode(2)
        val three = TreeNode(3)

        root.right = two
        two.left = three

        val output = Solution.postorderTraversal(root)
        val result = listOf(3,2,1)
        println(output)

        assertTrue(result == output)

    }

    @Test
    fun givenUnbalancedTreeOfFourElements_MustReturnListinPostOrder() {

        val root = TreeNode(3)
        val two = TreeNode(2)
        val four = TreeNode(4)
        val one = TreeNode(1)

        root.right = four
        root.left = two
        four.left = one

        val output = Solution.postorderTraversal(root)
        val result = listOf(2,1,4,3)
        println(output)

        assertTrue(result == output)

    }

    @Test
    fun givenEmptyTree_ReturnEmptyList() {
        val root = null
        val output = Solution.postorderTraversal(root)

        println(output)

        assertTrue(output.isEmpty())
    }

    @Test
    fun givenTreeOfSingleNode_ReturnListOfSingleElement() {
        val root = TreeNode(1)
        val output = Solution.postorderTraversal(root)
        val result = listOf(1)
        println(output)

        assertTrue(result == output)
    }

    @Test
    fun givenTreeOfTwoNodes_ReturnListWithTwoNodes() {

        val root = TreeNode(1)
        val two = TreeNode(2)

        root.left = two
        val output = Solution.postorderTraversal(root)
        val result = listOf(2,1)
        println(output)

        assertTrue(result == output)

    }

    @Test
    fun givenAnotherTreeOfTwoNodes_ReturnListWithTwoNodes() {

        val root = TreeNode(1)
        val two = TreeNode(2)

        root.right = two
        val output = Solution.postorderTraversal(root)
        val result = listOf(2,1)
        println(output)

        assertTrue(result == output)

    }
}