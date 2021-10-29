package leetCodeArray

/**
 * LeetCode Array101 In-Place Operations Solutions
 */
class InPlaceOperationsSolutions {

    companion object {

        fun replaceElements(arr: IntArray): IntArray {

            //check edge cases
            if (arr.isEmpty() || arr == null) {
                return arr
            }
            if (arr.size <= 1) {
                return intArrayOf(-1)
            }

            var greatest = arr.last()
            arr[arr.lastIndex] = -1
            var i = arr.lastIndex - 1

            while (i >= 0) {
                if (arr[i] > greatest) {
                    arr[i] = greatest.also {
                        greatest = arr[i]
                    }
                } else {
                    arr[i] = greatest
                }
                i--
            }

            return arr
        }



        /**
         * This is slower but uses less memory
         */
        fun replaceElementsSlow(arr: IntArray): IntArray {

            //check edge cases
            if (arr.isEmpty() || arr == null) {
                return arr
            }
            if (arr.size <= 1) {
                return intArrayOf(-1)
            }

            var n = arr.size - 1
            var i = 0
            while (i < n) {
                arr[i] = findMax(arr, i + 1, n)
                i++
            }
            arr[n] = -1

            return arr
        }

        fun findMax(arr: IntArray, start: Int, end: Int): Int {
            var max = Int.MIN_VALUE
            for (i in start..end) {
                if (arr[i] > max) {
                    max = arr[i]
                }
            }
            return max
        }

        /**
         * Can it be done recursively?
         */


    }


}
