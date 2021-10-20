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

    @Test
    fun givenArrayOfInts_MustReturnArrayOfSortedSquares() {

        val nums = intArrayOf(-7,-3,2,3,11)
        val response = intArrayOf(4,9,9,49,121)

        val result = Solution.sortedSquares(nums)

        assertTrue(response.contentEquals(result))

    }

    @Test
    fun givenTwoSortedArrays_MustMergeIntoSortedArray() {

        val nums1 = intArrayOf(1,2,3,0,0,0,0,0,0)
        val m = 3
        val nums2 = intArrayOf(2,5,6,6,8,9)
        val n = 6

        Solution.mergeSortedArrays(nums1, m, nums2, n)
        val response = intArrayOf(1,2,2,3,5,6,6,8,9)

        nums1.forEach {
            print("$it ->")
        }
        println()

        assertTrue(nums1.contentEquals(response))
    }

    @Test
    fun givenTwoSortedArrays2_MustMergeIntoSortedArray() {

        val nums1 = intArrayOf(2,3,4,0,0)
        val m = 3
        val nums2 = intArrayOf(6,7)
        val n = 2

        Solution.mergeSortedArrays(nums1, m, nums2, n)
        val response = intArrayOf(2,3,4,6,7)

        nums1.forEach {
            print("$it ->")
        }
        println()

        assertTrue(nums1.contentEquals(response))
    }

    @Test
    fun givenTwoSortedArrays3_MustMergeIntoSortedArray() {

        val nums1 = intArrayOf(1,1,1,0,0)
        val m = 3
        val nums2 = intArrayOf(0,0)
        val n = 2

        Solution.mergeSortedArrays(nums1, m, nums2, n)
        val response = intArrayOf(0,0,1,1,1)

        nums1.forEach {
            print("$it ->")
        }
        println()

        assertTrue(nums1.contentEquals(response))
    }

    @Test
    fun givenTwoSortedArrays4_MustMergeIntoSortedArray() {

        val nums1 = intArrayOf(0,0,0,0,0,0)
        val m = 2
        val nums2 = intArrayOf(0,0,1,1)
        val n = 4

        Solution.mergeSortedArrays(nums1, m, nums2, n)
        val response = intArrayOf(0,0,0,0,1,1)

        nums1.forEach {
            print("$it ->")
        }
        println()

        assertTrue(nums1.contentEquals(response))
    }

    @Test
    fun givenTwoSortedArrays5_MustMergeIntoSortedArray() {

        val nums1 = intArrayOf(2,0)
        val m = 1
        val nums2 = intArrayOf(1)
        val n = 1

        Solution.mergeSortedArrays(nums1, m, nums2, n)
        val response = intArrayOf(1,2)

        nums1.forEach {
            print("$it ->")
        }
        println()

        assertTrue(nums1.contentEquals(response))
    }

    @Test
    fun givenTwoSortedArrays_MustReturnLeftArrayIfRightIsEmpty() {

        val nums1 = intArrayOf(1)
        val m = 1
        val nums2 = intArrayOf()
        val n = 0

        Solution.mergeSortedArrays(nums1, m, nums2, n)
        val response = intArrayOf(1)

        assertTrue(nums1.contentEquals(response))
    }

    @Test
    fun givenTwoSortedArrays_MustReturnRightArrayIfLeftIsEmpty() {

        val nums1 = intArrayOf(0)
        val m = 0
        val nums2 = intArrayOf(1)
        val n = 1

        Solution.mergeSortedArrays(nums1, m, nums2, n)
        val response = intArrayOf(1)

        assertTrue(nums1.contentEquals(response))
    }

}