package doublelinkedlist

class DoubleLinkedList<T> : Iterable<T>, Collection<T> {

    var head: Node<T>? = null
    var tail: Node<T>? = null
    override var size: Int = 0
        private set

    override fun isEmpty(): Boolean = size == 0

    //push() -> adicionar na frente da lista (head)
    //append() -> adicionar no fim da lista (tail)
    //insert() -> adicionar em qualquer posição
    //nodeAt() -> retorna o nó na posição index
    //pop() -> retorna o primeiro elemento e remove da lista
    //removeLast() -> retorna o último elemento e remove da lista
    //removeAfter() -> retorna o elemento em uma posição arbitrária

    fun push(value: T): DoubleLinkedList<T> {
        head = Node(value = value, next = head).also { newNode ->
            head?.prev = newNode
        }
        if (tail == null) {
            tail = head
        }
        size++
        return this
    }

    fun append(value: T): DoubleLinkedList<T> {
        if (isEmpty()) {
            push(value)
            return this
        }
        tail?.next = Node(value = value, prev = tail).also {
            tail = it
        }
        size++
        return this
    }

    fun nodeAt(index: Int): Node<T>? {

        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException()
        }

        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }


    fun insert(value: T, afterNode: Node<T>): Node<T> {

        if (tail == afterNode) {
            append(value)
            return tail!!
        }

        val newNode = Node(value = value, prev = afterNode, next = afterNode.next)
        afterNode.next?.prev = newNode.also {
            afterNode.next = newNode
        }
        size++
        return newNode
    }

    fun pop(): T? {

        if (!isEmpty()) {
            return head?.value.also {
                head = head?.next
                head?.prev = null
                size--
            }
        }
        return null
    }

    fun removeLast(): T? {

        if (head == tail) {
            return pop()
        }

        if (!isEmpty()) {
            return tail?.value.also {
                tail = tail?.prev
                tail?.next = null
                size--
            }
        }

        return null

    }

    fun removeAfter(afterNode: Node<T>) : T? {

        /**
         * Removing the second to last element
         */
        if (afterNode == tail?.prev) {
            return removeLast()
        }

        val result = afterNode.next
        afterNode.next = result?.next
        result?.next?.prev = afterNode
        size--

        return result?.value ?: null

    }

    override fun iterator(): Iterator<T> = DoubleLinkedListIterator<T>(this)

    override fun contains(element: T): Boolean {
        for (item in this) {
            if (element == item) return true
        }
        return false
    }

    override fun containsAll(elements: Collection<T>): Boolean {

        for (searched in elements) {
            if (!contains(searched)) return false
        }
        return true
    }

    class DoubleLinkedListIterator<T>(
        private val list: DoubleLinkedList<T>,
        var index: Int = 0,
        var lastNode: Node<T>? = null //ultimo node acessado!

    ) : Iterator<T> {
        override fun hasNext(): Boolean {
            return index < list.size
        }

        override fun next(): T {
            if (index >= list.size) {
                throw IndexOutOfBoundsException()
            }

            if (index == 0) {
                lastNode = list.nodeAt(0)
            } else {
                lastNode = lastNode?.next
            }

            index++
            return lastNode!!.value

        }

    }



}
