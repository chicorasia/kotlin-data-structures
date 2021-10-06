package `2-complexity`

fun main() {

    val unsorted = listOf<Int>(11,-4,25,36,5)

    printSortedEff(unsorted)
}


/**
 * This is a simple but memory hungry algorithm. It creates
 * a sorted copy of the original List. It has space complexity O(n).
 */
fun printSorted(numbers: List<Int>) {
    val sorted = numbers.sorted()
    for (element in sorted) {
        println(element)
    }
}

/**
 * This version of printSorted() has space complexity O(1)
 */
fun printSortedEff(numbers: List<Int>) {

    /**
     * Check for the case of an empty list
     */
    if(numbers.isEmpty()) return

    /**
     * currentCount keeps track of the number of print statements made
     * minValue stores the last printed value
     */
    var currentCount = 0
    var minValue = Int.MIN_VALUE

    /**
     * Print all the numbers that match minValue and update
     * currentCount
     */
    for (value in numbers) {
        if (value == minValue) {
            println(value)
            currentCount++
        }
    }

    /**
     * Find the lowest value bigger than minValue and
     * store it in currentValue
     */
    while (currentCount < numbers.size) {

        var currentValue = numbers.maxOrNull()!!

        for (value in numbers) {
            if (value in (minValue + 1) until currentValue) {
                currentValue = value
            }
        }

        /**
         * Prints all values of currentValue inside the array
         * and update currentCount
         */
        for (value in numbers) {
            if (value == currentValue) {
                println(value)
                currentCount++
            }
        }

        /**
         * update minValue for the next iteration
         */
        minValue =  currentValue

    }

}