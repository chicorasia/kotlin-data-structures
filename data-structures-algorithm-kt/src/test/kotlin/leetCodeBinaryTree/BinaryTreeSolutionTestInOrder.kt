package leetCodeBinaryTree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BinaryTreeSolutionTestInOrder {

    @Test
    fun givenUnbalancedTree_MustReturnListInOrder() {

        val root = TreeNode(1)
        val two = TreeNode(2)
        val three = TreeNode(3)

        root.right = two
        two.left = three

        val output = Solution.inorderTraversal(root)
        val result = listOf(1,3,2)
        println(output)

        assertTrue(result == output)

    }

    @Test
    fun givenEmptyTree_ReturnEmptyList() {
        val root = null
        val output = Solution.inorderTraversal(root)

        println(output)

        assertTrue(output.isEmpty())
    }

    @Test
    fun givenTreeOfSingleNode_ReturnListOfSingleElement() {
        val root = TreeNode(1)
        val output = Solution.inorderTraversal(root)
        val result = listOf(1)
        println(output)

        assertTrue(result == output)
    }

    @Test
    fun givenTreeOfTwoNodes_ReturnListWithTwoNodes() {

        val root = TreeNode(1)
        val two = TreeNode(2)

        root.left = two
        val output = Solution.inorderTraversal(root)
        val result = listOf(2,1)
        println(output)

        assertTrue(result == output)

    }

    @Test
    fun givenAnotherTreeOfTwoNodes_ReturnListWithTwoNodes() {

        val root = TreeNode(1)
        val two = TreeNode(2)

        root.right = two
        val output = Solution.inorderTraversal(root)
        val result = listOf(1,2)
        println(output)

        assertTrue(result == output)

    }
}