package chapter4stack

import chapter4stack.StackImpl.Companion.stackOf
import example

fun main() {

    "using a stack".example {
        val stack = StackImpl<Int>().apply {
            push(1)
            push(2)
            push(3)
            push(4)
        }
        print(stack)
        val poppedElement = stack.pop()
        poppedElement?.let{
            println("Popped: $it")
        }
        print(stack)
    }

    "stack from list".example {
        val list = listOf("A", "B", "C","D")
        val stack = StackImpl.create(list)
        print(stack)
        println("Peek: ${stack.peek()}")
        println("Popped: ${stack.pop()}")
    }

    "stack from an array literal".example {
        val stack = stackOf(1.0, 2.0, 3.0, 4.0)
        print(stack)
        println("Popped: ${stack.pop()}")
    }
}