package leetCodeQueueAndStack

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MyCircularQueueSolutionTest {

    @Test
    fun givenQueue_MustReturnIsFull_WhenFull() {

        val queue = MyCircularQueueSolution.MyCircularQueue(3)
        queue.enQueue(1)
        queue.enQueue(2)
        queue.enQueue(3)

        val result = queue.isFull()
        val output = true

        assertTrue(result == output)

    }

    @Test
    fun givenFullQueue_MustReturnFalse_WhenTryEnqueue() {

        val queue = MyCircularQueueSolution.MyCircularQueue(4)
        queue.enQueue(1)
        queue.enQueue(2)
        queue.enQueue(3)
        queue.deQueue()
        queue.enQueue(4)
        queue.enQueue(4)

        val result = queue.enQueue(5)
        val output = false

        assertTrue(result == output)

    }

    @Test
    fun givenEmptyQueue_FrontMustReturnMinusOne() {

        val queue = MyCircularQueueSolution.MyCircularQueue(4)
        val result = queue.Front()
        val output = -1

        assertTrue(result == output)

    }

    @Test
    fun givenEmptyQueue_RearMustReturnMinusOne() {

        val queue = MyCircularQueueSolution.MyCircularQueue(4)
        queue.enQueue(1)
        queue.deQueue()
        val result = queue.Front()
        val output = -1

        assertTrue(result == output)

    }


    @Test
    fun givenQueue_MustReturnIsEmpty_WhenEmpty() {

        val queue = MyCircularQueueSolution.MyCircularQueue(3)
        queue.enQueue(1)
        queue.enQueue(2)
        queue.enQueue(3)
        queue.deQueue()
        queue.deQueue()
        queue.deQueue()

        val result = queue.isEmpty()
        val output = true

        assertTrue(result == output)

    }

    @Test
    fun givenQueue_MustReturnFrontAndRearElements() {

        val queue = MyCircularQueueSolution.MyCircularQueue(5)
        queue.enQueue(1)
        queue.enQueue(2)
        queue.enQueue(3)
        queue.enQueue(4)
        queue.enQueue(5)

        val front = queue.Front()
        val front_out = 1

        val rear = queue.Rear()
        val rear_out = 5

        assertTrue(front == front_out)
        assertTrue(rear == rear_out)

    }

    @Test
    fun givenQueue_MustRepeatExample() {

        val queue = MyCircularQueueSolution.MyCircularQueue(5)
        queue.enQueue(5)
        queue.enQueue(13)
        queue.enQueue(8)
        queue.enQueue(2)
        queue.enQueue(10)
        println("Queue is full? ${queue.isFull()}")
        queue.deQueue()
        queue.deQueue()
        queue.enQueue(23)
        queue.enQueue(6)
        println("Queue is full again? ${queue.isFull()}")

        queue.deQueue()
        queue.deQueue()
        queue.deQueue()
        queue.deQueue()
        queue.deQueue()
        println("Queue is empty? ${queue.isEmpty()}")

    }

    @Test
    fun giverQueueWithSingleElement_MustReturnItAsRearAndFront() {

        val queue = MyCircularQueueSolution.MyCircularQueue(5)
        queue.enQueue(5)
        val front = queue.Front()
        val rear = queue.Rear()

        println("Front: $front, Rear: $rear")
        assertTrue(front == 5)
        assertTrue(rear == 5)

    }




}