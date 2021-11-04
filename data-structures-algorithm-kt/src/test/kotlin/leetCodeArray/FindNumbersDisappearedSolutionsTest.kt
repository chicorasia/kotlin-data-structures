package leetCodeArray

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class FindNumbersDisappearedSolutionsTest {

    @Test
    fun givenArrayOfInts_FindDisappearedNumbers() {

        val input = intArrayOf(4,3,2,7,8,2,3,1)
        val output = listOf<Int>(5,6)

        val result = FindNumbersDisappearedSolutions.findDisappearedNumbers(input)
        println(result)

        assertTrue(result == output)

    }

    @Test
    fun givenArrayOfOnes_FindDisappearedNumbers() {

        val input = intArrayOf(1,1)
        val output = listOf<Int>(2)

        val result = FindNumbersDisappearedSolutions.findDisappearedNumbers(input)
        println(result)

        assertTrue(result == output)

    }

    @Test
    fun givenArrayOfFourOnes_FindDisappearedNumbers() {

        val input = intArrayOf(1,1,1,1)
        val output = listOf<Int>(2,3,4)

        val result = FindNumbersDisappearedSolutions.findDisappearedNumbers(input)
        println(result)

        assertTrue(result == output)

    }


}