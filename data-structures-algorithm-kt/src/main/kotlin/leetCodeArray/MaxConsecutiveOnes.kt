package leetCodeArray

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

    }
}