/**
 * A simple extension function to format and print
 * an example of code
 */
fun String.example(block: () -> Unit) {
    print("--- Example of $this ---")
    println()
    block()

}