package chapter2complexity

fun main() {

    multiplicationBoard(100)

}

/**
 * Prints a multiplication board.
 * Has O(n^2) time complexity!
 */
fun multiplicationBoard(size: Int) {
    for (number in 1..size) {
        print(" | ")
        for (otherNumber in 1..size) {
            print("$number x $otherNumber = ${number * otherNumber} |")
        }
        println()
    }
}