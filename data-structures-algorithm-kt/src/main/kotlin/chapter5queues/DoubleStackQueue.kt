package chapter5queues

import chapter4stack.StackImpl

class DoubleStackQueue<T : Any>: Queue<T> {
    private val rightStack = StackImpl<T>()
    private val leftStack = StackImpl<T>()

    override val isEmpty: Boolean
        get() = rightStack.isEmpty && leftStack.isEmpty


    override val count: Int
        get() = rightStack.count + leftStack.count

    /**
     * Enqueued elements are pushed into the right stack.
     * it always works so return true.
     */
    override fun enqueue(element: T): Boolean {
        rightStack.push(element)
        return true
    }

    /**
     * To dequeue an element, first check if the stack is empty.
     * If it is, transfer elements from the right stack and then
     * pop from the left stack.
     * If not, simply pop from the stack.
     */
    override fun dequeue(): T? {
        if (leftStack.isEmpty) {
            transferElements()
        }
        return leftStack.pop()
    }

    /**
     * If the leftstack is empty, transfer elements.
     * Then, look at the topmost element in the
     * left stack without removing it.
     */
    override fun peek(): T? {
        if (leftStack.isEmpty) {
            transferElements()
        }
        return leftStack.peek()
    }

    /**
     * Convenience method to transfer elements from
     * the right stack to the left stack.
     */
    private fun transferElements() {
        var nextElement = rightStack.pop()
        while (nextElement != null) {
            leftStack.push(nextElement)
            nextElement = rightStack.pop()
        }
    }

    /**
     * Convenience method for printing out the stacks
     */
    override fun toString(): String {
        return "Left stack:\n$leftStack \n Right Stack: \n$rightStack"
    }

}