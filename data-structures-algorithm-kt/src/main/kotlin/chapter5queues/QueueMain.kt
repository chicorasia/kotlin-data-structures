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

}