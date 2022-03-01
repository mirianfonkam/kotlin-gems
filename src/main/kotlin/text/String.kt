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
 * @return a string containing characters of the original string at the specified range of indices.
 */
operator fun String.get(indices: Iterable<Int>): String {
    return this.slice(indices)
}

operator fun String.get(indices: IntRange): String {
    return this.slice(indices)
}

/**
 * It simplifies the repetition of a string using the times operator.
 *
 * @param [n] the number of times the string should be repeated.
 * @return a string containing the original string repeated the specified number of times.
 */
operator fun String.times(n: Int): String {
    return this.repeat(n)
}