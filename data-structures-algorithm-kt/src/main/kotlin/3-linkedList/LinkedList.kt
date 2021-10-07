package `3-linkedList`

/**
 * This class defines a LinkedList<T> with generic type (actually, it'll
 * use the same type of its nodes).
 */
class LinkedList<T> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0

    /**
     * Simple method to tell if the list is empty
     */
    fun isEmpty() = size == 0

    /**
     * push() is used to insert a value at the front of the list.
     * It abstracts Node creation and requires only a value.
     * It the list is not empty, the newly added Node will point
     * to the former head. If the list is empty (tail == null),
     * the newly added node is both the head and tail of the list.
     * Increment list size after insertion.
     *
     * Returning the LinkedList allows for the use of a fluent interface
     * abd chained operations.
     */
    fun push(value: T) : LinkedList<T> {
        head = Node(value = value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
        return this
    }

    /**
     * The append operation adds a value in the end of the list.
     * It the list is empty simply use push() to add a value.
     * If not, make the current tail point to the new Node
     * and assign the new node to the tail property.
     */
    fun append(value: T) : LinkedList<T> {
        if (isEmpty()) {
            push(value)
            /**
             * early return needed otherwise it'll append more than once
             */
            return this
        }
        tail?.next = Node(value = value).also { newNode ->
            tail = newNode
        }
        size++
        return this
    }

    /**
     * Find a specific node at the given index.
     */
    fun nodeAt(index: Int) : Node<T>? {

        // start at the head of the list
        var currentNode = head
        var currentIndex = 0

        // start traversing and keep a tally until it reaches index
        while (currentNode != null && currentIndex < index){
            currentNode = currentNode.next
            currentIndex++
        }

        return currentNode
    }

    /**
     * This method inserts a value after a specific node
     */
    fun insert(value: T, afterNode: Node<T>) : Node<T> {

        /**
         * If we are inserting after the tail
         * just use append()
         */
        if (tail == afterNode) {
            append(value)
            return tail!!
        }

        /**
         * Create a newNode with value; its next property points
         * to the afterNode's next. Then, set the newNode as the
         * next Node of afterNode. Don't forget to increment
         * the List size.
         */
        val newNode = Node(value = value, next = afterNode.next)
        afterNode.next = newNode
        size++
        return newNode
    }

    /**
     * pop() removes an element at the front of the list (head)
     */
    fun pop() : T? {
        if (!isEmpty()) size--
        val result = head?.value
        head = head?.next

        if (isEmpty()) {
            tail = null
        }

        return result

    }

    /**
     * Will iterate through the items, starting
     * from the Node at the head of the list
     */
    override fun toString(): String {
        return if (isEmpty()) {
            "Empty List"
        } else {
            head.toString()
        }
    }

}