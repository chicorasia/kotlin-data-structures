package leetCodeArray

fun main() {

    /**
     * Declare a new array with 10 places; each place
     * holds a 0.
     */
    val squareNumbers = IntArray(10)

    /**
     * Add a square number to each position, starting from
     * 1 all the way to 10. You have to add 1 to each index
     * because they are 0 to 9.
     */
    for(i in squareNumbers.indices) {
        val square = (i + 1) * (i + 1)
        squareNumbers[i] = square
    }

    squareNumbers.forEach {
        println(it)
    }

}