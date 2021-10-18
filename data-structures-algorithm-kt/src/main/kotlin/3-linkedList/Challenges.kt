package `3-linkedList`

fun main() {


    "Print in reverse".example {
        val list = LinkedList<Int>()
        list.add(1)
        list.add(2)
        list.add(3)
        list.add(4)
        list.add(5)

        list.printInReverse()
        println()
    }

    "Item in the middle".example {
        val list = LinkedList<Int>()
        list.add(3)
        list.add(2)
        list.add(1)
        list.add(4)
        list.add(5)

        println(list.getMiddle()?.value)
    }

    "Reverse".example {
        val list = LinkedList<Int>()
        list.add(1)
        list.add(2)
        list.add(3)
        list.add(4)
        list.add(5)

        println(list.reversed())
        println()
    }

}

/**
 * An extension function to print the nodes in reverse order.
 * It uses a recursive strategy, stacking calls to itself until
 * it finds a node with next == null (the last node). Then it
 * unravels the stack, printing out the items in reverse order.
 */
fun <T> LinkedList<T>.printInReverse() {
    this.nodeAt(0)?.printInReverse()

}

/**
 * This extension function does the actual printing. It is called
 * recursively starting fromt the first node. The if statement is
 * essentially cosmetic - it adds an arrow and spaces in every node
 * except the tail of the list.
 * Time complexity: O(n)
 */
fun <T> Node<T>.printInReverse() {
    this.next?.printInReverse()
    if (this.next != null) {
        print(" -> ")
    }
    print(this.value.toString())

}

/**
 * This algorithm uses the runner technique.
 * Starting from the head, the fast cursor traverses the list
 * twice as fast as the slow cursor. Once the fast cursor finds the
 * end fo the list, return the slow cursor.
 * Time complexity: O(n)
 */
fun <T> LinkedList<T>.getMiddle() : Node<T>? {
    var slow = nodeAt(0)
    var fast = nodeAt(0)
    while (fast != null) {
        fast = fast.next
        if(fast != null) {
            fast = fast.next
            slow = slow?.next
        }
    }
    return slow
}

