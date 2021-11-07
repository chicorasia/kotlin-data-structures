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
        println("Size: ${doubleLinkedList.size}")

    }

    "Double Linked List append".example {
        val anotherDoubleLinkedList = DoubleLinkedList<Int>()
        println("Tamanho: ${anotherDoubleLinkedList.size}")
        anotherDoubleLinkedList.append(1)
        anotherDoubleLinkedList.append(2)
        anotherDoubleLinkedList.append(3)

        println(anotherDoubleLinkedList.head)
        println("Size: ${anotherDoubleLinkedList.size}")

    }

    "Double Linked List insert".example {
        val doubleLinkedList = DoubleLinkedList<Int>()
        println("Tamanho: ${doubleLinkedList.size}")
        doubleLinkedList.push(1)
        doubleLinkedList.append(3)
        doubleLinkedList.append(5)
        println(doubleLinkedList.head)
        println("Inserting after 0")


        doubleLinkedList.insert(2, doubleLinkedList.nodeAt(2)!!)
        println(doubleLinkedList.head)
        println("Size: ${doubleLinkedList.size}")

    }

    "Find nodeAt()".example {
        val list = DoubleLinkedList<Int>()
        list.append(1)
        list.append(2)
        list.append(3)

        println(list.nodeAt(1))
    }

    "pop()".example {
        val list = DoubleLinkedList<Int>()
        list.append(1)
        list.append(2)
        list.append(3)

        println("Size:${list.size}")
        println("Popped: ${list.pop()}")
        println(list.head)
        println("Size: ${list.size}")
    }

    "removeLast()".example {
        val list = DoubleLinkedList<Int>()
        list.append(1)
        list.append(2)
        list.append(3)

        println(list.head)
        println("Size:${list.size}") //3
        println("Popped: ${list.removeLast()}") // 3
        println(list.head)
        println("Size: ${list.size}") //2
    }

    "removeAfter()".example {
        val list = DoubleLinkedList<Int>()
        list.append(1)
        list.append(2)
        list.append(3)
        list.append(4)

        println(list.head)
        println("Size:${list.size}") //4
        println("Remove after node 0: ${list.removeAfter(list.nodeAt(0)!!)}") // 2
        println(list.head)
        println("Size: ${list.size}") //3
    }



}