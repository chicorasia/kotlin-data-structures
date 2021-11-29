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
    zero.leftChild = ten
    zero.rightChild = eleven

    val tree = seven

    println(tree)

    println(tree)
    "Traverse in order".example {
        tree.traverseInOrder {
            print("$it ")
        }
        println()
    }

    "Pre-order Traverse".example {
        tree.traversePreOrder {
            print("$it ")
        }
        println()
    }

    "Post-order Traverse".example {
        tree.traversePostOrder {
            print("$it ")
        }
        println()
    }

    "Height of tree".example {
        println("The height is ${tree.height()}")
    }


}