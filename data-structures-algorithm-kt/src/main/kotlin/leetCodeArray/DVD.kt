package leetCodeArray

/**
 * A simple DVD class to populate the array
 */
class DVD(
    val name: String,
    val releaseYear: Int,
    val director: String
) {

    override fun toString(): String {
        return "$name, directed by $director, released in $releaseYear."
    }
}