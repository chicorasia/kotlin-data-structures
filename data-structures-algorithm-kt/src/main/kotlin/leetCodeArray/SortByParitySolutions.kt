package leetCodeArray

class SortByParitySolutions {

    companion object {

        fun sortArrayByParityV1(nums: IntArray): IntArray {

            if (nums.size <= 1) return nums

            var odd = nums.lastIndex
            var even = 0

            while (odd > 0 && even < nums.lastIndex) {
                if (odd > even) {
                    nums[even] = nums[odd].also {
                        nums[odd] = nums[even]
                    }
                    if (nums[even].isEven()) {
                        even++
                    }
                    if (!nums[odd].isEven()) {
                        odd--
                    }
                } else {
                    break
                }
            }
            return nums
        }

        fun Int.isEven(): Boolean {
            return this % 2 == 0
        }

        fun swapAt(arr: IntArray, pos1: Int, pos2: Int) {
            arr[pos1] = arr[pos2].also {
                arr[pos2] = arr[pos1]
            }
        }

        /**
         * A slighter fast version of sort by parity.
         * Thbis algorithm uses a two pointer technique to traverse
         * the array only once. Starting from each end of the array,
         * swap elements, check parity, and move the cursors.
         * Its downfall is the need to swap elements on every
         * cycle (even if they are sorted).
         * This can be greatly optimized.
         */
        fun sortArrayByParity(nums: IntArray): IntArray {

            if (nums.size <= 1) return nums

            var odd = nums.lastIndex
            var even = 0

            while (odd > even) {
                nums[even] = nums[odd].also {
                    nums[odd] = nums[even]
                }
                if (nums[even] % 2 == 0) {
                    even++
                }
                if (nums[odd] % 2 != 0) {
                    odd--
                }
            }
            return nums
        }

    }


}