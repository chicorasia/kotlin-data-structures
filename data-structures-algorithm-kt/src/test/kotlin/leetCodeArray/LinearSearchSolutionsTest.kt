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

    @Test
    fun givenValidMountainArray_MustReturnTrue() {

        val arr = intArrayOf(0,3,2,1)
        val output = true

        val result = LinearSearchSolutions.validMountainArray(arr)

        assertTrue(output == result)
    }

    @Test
    fun givenArrayOfSizeTwo_MustReturnFalse() {

        val arr = intArrayOf(2,1)
        val output = false

        val result = LinearSearchSolutions.validMountainArray(arr)

        assertTrue(output == result)
    }

    @Test
    fun givenInvalidMountainArray_MustReturnFalse() {

        val arr = intArrayOf(3,5,5)
        val output = false

        val result = LinearSearchSolutions.validMountainArray(arr)

        assertTrue(output == result)
    }

    @Test
    fun givenAnotherValidMountainArray_MustReturnTrue() {

        val arr = intArrayOf(0,2,3,4,5,2,1,0)
        val output = true

        val result = LinearSearchSolutions.validMountainArray(arr)

        assertTrue(output == result)
    }

    @Test
    fun givenArrayWithMiniPeak_MustReturnFalse() {

        val arr = intArrayOf(0,2,3,3,5,2,1,0)
        val output = false

        val result = LinearSearchSolutions.validMountainArray(arr)

        assertTrue(output == result)
    }

    @Test
    fun givenArrayWithMiniPeak2_MustReturnFalse() {

        val arr = intArrayOf(0,2,2,4,5,5,1,0)
        val output = false

        val result = LinearSearchSolutions.validMountainArray(arr)

        assertTrue(output == result)
    }

    @Test
    fun givenArrayWithAllZeroes_MustReturnFalse() {

        val arr = intArrayOf(0,0,0,0,0,0,0,0)
        val output = false

        val result = LinearSearchSolutions.validMountainArray(arr)

        assertTrue(output == result)
    }

    @Test
    fun givenArrayWithNegatives_MustReturnTrue() {

        val arr = intArrayOf(-2,1,3,100,90,70,5,-1000)
        val output = true

        val result = LinearSearchSolutions.validMountainArray(arr)

        assertTrue(output == result)
    }

    @Test
    fun givenLinearArray_MustReturnFalse() {

        val arr = intArrayOf(0,1,2,3,4,5,6,7,8,9)
        val output = false

        val result = LinearSearchSolutions.validMountainArray(arr)

        assertTrue(output == result)
    }

    @Test
    fun givenDecreasingArray_MustReturnFalse() {

        val arr = intArrayOf(9,8,7,6,5,4,3,2,1)
        val output = false

        val result = LinearSearchSolutions.validMountainArray(arr)

        assertTrue(output == result)
    }



}