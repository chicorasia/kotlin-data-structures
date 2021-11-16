package chapter5queues

import ringbuffer.RingBuffer

/**
 * A Queue based on a RingBuffer.
 */
class RingBufferQueue<T>(size: Int) : Queue<T> {

    private val ringBuffer = RingBuffer<T>(size)

    override val count: Int
        get() = ringBuffer.count

    override fun enqueue(element: T): Boolean {
        return ringBuffer.write(element)
    }

    override fun dequeue(): T? = if (isEmpty) null else ringBuffer.read()

    /**
     * Check if the buffer is empty before removing an item
     * to prevent buffer underflows.
     */
    override fun peek(): T? = ringBuffer.peek()

    override fun toString(): String = ringBuffer.toString()
}