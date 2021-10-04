package kotlinStandardLibrary

fun main() {

    val places = mutableListOf("Paris", "London", "Bucarest")

    /**
     * Appends an item at the end of the List. This
     * runs in constant time and has O(1).
     */
    places.add("Budapest")
    println(places)

    /**
     * Appends an item in the start of the list (position 0).
     * This causes all other elements to shuffle one position
     * over. Ultimately it runs in O(n).
     */
    places.add(0, "Dieppe")
    println(places)

//    places.forEach {
//        println(it)
//    }

}

