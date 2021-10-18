package `3-linkedList`

/**
 * This data class represents a simple node in a Linked List.
 */
data class Node<T>(
    var value: T,
    var next: Node<T>? = null
) {
    override fun toString(): String {
        return if (next != null) {
            "$value -> ${next.toString()}"
        } else {
            "$value"
        }
    }


}
