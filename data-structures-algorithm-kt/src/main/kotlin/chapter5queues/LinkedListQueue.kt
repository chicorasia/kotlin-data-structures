package chapter5queues

import doublelinkedlist.DoubleLinkedList

/**
 * This class implements a Queue based on the DoubleLinkedList class.
 */
class LinkedListQueue<T> : Queue<T> {

    private val list = DoubleLinkedList<T>()

    private var size = 0

    /**
     * The queue mus keep track of its size because
     * it can't modify the list's size property.
     */
    override val count: Int
        get() = size

    /**
     * Use append() to enqueue an element (add it to the
     * back of the queue). Increment the size property.
     * It runs on O(1).
     */
    override fun enqueue(element: T): Boolean {
        list.append(element)
        size++
        return true
    }

    /**
     * Check for null then pop the element at the
     * head of the queue. Decrement the size property
     * if an element has been removed.
     * It has time complexity O(1)
     */
    override fun dequeue(): T? {
        val firstNode = list.firstOrNull()
        firstNode?.let {
            size--
            return list.pop()
        }
        return null
    }

    /**
     * Look at the fisrt element in the queue without
     * removing it.
     */
    override fun peek(): T? = list.firstOrNull()

    override fun toString(): String = list.toString()

}