package kotlinStandardLibrary

fun main() {

    /**
     * Overriding the standard implementation to use HashMap instead of LinkedHashMap.
     * This will not retain the order of insertion. Retrieving from a Map
     * runs in O(1).
     */
    val scores: HashMap<String, Int> = hashMapOf("Eric" to 10, "Mark" to 12, "Wayne" to 1)
    scores["Andrew"] = 6

    println(scores)

    /**
     * Inserting into a Map runs in O(1).
     */
    scores["Jack"] = 11
    println(scores)

    scores["Erin"] = 12
    println(scores)

}