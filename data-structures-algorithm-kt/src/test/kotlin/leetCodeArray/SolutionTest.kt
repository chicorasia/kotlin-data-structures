package leetCodeArray

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SolutionTest {

    val nums = intArrayOf(1,1,0,1,1,1,0,1,0,0,0,1,1,0)
    val moreNums = intArrayOf(1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0)
    val allZeroes = intArrayOf(0,0,0,0,0,0,0,0)

    val numsDigits = intArrayOf(555,901,482,1771)
    val moreNumDigits = intArrayOf(0,1,3,5)

    @Test
    fun givenArrayOfInts_MustReturnMaxConsecutiveOnes() {

        val result1 = Solution.findMaxConsecutiveOnes(nums)
        val result2 = Solution.findMaxConsecutiveOnes(moreNums)
        val result3 = Solution.findMaxConsecutiveOnes(allZeroes)

        assertTrue(result1 == 3)
        assertTrue(result2 == 14)
        assertTrue(result3 == 0)

    }

//    @Test
//    fun givenArrayOfInts_MustReturnNumberOfItemsWithEvenDigitCount() {
//
////        val result1 = Solution.findNumbersFaster(numsDigits)
//        val result2 = Solution.findNumbersFaster(moreNumDigits)
//
////        assertTrue(result1 == 1)
//        assertTrue(result2 == 0)
//
//
//    }

    @Test
    fun givenArrayOfInts_MustReturnArrayOfSortedSquares() {

        val nums = intArrayOf(-7,-3,2,3,11)
        val response = intArrayOf(4,9,9,49,121)

        val result = Solution.sortedSquares(nums)

        assertTrue(response.contentEquals(result))



    }

}