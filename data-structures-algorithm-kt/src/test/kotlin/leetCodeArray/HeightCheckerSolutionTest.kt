package leetCodeArray

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class HeightCheckerSolutionTest {

    @Test
    fun givenArrayOfHeights_ReturnCountOfNonMatchingIndices() {

        val input = intArrayOf(1,1,4,2,1,3)
        val output = 3

        val result = HeightCheckerSolution.heightChecker(input)

        assertTrue(output == result)

    }

    @Test
    fun givenArrayOfRandomHeights_ReturnCountOfNonMatchingIndices() {

        val input = intArrayOf(5,1,2,3,4)
        val output = 5

        val result = HeightCheckerSolution.heightChecker(input)

        assertTrue(output == result)

    }

    @Test
    fun givenArrayOfNonDecreasingHeights_ReturnZero() {

        val input = intArrayOf(1,2,3,4,5)
        val output = 0

        val result = HeightCheckerSolution.heightChecker(input)

        assertTrue(output == result)

    }


}