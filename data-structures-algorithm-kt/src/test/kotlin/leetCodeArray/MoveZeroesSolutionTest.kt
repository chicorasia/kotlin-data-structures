package leetCodeArray

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MoveZeroesSolutionTest {

    @Test
    fun givenNonEmptyArray_MustMoveZeroesToTheEndOfTheArray() {

        val nums = intArrayOf(0,1,0,3,12)
        val output = intArrayOf(1,3,12,0,0)

        MoveZeroesSolution.moveZeroes(nums)

        nums.forEach {
            print("$it,")
        }
        println()

        assertTrue(nums.contentEquals(output))

    }

    @Test
    fun givenArrayOfOneItem_DoNothing() {

        val nums = intArrayOf(1)
        val output = intArrayOf(1)

        MoveZeroesSolution.moveZeroes(nums)

        nums.forEach {
            print("$it,")
        }
        println()

        assertTrue(nums.contentEquals(output))

    }

    @Test
    fun givenNonDecreasingArrayOfTwoItems_MustMoveZeroes() {

        val nums = intArrayOf(0,1)
        val output = intArrayOf(1,0)

        MoveZeroesSolution.moveZeroes(nums)

        nums.forEach {
            print("$it,")
        }
        println()

        assertTrue(nums.contentEquals(output))

    }

    @Test
    fun givenDecreasingArrayOfManyItems_MustMoveZeroes() {

        val nums = intArrayOf(9,8,7,6,3,0)
        val output = intArrayOf(9,8,7,6,3,0)

        MoveZeroesSolution.moveZeroes(nums)

        nums.forEach {
            print("$it,")
        }
        println()

        assertTrue(nums.contentEquals(output))

    }

    @Test
    fun givenNonDecreasingArrayOfManyItems_MustMoveZeroes() {

        val nums = intArrayOf(-90,-80,0,0,10,40)
        val output = intArrayOf(-90,-80,10,40,0,0)

        MoveZeroesSolution.moveZeroes(nums)

        nums.forEach {
            print("$it,")
        }
        println()

        assertTrue(nums.contentEquals(output))

    }

    @Test
    fun givenNonDecreasingArrayOfZeroes_MustMoveZeroes() {

        val nums = intArrayOf(0,0,0,0)
        val output = intArrayOf(0,0,0,0)

        MoveZeroesSolution.moveZeroes(nums)

        nums.forEach {
            print("$it,")
        }
        println()

        assertTrue(nums.contentEquals(output))

    }

    @Test
    fun givenDecreasingArrayOfTwoItems_MustMoveZeroes() {

        val nums = intArrayOf(2,1)
        val output = intArrayOf(2,1)

        MoveZeroesSolution.moveZeroes(nums)

        nums.forEach {
            print("$it,")
        }
        println()

        assertTrue(nums.contentEquals(output))

    }


}