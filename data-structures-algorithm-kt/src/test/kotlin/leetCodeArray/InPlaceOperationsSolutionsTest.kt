package leetCodeArray

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class InPlaceOperationsSolutionsTest {

    @Test
    fun givenArrayOfUnorderedElements_ReplaceElementsToTheRight() {

        val arr = intArrayOf(17, 18, 5, 4, 6, 1)
        val solution = intArrayOf(18, 6, 6, 6, 1, -1)

        val output = InPlaceOperationsSolutions.replaceElements(arr)

        arr.forEach {
            print("$it, ")
        }
        println("**** End Test ***")

        assertTrue(output.contentEquals(solution))
    }

    @Test
    fun givenArrayOfSingleElement_ReplaceWithMinusOne() {

        val arr = intArrayOf(400)
        val solution = intArrayOf(-1)

        val output = InPlaceOperationsSolutions.replaceElements(arr)

        arr.forEach {
            print("$it, ")
        }

        println("**** End Test ***")

        assertTrue(output.contentEquals(solution))
    }

    @Test
    fun givenArray_FindMaximumToTheRight() {

        val arr = intArrayOf(17, 18, 5, 4, 6, 1)
        val solution = 18

        val max = InPlaceOperationsSolutions.findMax(arr, 0, arr.size - 1)

        println("**** End Test ***")

        assertTrue(solution == max)

    }

    @Test
    fun givenDecreasingArray_ReplaceToTheRight() {
        val arr = intArrayOf(10, 9, 8, 7)
        val solution = intArrayOf(9, 8, 7, -1)

        val output = InPlaceOperationsSolutions.replaceElements(arr)

        arr.forEach {
            print("$it, ")
        }
        println("**** End Test ***")
        assertTrue(output.contentEquals(solution))
    }

    @Test
    fun givenNonDecreasingArray_ReplaceToTheRight() {
        val arr = intArrayOf(7,8,9,10)
        val solution = intArrayOf(10,10,10, -1)

        val output = InPlaceOperationsSolutions.replaceElements(arr)

        arr.forEach {
            print("$it, ")
        }
        println("**** End Test ***")
        assertTrue(output.contentEquals(solution))
    }

    @Test
    fun givenArrayOfTwoElement_ReplaceToTheRight() {
        val arr = intArrayOf(1,1)
        val solution = intArrayOf(1, -1)

        val output = InPlaceOperationsSolutions.replaceElements(arr)

        arr.forEach {
            print("$it, ")
        }
        println("**** End Test ***")
        assertTrue(output.contentEquals(solution))
    }

    @Test
    fun givenNonDecreasingArrayOfTwoElement_ReplaceToTheRight() {
        val arr = intArrayOf(1,2)
        val solution = intArrayOf(2, -1)

        val output = InPlaceOperationsSolutions.replaceElements(arr)

        arr.forEach {
            print("$it, ")
        }
        println("**** End Test ***")
        assertTrue(output.contentEquals(solution))
    }

    @Test
    fun givenArrayOfZeroes_ReplaceToTheRight() {
        val arr = intArrayOf(0,0,0,0,0,0)
        val solution = intArrayOf(0,0,0,0,0,-1)

        val output = InPlaceOperationsSolutions.replaceElements(arr)

        arr.forEach {
            print("$it, ")
        }
        println("**** End Test ***")
        assertTrue(output.contentEquals(solution))
    }

}