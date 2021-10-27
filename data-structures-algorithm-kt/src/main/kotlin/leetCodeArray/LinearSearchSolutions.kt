package leetCodeArray

import com.sun.org.apache.xpath.internal.operations.Bool

class LinearSearchSolutions {

    companion object {

        fun checkIfExist(arr: IntArray): Boolean {

            /**
             * Check simultaneously for either doubles or halves; thusly it only needs to
             * traverse the array once in most cases. Will only check for halves if the number
             * is even.
             */
            for (i in arr.indices) {
                var double = arr[i] * 2
                var half = if (arr[i] % 2 == 0) arr[i] / 2 else null
                var start = i + 1
                if (linearSearchSubArray(arr, start, double, half)) return true
            }
            return false
        }


        /**
         * Search for doubles or halves in the subarray.
         */
        private fun linearSearchSubArray(arr:IntArray, start: Int, arg1: Int, arg2: Int?) : Boolean {
            for (i in start until arr.size) {
                if (arr[i] == arg1 || arr[i] == arg2) return true
            }
            return false

        }
    }





}