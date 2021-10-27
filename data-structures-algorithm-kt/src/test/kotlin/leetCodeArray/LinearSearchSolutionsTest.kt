package leetCodeArray

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class LinearSearchSolutionsTest {


    @Test
    fun givenArrayOfInt_CheckIfExists() {
        val arr = intArrayOf(10,2,5,3)
        val output = true

        val result = LinearSearchSolutions.checkIfExist(arr)

        assertTrue(output == result)
    }

    @Test
    fun givenAnotherArrayOfInt_CheckIfExists() {
        val arr = intArrayOf(7,1,14,11)
        val output = true

        val result = LinearSearchSolutions.checkIfExist(arr)

        assertTrue(output == result)
    }

    @Test
    fun givenYetAnotherArrayOfInt_CheckIfExists() {
        val arr = intArrayOf(3,1,7,11)
        val output = false

        val result = LinearSearchSolutions.checkIfExist(arr)

        assertTrue(output == result)
    }

    @Test
    fun givenArrayOfZeroes_CheckIfExists() {
        val arr = intArrayOf(0,0)
        val output = true

        val result = LinearSearchSolutions.checkIfExist(arr)

        assertTrue(output == result)
    }

    @Test
    fun givenArrayOfOne_CheckIfExistsReturnsFalse() {
        val arr = intArrayOf(1)
        val output = false

        val result = LinearSearchSolutions.checkIfExist(arr)

        assertTrue(output == result)
    }

    @Test
    fun givenEmptyArray_CheckIfExistsReturnsFalse() {
        val arr = intArrayOf()
        val output = false

        val result = LinearSearchSolutions.checkIfExist(arr)

        assertTrue(output == result)
    }

    @Test
    fun givenArrayWithNegativeInts_CheckIfExistsReturnsFalse() {
        val arr = intArrayOf(-20,8,-6,-14,-19,14,4)
        val output = true

        val result = LinearSearchSolutions.checkIfExist(arr)

        assertTrue(output == result)
    }

}