package leetCodeArray

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class FindThirdMaxSolutionTest {

    @Test
    fun given_ArrayOfUnorderedInts_FindThirdMaximum() {

        val input = intArrayOf(2,2,3,1)
        val output = 1

        val result = FindThirdMaxSolution.thirdMax(input)

        input.forEach {
            print("$it, ")
        }

        assertTrue(output == result)

    }

    @Test
    fun given_ArrayOfNonDecresingInts_FindThirdMaximum() {

        val input = intArrayOf(3,2,1)
        val output = 1

        val result = FindThirdMaxSolution.thirdMax(input)

        assertTrue(output == result)

    }

    @Test
    fun given_ArrayOfSizeTwo_FindMaximum() {

        val input = intArrayOf(1,2)
        val output = 2

        val result = FindThirdMaxSolution.thirdMax(input)

        assertTrue(output == result)

    }

    @Test
    fun givenArrayWithOnlyTwoDistinctValues_FindMaximum() {

        val input = intArrayOf(1,1,1,1,2)
        val output = 2

        val result = FindThirdMaxSolution.thirdMax(input)

        input.forEach {
            print("$it, ")
        }

        assertTrue(output == result)

    }

    @Test
    fun givenArray_FindMax() {

        val input = intArrayOf(1,1,1,1,2)
        val output = 2

        val result = FindThirdMaxSolution.moveMaxToHead(input, 0, 4)

        assertTrue(output == result)

    }

    @Test
    fun givenUnorderedArray_FindThirdMaximum() {

        val input = intArrayOf(7,23,65,21,-70,18,45)
        val output = 23

        val result = FindThirdMaxSolution.thirdMax(input)

        input.forEach {
            print("$it, ")
        }

        assertTrue(output == result)

    }

    @Test
    fun givenArrayWithIntMinValue_FindThirdMaximum() {

        val input = intArrayOf(1,2,-2147483648, -2147483648)
        val output = -2147483648

        val result = FindThirdMaxSolution.thirdMax(input)

        input.forEach {
            print("$it, ")
        }

        assertTrue(output == result)
    }

    @Test
    fun givenArrayWithIntValues_FindThirdMaximum() {

        val input = intArrayOf(1,2,2,5,3,5)
        val output = 2

        val result = FindThirdMaxSolution.thirdMax(input)

        input.forEach {
            print("$it, ")
        }

        assertTrue(output == result)
    }

    @Test
    fun givenArrayWithOnlyOneDistinctValue_FindMaximum() {

        val input = intArrayOf(1,1,1,1,1)
        val output = 1

        val result = FindThirdMaxSolution.thirdMax(input)

        input.forEach {
            print("$it, ")
        }

        assertTrue(output == result)

    }

    @Test
    fun givenDecreasingSortedArrayWithOnlyValue_FindThirdMaximum() {

        val input = intArrayOf(9,8,7,6,5,4,3,2,1)
        val output = 7

        val result = FindThirdMaxSolution.thirdMax(input)

        input.forEach {
            print("$it, ")
        }

        assertTrue(output == result)

    }

    @Test
    fun givenNonDecreasingSortedArrayWithOnlyValue_FindThirdMaximum() {

        val input = intArrayOf(1,2,3,4,5,6,7,8,9)
        val output = 7

        val result = FindThirdMaxSolution.thirdMax(input)

        input.forEach {
            print("$it, ")
        }

        assertTrue(output == result)

    }


}