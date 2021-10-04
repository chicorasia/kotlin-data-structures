package leetCodeArray

fun main() {

    /**
     * Initialize an empty array with 15 places. All places hold null until overwritten.
     * An IntArray is an array of primitives, so every place holds a default value of 0.
     */
    val dvdCollection = arrayOfNulls<DVD>(15)
    val arrayOfZeroes = IntArray(15)

    /**
     * Create a few DVDs to add into the array
     */
    val avengersDvd = DVD("Avengers", 2012, "Joss Whedon")
    val incrediblesDvd = DVD("The Incredibles", 2004, "Brad Bird")
    val findingDoryDvd = DVD("Finding Dory", 2016, "Andrew Stanton")
    val lionKingDvd = DVD("The Lion King", 2019, "John Favreau")

    //put Avengers in the 8th place, index 7
    dvdCollection[7] = avengersDvd

    //put Incredibles in the 4th place, index 3 and so on...
    dvdCollection[3] = incrediblesDvd
    dvdCollection[9] = findingDoryDvd
    dvdCollection[2] = lionKingDvd

    //replace the item in index 2
    dvdCollection[2] = DVD("Star Wars", 1977, "George Lucas")

    /**
     * Traverse the array printing its contents
     */
    dvdCollection.forEach{
        println(it)
    }

    arrayOfZeroes.forEach {
        println(it)
    }

}

