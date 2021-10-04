package kotlinStandardLibrary

fun main() {

    val box = Box<Int>()

    box.put(42)

    val result = box.retrieve()?.plus(10)

    println(result)

}

/**
 * An abstract box using generics. Once instantiated
 * it'll retain the object information.
 */

class Box<T> {
    var content: T? = null

    fun put(content: T?) {
        this.content = content
    }

    fun retrieve() : T? = content

    fun isEmpty() : Boolean = content == null
}

/**
 * A simple Box class to hold an object of type Any.
 * It can hold anything but we'll lose the knowledge
 * of the object put into it.
 */

//class Box {
//    var content: Any? = null
//
//    fun put(content: Any) {
//        this.content = content
//    }
//
//    fun retrieve() : Any? = content
//
//    fun isEmpty() : Boolean = content == null
//}