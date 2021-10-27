package leetCodeArray

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class RemoveFromArraySolutionsTest {

    @Test
    fun givenArrayOfInts_RemoveValuesInPlace() {

        val nums = intArrayOf(3,2,2,3)
        val `val` = 3
        val output = 2

        val result = RemoveFromArraySolutions.removeElement(nums, `val`)

        nums.forEach {
            print("$it,")
        }
        println("result: $result")
        assertTrue(result == output)
    }

    @Test
    fun givenAnotherArrayOfInts_RemoveValuesInPlace() {

        val nums = intArrayOf(0,1,2,2,3,0,4,2)
        val `val` = 2
        val output = 5

        val result = RemoveFromArraySolutions.removeElement(nums, `val`)

        nums.forEach {
            print("$it,")
        }
        println("***")
        println("Result: $result")

        assertTrue(result == output)
    }

    @Test
    fun givenAnotherArrayOfTwoInts_RemoveValuesInPlace() {

        val nums = intArrayOf(4,5)
        val `val` = 4
        val output = 1
        val outputArray = intArrayOf(5,5)

        val result = RemoveFromArraySolutions.removeElement(nums, `val`)

        nums.forEach {
            print("$it,")
        }
        println("***")
        println("Result: $result")

        assertTrue(result == output)
    }

    @Test
    fun givenAnotherArrayWithNoIntsToRemove_RemoveNothing() {

        val nums = intArrayOf(4,5,6)
        val `val` = 7
        val output = 3
        val outputArray = intArrayOf(4,5,6)

        val result = RemoveFromArraySolutions.removeElement(nums, `val`)

        nums.forEach {
            print("$it,")
        }
        println("***")
        println("Result: $result")

        assertTrue(result == output)
    }

    @Test
    fun givenArrayWithDuplicates_RemoveDuplicatesInPlace() {

        val nums = intArrayOf(0,0,1,1,1,2,2,3,3,4)
        val output = 5

        val result = RemoveFromArraySolutions.removeDuplicate(nums)

        nums.forEach {
            print("$it,")
        }
        println("***")
        println("Result: $result")

        assertTrue(result == output)

    }

    @Test
    fun givenArrayWithDuplicates2_RemoveDuplicatesInPlace() {

        val nums = intArrayOf(1,1,2)
        val output = 2

        val result = RemoveFromArraySolutions.removeDuplicate(nums)

        nums.forEach {
            print("$it,")
        }
        println("***")
        println("Result: $result")

        assertTrue(result == output)

    }

    @Test
    fun givenArrayWithNoDuplicates2_ReturnArraySize() {

        val nums = intArrayOf(1,2,3)
        val output = 3

        val result = RemoveFromArraySolutions.removeDuplicate(nums)

        nums.forEach {
            print("$it,")
        }
        println("***")
        println("Result: $result")

        assertTrue(result == output)

    }

    @Test
    fun givenArrayWithAllDuplicates_ReturnOne() {

        val nums = intArrayOf(1,1,1,1,1,1,1,1)
        val output = 1

        val result = RemoveFromArraySolutions.removeDuplicate(nums)

        nums.forEach {
            print("$it,")
        }
        println("***")
        println("Result: $result")

        assertTrue(result == output)

    }

    @Test
    fun givenArrayWithTwoItems_ReturnOne() {

        val nums = intArrayOf(1,1)
        val output = 1

        val result = RemoveFromArraySolutions.removeDuplicate(nums)

        nums.forEach {
            print("$it,")
        }
        println("***")
        println("Result: $result")

        assertTrue(result == output)

    }

    @Test
    fun givenArrayWithOneItem_ReturnOne() {

        val nums = intArrayOf(1)
        val output = 1

        val result = RemoveFromArraySolutions.removeDuplicate(nums)

        nums.forEach {
            print("$it,")
        }
        println("***")
        println("Result: $result")

        assertTrue(result == output)

    }



}