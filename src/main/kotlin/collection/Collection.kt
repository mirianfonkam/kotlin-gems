package collection

import java.util.LinkedList

/**
 * It generates the [n]-tuple combination of this collection of elements.
 * [Rosetta Code: Kotlin Combination](https://rosettacode.org/wiki/Combinations#Lazy)
 * @param [n] the number of elements in each combination
 * @return a list of the [n] list of combinations of this collection
 * @throws IllegalArgumentException if 0 > [n] > the size of the list
 */
inline fun <reified T> List<T>.combination(n: Int): List<List<T>> {
    if (n < 0 || size < n) {
        throw IllegalArgumentException(
            "Combination cannot happen. Integer argument must satisfy the constraints 0 <= n <= size of the collection."
                    + " Argument received n: $n"
        )
    } else if (n == 0) { return listOf() }
    return sequence {
        val result = Array(n) { get(0) }
        val stack = LinkedList<Int>()
        stack.push(0)
        while (stack.isNotEmpty()) {
            var resIndex = stack.size - 1
            var arrIndex = stack.pop()
            while (arrIndex < size) {
                result[resIndex++] = get(arrIndex++)
                stack.push(arrIndex)
                if (resIndex == n) {
                    yield(result.toList())
                    break
                }
            }
        }
    }.toList()
}