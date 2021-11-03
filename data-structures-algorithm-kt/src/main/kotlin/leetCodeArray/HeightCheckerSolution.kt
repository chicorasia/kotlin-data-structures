package leetCodeArray

class HeightCheckerSolution {

    companion object {

        fun heightCheckerV1(heights: IntArray): Int {

            //check edge cases
            if (heights.size <= 1) return 0

            var k = 0
            val expected = heights.sortedArray()
            for (i in heights.indices) {
                if (heights[i] != expected[i]) {
                    k++
                }
            }

            return k

        }

        fun heightChecker(heights: IntArray): Int {

            var k = 0
            var i = 0
            val expected = heights.sortedArray()
            while (i <= heights.lastIndex) {
                if (heights[i] != expected[i]) {
                    k++
                }
                i++
            }

            return k

        }
    }

}