package collection

/**
 * It generates the [n]-tuple combination of this collection of elements.
 * [Rosetta Code: Kotlin Combination](https://rosettacode.org/wiki/Combinations#Lazy)
 * @param [n] the number of elements in each combination
 * @return a list of the [n] list of combinations of this collection
 * @throws IllegalArgumentException if 0 > [n] > the size of the list
 */
fun <T> List<T>.combination(n: Int): List<List<T>> {
    if (n < 0 || size < n) {
        throw IllegalArgumentException(
            "Combination cannot happen. Integer argument must satisfy the constraints 0 <= n <= size of the collection."
                    + " Argument received n: $n"
        )
    } else if (n == 0) { return listOf() }
    fun <T> List<T>.combine(i: Int) :  List<List<T>> {
        return when (i) {
            0 -> listOf()
            1 -> map { listOf(it) }
            else -> {
                val result = mutableListOf<List<T>>()
                forEachIndexed { index, element ->
                    subList(index + 1, size).combine(i - 1).forEach {
                        result.add(listOf(element) + it)
                    }
                }
                result
            }
        }
    }
    return this.combine(n)
}