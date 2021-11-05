package chapter4stack

import chapter3linkedlist.LinkedList
import chapter4stack.StackImpl.Companion.create
import example

fun main() {

    val list = LinkedList<String>()
    list.add("A")
    list.add("B")
    list.add("C")
    list.add("D")
    list.add("E")

    "Reverse linked list".example {
        list.printInReverse()
    }

    "Check parenthesis".example {
        val string = "((Hello World))"
        println(string)
        println(string.checkParentheses())

        val unbalancedString = "(()"
        println(unbalancedString)
        println(unbalancedString.checkParentheses())
    }

}

/**
 * Reverse a linked list.
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
fun <T : Any> LinkedList<T>.printInReverse() {

    /**
     * Create a stack from the LinkedList
     */
    val stack = create(this)

    /**
     * Add each node to the top of the stack,
     * effectively creating a copy of the
     * list in the form of a stack. This is redundant
     * because I've used the static factory method
     * to create the stack.
     */
//    for (node in this) {
//        stack.push(node)
//    }

    /**
     * An auxiliary variable to help empty the stack
     */
    var node = stack.pop()

    /**
     * Keep popping nodes from the stack until
     * it is empty. There's no iterator, so just
     * use a while loop and reassign the node variable
     */
    while (node != null) {
        println(node)
        node = stack.pop()
    }

}

/**
 * Check for balanced parenthesis.
 * Time complexity: O(n)
 * Size complesity: O(n)
 */
fun String.checkParentheses() : Boolean {

    val stack = StackImpl<Char>()

    /**
     * Iterate through the characters. Push every opening
     * parenthesis into the stack. Pop one character
     * for each closing parenthesis. Stack should be
     * empty by the end. If it runs out of characters
     * it is imbalanced - return false.
     */
    for (character in this) {
        when (character) {
            '(' -> stack.push(character)
            ')' -> if (stack.isEmpty) {
                return false }
                else {
                    stack.pop()
            }
        }
    }
    return stack.isEmpty

}