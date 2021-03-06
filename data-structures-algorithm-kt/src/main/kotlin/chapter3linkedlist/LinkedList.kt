package chapter3linkedlist

/**
 * This class defines a LinkedList<T> with generic type (actually, it'll
 * use the same type of its nodes).
 */
class LinkedList<T> : Iterable<T>, Collection<T>, MutableIterable<T>, MutableCollection<T> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    override var size = 0
        private set

    /**
     * Simple method to tell if the list is empty
     */
    override fun isEmpty() = size == 0

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
    fun push(value: T): LinkedList<T> {
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
    fun append(value: T): LinkedList<T> {
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
    fun nodeAt(index: Int): Node<T>? {

        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException()
        }

        // start at the head of the list
        var currentNode = head
        var currentIndex = 0

        // start traversing and keep a tally until it reaches index
        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }

        return currentNode
    }

    /**
     * This method inserts a value after a specific node
     */
    fun insert(value: T, afterNode: Node<T>): Node<T> {

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
    fun pop(): T? {
        if (!isEmpty()) size--
        val result = head?.value
        head = head?.next

        if (isEmpty()) {
            tail = null
        }

        return result

    }

    /**
     * This is my implementation, it is different from the book's.
     * I'm not sure it covers all cases, but so far it seems to work.
     */

    fun removeLast(): T? {

        /**
         * If head and tail are the same, list has size 1. Delegate
         * removeLast() to pop().
         */
        if (head == tail) return pop()

        /**
         * If not empty, traverse the array and check each node's next
         * node next attribute for null. If not null, move one node down
         * and check again.
         * If null, assign the currentNode's next value to lastValue. Then,
         * clear the pointer to the former last node, decrement
         * size and return lastValue.
         */
        if (!isEmpty()) {
            var currentNode = head
            while (currentNode?.next?.next != null) {
                currentNode = currentNode.next
            }
            val lastValue = currentNode?.next?.value
            currentNode?.next = null
            tail = currentNode
            size--
            return lastValue
        }

        return null

    }

    /**
     * removeAfter(): parameter Node, return Value
     */
    fun removeAfter(node: Node<T>): T? {
        val result = node.next?.value

        /**
         * If removing the tail of the list update the tail
         */
        if (node.next == tail) {
            tail = node
        }

        /**
         * Decrement size if the element to remove is not null
         */
        if (node.next != null) {
            size--
        }

        node.next = node.next?.next
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

    /**
     * This method returns a LinkedListIterator for the LinkedList class
     */
    override fun iterator(): MutableIterator<T> = LinkedListIterator<T>(this)

    /**
     * This class defines a specific Iterator.
     * LinkedListIterator is a concrete object that implements the
     * Iterator<T> interface. It has two mandatory methods: hasNext()
     * and next().
     * It uses two auxiliary properties:
     *      - index: keeps track of the current iterator position
     *      - lastNode: keeps track of the last node
     */
    class LinkedListIterator<T>(
        private val list: LinkedList<T>,
        private var index: Int = 0,
        private var lastNode: Node<T>? = null
    ) : Iterator<T>, MutableIterator<T> {


        /**
         * Checks wether the index has reached the last element
         * by comparing it with the size of the list.
         */
        override fun hasNext(): Boolean {
            return index < list.size
        }

        override fun next(): T {
            /**
             * Checks wether there are still elements to return
             */
            if (index >= list.size) {
                throw IndexOutOfBoundsException()
            }

            /**
             * I got a little confused with this syntax :D
             * If it's the first iteration, lastNode is position 0;
             * otherwise, lastNode moves down the list by receiving the
             * next one.
             */
//            lastNode = if (index == 0) {
//                list.nodeAt(0)
//            } else {
//                lastNode?.next
//            }

            /**
             * This sintax is easier to read but does the exact same thing:
             */
            if (index == 0) {
                lastNode = list.nodeAt(0)
            } else {
                lastNode = lastNode?.next
            }

            /**
             * Increment the index counter and return the "lastNode" as
             * the next value.
             */
            index++
            return lastNode!!.value
        }

        /**
         *
         */
        override fun remove() {
            if (index == 1) {
                list.pop()
            } else {
                val prevNode = list.nodeAt(index - 2) ?: return
                list.removeAfter(prevNode)
                lastNode = prevNode
            }
            index--
        }

    }

    /**
     * These methods are required for Collection<T>
     * contains(element) runs in O(n) because
     * it has to iterate through all the elements.
     *
     */
    override fun contains(element: T): Boolean {
        for (item in this) {
            if (element == item) return true
        }
        return false
    }

    /**
     * containsAll() is based on contains(). It is very inefficient
     * and runs in O(n^2)
     */
    override fun containsAll(elements: Collection<T>): Boolean {
        for (searched in elements) {
            if (!contains(searched)) return false
        }
        return true
    }

    /**
     * These are the mandatory methods for a MutableCollection<T>.
     */

    /**
     * A LinkedList has no fixed size, so it will append the new
     * element and return true.
     */
    override fun add(element: T): Boolean {
        this.append(element)
        return true
    }

    /**
     * addAll() takes advantage of the Collection's iterator
     * and simply calls the append() function to add each element
     */
    override fun addAll(elements: Collection<T>): Boolean {
        for (element in elements) {
            this.append(element)
        }
        return true
    }

    /**
     * clear() resets the head, the tail and the size
     */
    override fun clear() {
        head = null
        tail = null
        size = 0
    }

    /**
     * remove() uses and iterator to traverse the list and look for the
     * desired element.
     */
    override fun remove(element: T): Boolean {
        val iterator = iterator()
        while (iterator.hasNext()) {
            val item = iterator.next()
            if (item == element) {
                iterator.remove()
                return true
            }
        }
        return false
    }

    /**
     * Return true if any items have been removed
     */
    override fun removeAll(elements: Collection<T>): Boolean {
        var result = false
        for (item in elements) {
            result = remove(item) || result
        }
        return result
    }

    /**
     * Keep the elements passed as a parameter and remove all others.
     * Return true if any elements have been removed.
     */
    override fun retainAll(elements: Collection<T>): Boolean {
        var result = false
        val iterator = this.iterator()
        while (iterator.hasNext()) {
            val item = iterator.next()

            /**
             * Remove the current item if it is not in elements
             */
            if (!elements.contains(item)) {
                iterator.remove()
                result = true
            }
        }
        return result
    }
}