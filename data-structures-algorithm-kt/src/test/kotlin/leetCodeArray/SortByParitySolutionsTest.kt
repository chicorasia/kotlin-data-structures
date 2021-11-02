package leetCodeArray

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SortByParitySolutionsTest {

    @Test
    fun givenUnsortedArray_MustSortByParity() {

        val nums = intArrayOf(3,1,2,4)
        val output = intArrayOf(4,2,1,3)

        SortByParitySolutions.sortArrayByParity(nums)

        nums.forEach {
            print("$it, ")
        }
        println()

        assertTrue(nums.contentEquals(output))

    }

    @Test
    fun givenDecreasingArray_MustSortByParity() {

        val nums = intArrayOf(5,2,2)
        val output = intArrayOf(2,2,5)

        SortByParitySolutions.sortArrayByParity(nums)

        nums.forEach {
            print("$it, ")
        }
        println()

        assertTrue(nums.contentEquals(output))

    }

    @Test
    fun givenArrayOfOneItem_MustSortByParity() {

        val nums = intArrayOf(3)
        val output = intArrayOf(3)

        SortByParitySolutions.sortArrayByParity(nums)

        nums.forEach {
            print("$it, ")
        }
        println()

        assertTrue(nums.contentEquals(output))

    }

    @Test
    fun givenArrayOfTwoItem_MustSortByParity() {

        val nums = intArrayOf(3,2)
        val output = intArrayOf(2,3)

        SortByParitySolutions.sortArrayByParity(nums)

        nums.forEach {
            print("$it, ")
        }
        println()

        assertTrue(nums.contentEquals(output))

    }

    @Test
    fun givenArrayOfAllEvens_MustSortByParity() {

        val nums = intArrayOf(2,2,2)
        val output = intArrayOf(2,2,2)

        SortByParitySolutions.sortArrayByParity(nums)

        nums.forEach {
            print("$it, ")
        }
        println()

        assertTrue(nums.contentEquals(output))

    }

    @Test
    fun givenArrayOfAllOdds_MustSortByParity() {

        val nums = intArrayOf(3,3,3)
        val output = intArrayOf(3,3,3)

        SortByParitySolutions.sortArrayByParity(nums)

        nums.forEach {
            print("$it, ")
        }
        println()

        assertTrue(nums.contentEquals(output))

    }

    @Test
    fun givenSortedArray_MustDoNothing() {

        val nums = intArrayOf(2,2,5,3,3)
        val output = intArrayOf(2,2,5,3,3)

        SortByParitySolutions.sortArrayByParity(nums)

        nums.forEach {
            print("$it, ")
        }
        println()

        assertTrue(nums.contentEquals(output))


    }
}