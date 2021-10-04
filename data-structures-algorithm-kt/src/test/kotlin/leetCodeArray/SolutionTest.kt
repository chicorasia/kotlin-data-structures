package leetCodeArray

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SolutionTest {

    val nums = intArrayOf(1,1,0,1,1,1,0,1,0,0,0,1,1,0)
    val moreNums = intArrayOf(1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0)
    val allZeroes = intArrayOf(0,0,0,0,0,0,0,0)

    @Test
    fun givenArrayOfInts_MustReturnMaxConsecutiveOnes() {

        val result1 = Solution.findMaxConsecutiveOnes(nums)
        val result2 = Solution.findMaxConsecutiveOnes(moreNums)
        val result3 = Solution.findMaxConsecutiveOnes(allZeroes)

        assertTrue(result1 == 3)
        assertTrue(result2 == 14)
        assertTrue(result3 == 0)

    }

}