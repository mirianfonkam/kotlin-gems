package text

/**
 * It counts the occurrences of a given substring in a text.
 *
 * @param [substring] the substring to count.
 * @return the number of occurrences of the substring.
 */
fun String.count(substring: String): Int {
    return this.split(substring).size - 1
}


/**
 * It simplifies the slicing of a string using the bracket notation.
 *
 * @param [indices] the range of indices to be used for slicing.
 * @return char sequence containing characters of the original char sequence at the specified range of indices.
 */
operator fun String.get(indices: Iterable<Int>): String {
    return this.slice(indices)
}

operator fun String.get(indices: IntRange): String {
    return this.slice(indices)
}