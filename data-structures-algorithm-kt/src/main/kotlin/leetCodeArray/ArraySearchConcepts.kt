package leetCodeArray

fun main() {

    val array = IntArray(6)

    var length = 0

    for (i in 0..5) {
        array[length++] = i
    }

    println("Does the array contain the element 4? ${linearSearch(array, length, 4)}")
    println("Does the array contain the element 30? ${linearSearch(array, length, 30)}")

}

/**
 * A very simple Linear Search algorithm. It runs in O(n).
 */
fun linearSearch(array: IntArray?, length: Int, element: Int) : Boolean {

    //Handle the edge cases
    if (array == null || length == 0) return false

    //Iterate through the array until a match is found
    for (i in 0 until length) {
        if (array[i] == element) return true
    }
    return false
}