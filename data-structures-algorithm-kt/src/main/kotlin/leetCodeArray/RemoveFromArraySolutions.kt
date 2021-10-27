package leetCodeArray

class RemoveFromArraySolutions {

    companion object {

        fun removeElement(nums: IntArray, `val`: Int): Int {
            var k = 0
            var i = 0
            while (i < nums.size) {
                if (nums[i] != `val`) {
                    nums[k] = nums[i]
                    k++
                }
                i++
            }
            return k
        }


        fun removeDuplicate(nums: IntArray): Int {

            if (nums.isEmpty()) return 0
            if (nums.size == 1) return 1

            var head = 0
            var sorted = 0

            while(head < nums.size) {
                if(nums[head] == nums[sorted]) {
                    head++
                } else {
                    nums[++sorted] = nums[head++]
                }
            }
            return ++sorted

        }
    }

}

fun IntArray.removeAt(i: Int, `val`: Int): Int {
    var m = 0
    for (k in i until this.size - 1) {
        if (this[k + 1] == `val`) {
            m += removeAt(k + 1, `val`)
        }
        this[k] = this[k + 1]
    }
    return ++m
}


fun IntArray.firstIndexOf(n: Int): Int {
    for (i in this.indices) {
        if (this[i] == n) return i
    }
    return -1
}
