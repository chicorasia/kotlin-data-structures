package chapter5queues

import example

fun main() {

    "Double Stack Queue".example {
        val queue = DoubleStackQueue<String>().apply {
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