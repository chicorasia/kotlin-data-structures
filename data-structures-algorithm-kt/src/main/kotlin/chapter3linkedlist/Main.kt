package chapter3linkedlist

import example

fun main() {

    "creating and linking nodes".example {
        val node1 = Node(1)
        val node2 = Node(2)
        val node3 = Node(3)

        node1.next = node2
        node2.next = node3

        println(node1)
    }

    "push".example {
        val list = LinkedList<Int>()
        list.push(30)
        list.push(20)
        list.push(10)

        println(list)
    }

    "fluent interface push".example {
        val list = LinkedList<Int>()
        list.push(30)
        list.push(20)
        list.push(10)

        println(list)
    }

    "append".example {
        val list = LinkedList<Int>()
        list.append(30).append(20).append(10)

        println(list)
    }

    "inserting at a particular index".example {
        val list = LinkedList<Int>()
        list.push(3)
        list.push(2)
        list.push(1)

        println("before inserting: $list")
        var middleNode = list.nodeAt(1)!!
        for (i in 1..3) {
            middleNode = list.insert(-1 * i, middleNode)
        }
        println("after inserting: $list")
    }

    "pop".example {
        val list = LinkedList<Int>()
        list.push(3)
        list.push(2)
        list.push(1)

        println("Before popping list: $list")
        val poppedValue = list.pop()
        println("After popping list: $list")
        println("Popped value: $poppedValue")
    }

    "remove last".example {
        val list = LinkedList<Int>()
        list.push(4)
        list.push(3)
        list.push(2)
        list.push(1)

        println("Before remove last list: $list")
        var last = list.removeLast()
        println("After remove last list: $list")
        println("Popped value: $last")
        last = list.removeLast()
        println("After remove last list: $list")
        println("Popped value: $last")
    }

    "remove after particular node".example {
        val list = LinkedList<Int>()
        list.push(4)
        list.push(3)
        list.push(2)
        list.push(1)

        println("Before removing at particular index: $list")
        val index = 3
        val node = list.nodeAt(index - 1)!!
        val removedValue = list.removeAfter(node)

        println("After removing at $index: $list")
        println("Removed value: $removedValue")
    }

    "Iterator".example {
        val list = LinkedList<Int>()
        list.push(4)
        list.push(3)
        list.push(2)
        list.push(1)
        println(list)

        for (item in list) {
            println(item * item)
        }
    }

    "contains()".example {
        val list = LinkedList<Int>()
        list.push(4)
        list.push(3)
        list.push(2)
        list.push(1)
        println(list.contains(5))
    }

    "containsAll()".example {
        val list = LinkedList<Int>()
        list.push(4)
        list.push(3)
        list.push(2)
        list.push(1)

        val secondList = LinkedList<Int>()
        secondList.push(5)
        secondList.push(2)
        secondList.push(1)

        println(list)
        println(secondList)
        println(list.containsAll(secondList))
    }

    "remove()".example {
        val list = LinkedList<Int>()
        list.push(4)
        list.push(3)
        list.push(2)
        list.push(1)

        println(list)
        list.remove(1)
        println(list)
    }

    "retaining elements".example {
        val list = LinkedList<Int>()
        list.add(1)
        list.add(2)
        list.add(3)
        list.add(4)
        list.add(5)

        println(list)
        list.retainAll(listOf(1,5,3))
        println(list)
    }

    "remove all elements".example {
        val list = LinkedList<Int>()
        list.add(1)
        list.add(2)
        list.add(3)
        list.add(4)
        list.add(5)

        println(list)
        list.removeAll(listOf(1,3,5))
        println(list)

    }
}

