package text

/**
 * Count occurrences of a given substring in a text.
 *
 * @param [substring] the substring to count.
 * @return the number of occurrences of the substring.
 */
fun CharSequence.count(substring: String): Int {
    return this.split(substring).size - 1
}