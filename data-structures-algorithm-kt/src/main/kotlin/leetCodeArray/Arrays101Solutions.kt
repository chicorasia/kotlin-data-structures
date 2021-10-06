package leetCodeArray

import kotlin.math.abs

class Solution {

    companion object {
        fun findMaxConsecutiveOnes(nums: IntArray): Int {

            /**
             * An optimization for empty arrays or arrays with
             * zeroes only. In the worst possible case the algorithm
             * may have O(2n) which is not really that bad.
             */
            if (!nums.contains(1)) {
                return 0
            } else {
                var maxOnes = Int.MIN_VALUE
                var runningTally = 0

                /**
                 * Traverse the array. If it is a "1", increment the
                 * running tally counter; if the runningTally is greater than
                 * current maxOnes, update maxOnes.
                 * If it is a "0", reset the runningTally.
                 */
                nums.forEach {
                    if (it == 1) {
                        runningTally++
                        if (runningTally > maxOnes) {
                            maxOnes = runningTally
                        }
                    } else {
                        runningTally = 0
                    }
                }

                return maxOnes
            }

        }

        /**
         * This is a very fast algorithm that relies on the
         * transformation of integer to String.
         */
        fun findNumbers(nums: IntArray): Int {

            var intWithEvenDigit = 0

            nums.forEach { integer ->
                if (integer.toString().length % 2 == 0) {
                    intWithEvenDigit++
                }
            }

            return intWithEvenDigit

        }


        fun mergeSortSquares(nums: IntArray, p: Int, r: Int) {

            if (p < r) {
                val q = (p + r) / 2
                mergeSortSquares(nums, p, q)
                mergeSortSquares(nums, q + 1, r)
                mergeSquares(nums, p, q, r)
            }
        }

        fun mergeSquares(nums: IntArray, p: Int, q: Int, r: Int) {

            val n1 = q - p + 1
            val n2 = r - q

            val L = IntArray(n1 + 1)
            val R = IntArray(n2 + 1)

            for (i in 0 until n1) {
                L[i] = nums[p + i]
            }

            for (j in 0 until n2) {
                R[j] = nums[q + j + 1]
            }

            L[n1] = Double.POSITIVE_INFINITY.toInt()
            R[n2] = Double.POSITIVE_INFINITY.toInt()

            var i = 0
            var j = 0

            for (k in p..r){
                if (abs(L[i]) <= abs(R[j])) {
                    nums[k] = L[i]
                    i++
                } else  {
                    nums[k] = R[j]
                    j++
                }
            }
        }

        fun sortedSquares(nums: IntArray): IntArray {

            mergeSortSquares(nums, 0, nums.size - 1)
            return nums.map {
                it * it
            }.toIntArray()

        }



    }
}