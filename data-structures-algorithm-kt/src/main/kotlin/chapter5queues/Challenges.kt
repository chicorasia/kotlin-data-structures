package chapter5queues

import chapter4stack.StackImpl
import example

fun main() {

    "BoardGame manager with queue".example {
        val playerQueue = RingBufferQueue<String>(4).apply {
            enqueue("Vincent")
            enqueue("Remel")
            enqueue("Lukiih")
            enqueue("Allison")
        }

        println(playerQueue)
        println("==== BoardGame ====")
        println("Next: ${playerQueue.nextPlayer()}")
        println(playerQueue)
        println("Next: ${playerQueue.nextPlayer()}")
        println(playerQueue)
        println("Next: ${playerQueue.nextPlayer()}")
        println(playerQueue)
        println("Next: ${playerQueue.nextPlayer()}")
        println(playerQueue)
    }

    "Reverse queue".example {
        val queue = ArrayListQueue<String>().apply {
            enqueue("1")
            enqueue("21")
            enqueue("18")
            enqueue("42")
        }

        println("before: $queue")
        queue.reverse()
        println("after: $queue")
    }


}

/**
 * Repeatedly dequeue and enqueue the next player...
 */
fun <T> Queue<T>.nextPlayer() : T? {
    val person = this.dequeue() ?: return null
    this.enqueue(person)
    return person
}

/**
 * Reversing a queue
 */

fun <T : Any> Queue<T>.reverse() {

    /**
     * Create an auxiliary stack
     */
    val aux = StackImpl<T>()

    /**
     * Start popping elements from the queue and adding them to stack.
     * Do it until the Queue is empty.
     */
    var next = this.dequeue()
    while(next != null) {
        aux.push(next)
        next = this.dequeue()
    }

    /**
     * pop elements from the aux stack and add them to the queue
     * until the stack is empty
     */
    next = aux.pop()
    while(next != null) {
        this.enqueue(next)
        next = aux.pop()
    }




}