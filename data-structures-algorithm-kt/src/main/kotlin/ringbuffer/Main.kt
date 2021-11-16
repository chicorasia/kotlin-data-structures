package ringbuffer

import example

fun main() {

    "Ring buffer ".example {
        val buffer = RingBuffer<String>(4)
        println(buffer.isEmpty())
        buffer.write("Jack")
        buffer.write("Will")
        buffer.write("Dave")
        buffer.write("Bootstrap")
        buffer.write("Barbosa")
        buffer.write("Tyler")


        println(buffer)
        println(buffer.read())
        println(buffer.read())
        println(buffer.read())
        println(buffer.read())
        println(buffer)

    }


}