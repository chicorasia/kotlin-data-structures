package leetCodeQueueAndStack

class MyCircularQueueSolution {

    /**
     * This is Circular Queue without a counter. It uses very little memory
     * but does not run as fast as I would like.
     */
    class MyCircularQueue(k: Int) {

        private val storage = IntArray(k)
        private var rear = -1
        private var front = -1


        fun enQueue(value: Int): Boolean {
            return if (!isFull()) {
                rear++
                if (rear == storage.size) {
                    rear = 0
                }
                if (front == -1) {
                    front = 0
                }
                storage[rear] = value
                true
            } else {
                false
            }
        }

        fun deQueue(): Boolean {

            return if (isEmpty()) {
                false
            } else if (front == rear) {    //condition for a single element
                front = -1
                rear = -1
                true
            } else { //condition for more than one element
                front++
                if (front == storage.size) {
                    front = 0
                }
                true
            }
        }

        fun Front(): Int {
            if (isEmpty()) return -1
            return storage[front]
        }

        fun Rear(): Int {
            if (isEmpty()) return -1
            return storage[rear]
        }

        /**
         * The queue is empty when front is moved to position -1
         */
        fun isEmpty(): Boolean {
            return front == -1
        }

        /**
         * This trick uses the modulo operator to find if the queue is full.
         */
        fun isFull(): Boolean {
            return ((rear + 1) % storage.size == front)
        }

    }

}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * var obj = MyCircularQueue(k)
 * var param_1 = obj.enQueue(value)
 * var param_2 = obj.deQueue()
 * var param_3 = obj.Front()
 * var param_4 = obj.Rear()
 * var param_5 = obj.isEmpty()
 * var param_6 = obj.isFull()
 */
