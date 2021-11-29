package chapter6trees

import example

fun main() {

    val tree = makeBeverageTree()
    "For each depth-first".example {
        tree.forEachDepthFirst {
            println(it.value)
        }
    }

    "For each level order".example {
        tree.forEachLevelOrder {
            println(it.value)
        }
    }

    "Search".example {
        tree.search("ginger ale")?.let{
            println("Found node: ${it.value}")
        }

        tree.search("WKD Blue")?.let {
            println(it.value)
        } ?: println("WKD Blue not found!")
    }

    "Print each level".example {
        tree.printEachLevel()
    }

}

private fun makeBeverageTree(): TreeNode<String> {
    val tree = TreeNode("Beverages")

    val hot = TreeNode("Hot")
    val cold = TreeNode("Cold")

    val tea = TreeNode("tea")
    val coffee = TreeNode("coffee")
    val chocolate = TreeNode("cocoa")
    val blackTea = TreeNode("black")
    val greenTea = TreeNode("green")
    val chaiTea = TreeNode("chai")
    val soda = TreeNode("soda")
    val milk = TreeNode("milk")
    val gingerAle = TreeNode("ginger ale")
    val bitterLemon = TreeNode("bitter lemon")

    tree.add(hot)
    tree.add(cold)

    hot.add(tea)
    hot.add(coffee)
    hot.add(chocolate)

    cold.add(soda)
    cold.add(milk)

    tea.add(blackTea)
    tea.add(greenTea)
    tea.add(chaiTea)

    soda.add(gingerAle)
    soda.add(bitterLemon)

    return tree
}