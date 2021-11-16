package chapter5queues

import example

fun main() {

    "Queue with Ring Buffer".example {
        val queue = RingBufferQueue<String>(3).apply {
            enqueue("Ray")
            enqueue("Brian")
            enqueue("Eric")
        }

        println(queue)
        queue.dequeue()
        println(queue)
        println("Next up: ${queue.peek()}")

    }

}