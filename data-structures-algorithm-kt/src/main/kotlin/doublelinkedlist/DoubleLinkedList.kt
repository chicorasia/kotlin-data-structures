package doublelinkedlist

class DoubleLinkedList<T> {

    var head: Node<T>? = null
    var tail: Node<T>? = null
    var size: Int = 0
        private set

    fun isEmpty(): Boolean = size == 0

    //push() -> adicionar na frente da lista (head)
    //append() -> adicionar no fim da lista (tail)
    //insert() -> adicionar em qualquer posição
    //nodeAt() -> retorna o nó na posição index

    fun push(value: T) : DoubleLinkedList<T> {
        head = Node(value = value, next = head).also { newNode ->
            head?.prev = newNode
        }
        if (tail == null) {
            tail = head
        }
        size++
        return this
    }

    fun append(value: T) : DoubleLinkedList<T> {
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

    fun nodeAt(index: Int) : Node<T>? {

        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException()
        }

        var currentNode = head
        var currentIndex = 0

        while (currentNode  != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }


    fun insert(value: T, afterNode: Node<T>) : Node<T> {

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

}
