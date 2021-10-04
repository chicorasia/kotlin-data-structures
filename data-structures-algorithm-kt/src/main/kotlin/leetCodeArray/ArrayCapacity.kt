package leetCodeArray

fun main() {

    /**
     * Instantiate a new empty array of capacity 6
     */
    val arrayOfsquares = IntArray(6)

    //This variable will track the actual number of items in the Array
    var length = 0

    /**
     * Add some squared integers and increment the
     * length counter
     */
    for (i in 0..2) {
        arrayOfsquares[i] = i * i
        length++
    }

    println("The Array has a capacity of ${arrayOfsquares.size}.")
    println("The Array has a length of $length.")
    arrayOfsquares.forEach { println(it) }


}