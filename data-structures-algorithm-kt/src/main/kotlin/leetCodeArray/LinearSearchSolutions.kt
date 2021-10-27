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

        fun validMountainArray(arr: IntArray) : Boolean {

            /**
             * Check the edge cases first
             */
            if (arr.size < 3) return false

            /**
             * Traverse from each end using the two pointer technique
             */
            var i = 0
            var j = arr.size - 1


            while (arr[i] < arr[i + 1] && i < arr.size - 2 ) {
               i++
            }
            while (j > 0 && arr[j] < arr[j - 1]) {
                j--
                }

            if (i == arr.size - 1 || j == 0) return false
            else return i == j

        }

        fun validMountainArrayOld(arr: IntArray) : Boolean {

            /**
             * Check the edge cases first
             */
            if (arr.size < 3) return false

            /**
             * Use the runner technique to traverse faster
             */
            var i = 1
            var j = arr.size - 1

            while (i < arr.size && arr[i] > arr[i - 1] ) {
                i++
                if (i == arr.size - 1) { return false }
            }
            while (j > 0 && arr[j] < arr[j - 1]) {
                j--
                if (j == 0) { return false }
            }
            return i >= j
        }
    }





}