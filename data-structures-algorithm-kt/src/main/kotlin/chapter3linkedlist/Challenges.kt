package chapter3linkedlist

import example

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

    "Reversed list".example {
        val list = LinkedList<Int>()
        list.add(1)
        list.add(2)
        list.add(3)
        list.add(4)
        list.add(5)

        println("Original:")
        println(list)
        println("Reversed:")
        println(list.reversed())
    }


    "merge lists".example {
        val list = LinkedList<Int>()
        list.add(1)
        list.add(2)
        list.add(3)
        list.add(4)
        list.add(5)
        val other = LinkedList<Int>()
        other.add(-1)
        other.add(0)
        other.add(2)
        other.add(2)
        other.add(7)

        println("Left: $list")
        println("Right: $other")
        println("Merged: ${list.mergeSorted(other)}")
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


/**
 * This is a helper method to traverse a list adding values in reversed order.
 */
fun <T> addInReverse(list: LinkedList<T>, node: Node<T>){
    val next = node.next
    if (next != null) {
        addInReverse(list, next)
    }
    list.append(node.value)
}

/**
 * Run at O(n)
 */
fun <T> LinkedList<T>.reversed() : LinkedList<T> {
    val result = LinkedList<T>()
    val head = this.nodeAt(0)
    if (head != null) {
        addInReverse(result, head)
    }
    return result
}


/**
 * TODO: understand these better.
 */
fun <T: Comparable<T>> LinkedList<T>.mergeSorted(otherList: LinkedList<T>) : LinkedList<T> {
    if (this.isEmpty()) return otherList
    if (otherList.isEmpty()) return this

    val result = LinkedList<T>()

    // add merging function here
    var left = nodeAt(0)
    var right = otherList.nodeAt(0)

    while (left != null && right != null) {
        if (left.value < right.value) {
            left = append(result, left)
        } else {
            right = append(result, right)
        }
    }

    while (left != null) {
        left = append(result, left)
    }
    while (right != null) {
        right = append(result, right)
    }
    return result

}

private fun <T: Comparable<T>> append(result: LinkedList<T>, node: Node<T>) : Node<T>? {
    result.append(node.value)
    return node.next
}