package leetCodeArray

class FindThirdMaxSolution {

    companion object {

        /** This is not very elegant but uses very little memory.
         * Keep a running tally of first max, second max and third max.
         * If a value is updated changes are cascaded down.
         * This runs in O(n) (a single traversal) and memory size O(1).
         *
         */
        fun thirdMax(nums: IntArray): Int {

            var firstMax: Long = Long.MIN_VALUE
            var secondMax: Long = Long.MIN_VALUE
            var thirdMax: Long = Long.MIN_VALUE
            var countDistinct = 0

            for (i in nums.indices) {
                var element = nums[i].toLong()

                if (element == firstMax || element == secondMax || element == thirdMax) {
                    continue
                }

                if (element > firstMax) {
                    thirdMax = secondMax
                    secondMax = firstMax
                    firstMax = element
                    countDistinct++
                }
                if (element > secondMax && element != firstMax) {
                    thirdMax = secondMax
                    secondMax = element
                    countDistinct++
                }
                if (element > thirdMax && element != secondMax && element != firstMax) {
                    thirdMax = element
                    countDistinct++
                }
            }

            if (countDistinct > 2) {
                return thirdMax.toInt()
            }

            return firstMax.toInt()

        }

        fun moveMaxToHead(nums: IntArray, start: Int, finish: Int): Int {
            var m = start
            var max = nums[start]
            while (m <= finish) {
                if (nums[m] > max) {
                    max = nums[m]
                    nums[start] = nums[m].also {
                        nums[m] = nums[start]
                    }
                }
                m++
            }
            return max

        }

    }
}
