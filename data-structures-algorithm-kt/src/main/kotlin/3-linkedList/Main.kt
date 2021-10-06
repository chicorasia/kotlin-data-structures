package `3-linkedList`

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

}

/**
 * A simple extension function to format and print
 * an example of code
 */
fun String.example(block: () -> Unit) {
    print("--- Example of $this ---")
    println()
    block()

}