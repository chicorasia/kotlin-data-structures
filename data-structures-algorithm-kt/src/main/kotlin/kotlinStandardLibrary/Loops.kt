package kotlinStandardLibrary

fun main() {

    for (i in 1..3) {
        println(i)
    }

    var x = 10
    while (x > 0) {
        println(x)
        x--
    }

    var y = 10
    do {
        y++
        println(y)
    } while (y < 20)

}