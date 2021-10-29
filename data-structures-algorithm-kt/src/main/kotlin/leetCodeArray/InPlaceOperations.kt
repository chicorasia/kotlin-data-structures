package leetCodeArray

fun main() {

    val arr = intArrayOf(9, -2, -9, 11, 56, -12, -3)

    val result = squareEven(arr)

    result.forEach {
        print("$it,")
    }

}

/**
 * A very fast algorithm to square elements in place.
 */
fun squareEven(array: IntArray) : IntArray {

    if (array == null) return array

    var i = 0
    while(i < array.size) {
        array[i] *= array[i]
        i += 2
    }
    return array

}