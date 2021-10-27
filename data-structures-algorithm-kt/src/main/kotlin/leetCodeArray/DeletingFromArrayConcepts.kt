package leetCodeArray

fun main() {

    /**
     * Declare an empty array of capacity 10
     */
    var intArray = IntArray(10)

    /**
     * This variable keeps track of the actual number of filled positions
     */
    var length = 0


    /**
     * Add numbers to positions 0 through 5
     */
    for (i in 0 until 10) {
        intArray[length++] = i
    }

    /**
     * "Delete" the last element
     */
    length--

    intArray[length] = 10
    length++

    for (i in intArray.indices) {
        println("Index $i contains ${intArray[i]}")
    }

    /**
     * Delete the first element
     */
    println("Deleting at intArray[0]")
    for (i in 0 until length - 1) {
        println("shifting ${i + 1} to $i")
        intArray[i] = intArray[i + 1]
    }
    length--

    for (i in intArray.indices) {
        println("Index $i contains ${intArray[i]}")
    }

    println("***** \n Deleting at intArray[4]")
    for (i in 4 until intArray.size - 1) {
        println("shifting ${i + 1} to $i")
        intArray[i] = intArray[i + 1]
    }
    length--

    for (i in intArray.indices) {
        println("Index $i contains ${intArray[i]}")
    }

}