package doublelinkedlist

class DoubleLinkedList<T> : Iterable<T>, Collection<T>, MutableIterable<T>, MutableCollection<T> {

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

//        if (index < 0 || index >= size) {
//            throw IndexOutOfBoundsException()
//        }

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

    override fun iterator(): MutableIterator<T> = DoubleLinkedListIterator<T>(this)

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

    ) : MutableIterator<T> {
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

        override fun remove() {
            if (index == 1) {
                list.pop()
            } else {
                val prevNode = lastNode?.prev ?: return
                list.removeAfter(prevNode)
                lastNode = prevNode
            }
            index--

        }

    }

    override fun add(element: T): Boolean {
        append(element)
        return true
    }

    override fun addAll(elements: Collection<T>): Boolean {
        for (item in elements) {
            append(item)
        }
        return true
    }

    override fun clear() {
        head = null
        tail = null
        size = 0
    }

    override fun remove(element: T): Boolean {
        //obter um iterator
        //percorrer a coleção até achar o elemento
        //remover na posição
        //retorno true ou false
        val iterator = iterator()
        while (iterator.hasNext()) {
            val item = iterator.next() //primeira coisa que ele faz é incrementar o iterador!
            if (item == element) {
                iterator.remove()
                return true
            }
        }
        return false
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        var result = false
        for (searched in elements){
            result = remove(searched) || result
        }
        return result
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        var result = false
        val iterator = iterator()
        while (iterator.hasNext()) {
            val item = iterator.next()
            if (!elements.contains(item)) {
                iterator.remove()
                result = true
            }
        }
        return result
    }


}
