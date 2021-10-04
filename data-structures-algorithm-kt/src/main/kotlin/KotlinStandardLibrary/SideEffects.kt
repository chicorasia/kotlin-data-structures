package KotlinStandardLibrary

/**
 * Exploring the side effects of using MutableLists
 */
fun main() {

    val people = mutableListOf("Ringo", "Paul", "John", "George")

    noSideEffectsList(people)
    sideEffectsList(people)
    noSideEffectsList(people)

}

fun noSideEffectsList(names: List<String>) {
    println(names)
}

fun sideEffectsList(names: MutableList<String>) {
    names.add("Joker")
}

