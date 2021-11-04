package leetCodeArray

import `3-linkedList`.LinkedList

class FindNumbersDisappearedSolutions {

    companion object {

        /**
         * A trivial solution using an auxiliary array of counters.
         */
        fun findDisappearedNumbers(nums: IntArray): List<Int> {

            val result = mutableListOf<Int>()
            val counterArray = IntArray(nums.size)

            /**
             * The array of counters is initialized with all zeroes.
             * Increment the value if it is found in the input array
             */
            nums.forEach { value ->
                counterArray[value - 1]++
            }

            /**
             * Add only the index of remaining zeroes to the output list
             */
            counterArray.forEachIndexed { index, value ->
                if (value == 0) result.add(index + 1)
            }

            return result

        }

        /**
         * This is an alternate solution. It removes numbers
         * from the result array.
         */
        fun findDisappearedNumbersWithHashSet(nums: IntArray): List<Int> {

            val result = HashSet<Int>()
            result.addAll(1..nums.size) //this is computationally expensive!

            nums.forEach { value ->
                result.remove(value)
            }

            return result.toList()

        }
    }

}