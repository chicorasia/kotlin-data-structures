package KotlinStandardLibrary

fun main() {

    println(maximum(10, 40))

    printMax(50, 60)

}

fun maximum(a: Int, b: Int): Int {
    return if (a > b) a else b
}

fun printMax(c: Int, d: Int) {
    val maxValue = maximum(c, d)
    println(maxValue)
}