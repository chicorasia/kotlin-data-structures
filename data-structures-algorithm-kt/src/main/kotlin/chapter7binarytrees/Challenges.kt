package chapter7binarytrees

import example


fun main() {

    val zero = BinaryNode(0)
    val one = BinaryNode(1)
    val five = BinaryNode(5)
    val seven = BinaryNode(7)
    val eight = BinaryNode(8)
    val nine = BinaryNode(9)
    val ten = BinaryNode(10)
    val eleven = BinaryNode(11)

    seven.leftChild = one
    one.leftChild = zero
    one.rightChild = five
    seven.rightChild = nine
    nine.leftChild = eight
//    zero.leftChild = ten
//    zero.rightChild = eleven

    val tree = seven

    println(tree)

    "Desserialization with pre-order".example {
        val list = tree.serialize()
        println(list)
        val newTree = deserializeOptimized(list)
        println(newTree)

    }
}

/**
 * This deserialization function recursively builds BinaryNodes
 * from a list in pre-ordered fashion.
 *
 */
fun <T> deserialize(list: MutableList<T?>) : BinaryNode<T?>? {

//    val rootValue = list.removeFirst() ?: return null // basic deserialization
    val rootValue = list.removeLast() ?: return null // faster deserialization
    val rootNode = BinaryNode<T?>(rootValue)
    rootNode.leftChild = deserialize(list)
    rootNode.rightChild = deserialize(list)

    return rootNode
}

fun <T> deserializeOptimized(list: MutableList<T?>) : BinaryNode<T?>? {
    return deserialize(list.asReversed())
}



