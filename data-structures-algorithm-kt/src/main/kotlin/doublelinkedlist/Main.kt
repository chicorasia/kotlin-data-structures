package doublelinkedlist

import example

fun main() {

    "Double Linked List push".example {
        val doubleLinkedList = DoubleLinkedList<Int>()
        println("Tamanho: ${doubleLinkedList.size}")
        doubleLinkedList.push(1)
        doubleLinkedList.push(2)
        doubleLinkedList.push(3)

        println(doubleLinkedList.head)
        println("Tamanho: ${doubleLinkedList.size}")

    }

    "Double Linked List append".example {
        val anotherDoubleLinkedList = DoubleLinkedList<Int>()
        println("Tamanho: ${anotherDoubleLinkedList.size}")
        anotherDoubleLinkedList.append(1)
        anotherDoubleLinkedList.append(2)
        anotherDoubleLinkedList.append(3)

        println(anotherDoubleLinkedList.head)
        println("Tamanho: ${anotherDoubleLinkedList.size}")

    }

    "Double Linked List insert".example {
        val doubleLinkedList = DoubleLinkedList<Int>()
        println("Tamanho: ${doubleLinkedList.size}")
        doubleLinkedList.push(1)
        doubleLinkedList.append(3)
        doubleLinkedList.append(5)
        println(doubleLinkedList.head)
        println("Inserindo depois de 0")


        doubleLinkedList.insert(2, doubleLinkedList.nodeAt(2)!!)
        println(doubleLinkedList.head)
        println("Tamanho: ${doubleLinkedList.size}")

    }

    "Find nodeAt()".example {
        val list = DoubleLinkedList<Int>()
        list.append(1)
        list.append(2)
        list.append(3)

        println(list.nodeAt(1))
    }



}