package leetCodeArray

class InsertIntoArraySolutions {

    companion object {

        fun duplicateZeroes(arr: IntArray): Unit {

            val aux = IntArray(arr.size + arr.countZeroes())
            var cursor = 0

            for (i in arr.indices) {
                if (arr[i] == 0) {
                    aux[cursor] = arr[i]
                    aux[cursor + 1] = 0
                    cursor += 2
                } else {
                    aux[cursor] = arr[i]
                    cursor ++
                }
            }

            for (i in arr.indices) {
                arr[i] = aux[i]
            }
        }

        private fun IntArray.countZeroes() : Int {
            var count = 0
            forEach {
                if (it == 0) {
                    count++
                }
            }
            return count
        }
    }
}