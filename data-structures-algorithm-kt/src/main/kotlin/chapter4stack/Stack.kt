package chapter4stack

/**
 * A basic Stack interface with its typical operations.
 */
interface Stack<Element> {

    fun push(element: Element)

    fun pop() : Element?

    fun peek() : Element?

    val count: Int

    val isEmpty: Boolean
        get() = count == 0

}

/**
 * Implementation of a Stack
 */

class StackImpl<T: Any>() : Stack<T> {

    private val storage = arrayListOf<T>()

    override val count: Int
        get() = storage.size

    override fun toString(): String =
        buildString {
            appendLine("----top----")
            storage.asReversed().forEach {
                appendLine("$it")
            }
            appendLine("-----------")
        }


    /**
     * Adds an element to top the stack by pushing it to
     * the tail of the ArrayList
     */
    override fun push(element: T) {
        storage.add(element)
    }

    /**
     * If the storage array is empty return null.
     * Otherwise, return the top (last) element.
     */
    override fun pop(): T? {
        if (isEmpty) {
            return null
        }
        return storage.removeAt(count - 1)
    }

    /**
     * Look at the top element without popping it from the stack
     */
    override fun peek(): T? =  storage.lastOrNull()

    /**
     * A companion object for static factory methods
     */
    companion object {

        /**
         * This method creates a stack from a List. It is useful
         * for when we want to enforce the access to the elements
         * in a list.
         */
        fun <Element : Any> create(items: Iterable<Element>) : Stack<Element> {
            val stack = StackImpl<Element>()
            for (item in items) {
                stack.push(item)
            }
            return stack
        }

        /**
         * Now we can use the above method to create a stack
         * using varargs:
         */
        fun <Element: Any> stackOf(vararg elements: Element) : Stack<Element> {
            return StackImpl.create(elements.asList())
        }


    }

}