package leetCodeArray

class MoveZeroesSolution {

    companion object {

        fun moveZeroesFast(nums: IntArray): Unit {

            //handle edge cases
            if (nums.size <= 1) return

            /**
             * Use the two pointer technique
             */
            var head = 0
            var write = 0
            while (head < nums.size) {
                if (nums[head] == 0) {
                    head++
                } else {
                    nums[write++] = nums[head++]
                }
            }
            for (i in write until head) {
                nums[i] = 0
            }

        }

        fun moveZeroes(nums: IntArray): Unit {

            //handle edge cases
            if (nums.size <= 1) return

            /**
             * Use the two pointer technique
             */
            var head = 0
            var write = 0
            var n = nums.size
            while (head < n) {
                if (nums[head] != 0) {
                    nums[write++] = nums[head++]
                } else head++
            }
            while (write < n) {
                nums[write++] = 0
            }

        }

    }

}