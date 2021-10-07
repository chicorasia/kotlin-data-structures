package leetCodeArray

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class InsertIntoArraySolutionsTest {

    @Test
    fun mustDuplicateZeroes_WhenReceivesAnArrayWithZeroes() {
        val input = intArrayOf(1,0,2,3,0,4,5,0)
        val output = intArrayOf(1,0,0,2,3,0,0,4)

        val input2 = intArrayOf(0,1,7,6,0,2,0,7)
        val output2 = intArrayOf(0,0,1,7,6,0,0,2)

        val input3 = intArrayOf(1,2,3)
        val output3 = intArrayOf(1,2,3)


        InsertIntoArraySolutions.duplicateZeroes(input2)
        InsertIntoArraySolutions.duplicateZeroes(input)
        InsertIntoArraySolutions.duplicateZeroes(input3)
        input2.forEach { print("$it, ") }
        println()


        assertTrue(input2.contentEquals(output2))
        assertTrue(input.contentEquals(output))
        assertTrue(input3.contentEquals(output3))

    }

    @Test
    fun mustNotDuplicateZeroes_WhenReceivesAnArrayWithNoZeroes() {

        val input3 = intArrayOf(1,2,3)
        val output3 = intArrayOf(1,2,3)
        InsertIntoArraySolutions.duplicateZeroes(input3)
        assertTrue(input3.contentEquals(output3))

    }


}