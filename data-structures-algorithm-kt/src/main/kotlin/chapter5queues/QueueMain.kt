package chapter5queues

import example

fun main() {

    "Queue with ArrayList".example {
        val queue = ArrayListQueue<String>().apply {
            enqueue("Ray")
            enqueue("Brian")
            enqueue("Eric")
        }

        println(queue)
        println("Dequeueing: ${queue.dequeue()}")
        println(queue)
        println("Next up: ${queue.peek()}")
    }

    "Queue with Doubly Linked List".example {
        val queue = LinkedListQueue<String>().apply {
            enqueue("Ray")
            enqueue("Brian")
            enqueue("Eric")
        }

        println(queue)
        println("Dequeueing: ${queue.dequeue()}")
        println("Next up: ${queue.peek()}")
        println(queue)
    }

    "Empty queue".example {
        val queue = LinkedListQueue<Int>()

        println(queue)
        println("Dequeueing: ${queue.dequeue()}")
        println(queue)
        println("Next up: ${queue.peek()}")

    }

}