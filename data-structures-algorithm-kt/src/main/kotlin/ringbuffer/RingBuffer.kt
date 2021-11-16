package ringbuffer

/**
 * Implementing a RingBuffer using and array of fixed size
 * as storage. I can't use Array<T> so used Arra<Any> because
 * the type has to be known in compile time.
 * "size" property must be public because the Queue interface
 * needs to track its size.
 */
class RingBuffer<T>(private val size: Int) {

    private val storage: Array<Any?> = Array(size) {null}
    private var read: Int = 0
    private var write: Int = 0

    var count = 0
        private set

    fun isFull() = count == size

    /**
     * Retrieve a value from the "read" position and
     * move the cursor.
     */
    fun read() : T? {
        val result = storage[read]
        read++
        count--
        if (read == size) read = 0
        return result as T
    }

    /**
     * Retrieve a value from "read" position but do not move
     * the cursor
     */
    fun peek() : T? {
        return storage[read] as T
    }

    /**
     * Check if the RingBuffer is full. If not, rite a value into
     * the "write" position and move the cursor.
     */
    fun write(element: T) : Boolean {
        if (count < size) {
            storage[write] = element
            write++
            count++
            if (write == size) write = 0
            return true
        }
        return false
    }

    /**
     * The buffer is empty when both cursors are at the
     * same position.
     */
    fun isEmpty() : Boolean = read == write

    /**
     * A convenience method for printing out the buffer.
     */
    override fun toString(): String {
        val string = StringBuilder()
        string.append("[")
        for (e in storage) {
            string.append ("$e, ")
        }
        string.append("]")
        return string.toString()
    }
}