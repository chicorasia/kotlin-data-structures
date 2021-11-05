package chapter5queues


/**
 * This class implements a Queue based on
 * an ArrayList
 */
class ArrayListQueue<T> : Queue<T> {

    private val list = arrayListOf<T>()

    override val count: Int
        get() = list.size

    /**
     * Enqueue runs in amortized O(1) because it requires
     * the array to be resized from time to time
     */
    override fun enqueue(element: T): Boolean {
        list.add(element)
        return true
    }

    /**
     * Dequeue runs in O(n) because it requires the
     * remaingin elements to be shifted towards the front
     * of the array.
     */
    override fun dequeue(): T? {
        return if (isEmpty) null else list.removeAt(0)
    }

    /**
     * Peek also runs in O(1)
     */
    override fun peek(): T? {
        return list.getOrNull(0)
    }

    override fun toString() : String = list.toString()
}