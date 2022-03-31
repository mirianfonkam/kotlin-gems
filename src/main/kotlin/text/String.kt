package text

import java.util.*

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
 * It makes a copy of the string with all occurrences the matching [substrings] arguments deleted.
 *
 * @param [substrings] the substrings to be deleted.
 * @return a copy of the string with all occurrences of the specified substrings deleted.
 */
fun String.delete(vararg substrings: String): String {
    var copy = this
    substrings.forEach {
        copy = copy.replace(it, "")
    }
    return copy
}

/**
 * It simplifies the slicing of a string using the bracket notation.
 *
 * @param [indices] the range of indices to be used for slicing.
 * @return a string containing characters of the original string with the specified range of indices.
 */
operator fun String.get(indices: Iterable<Int>): String {
    return this.slice(indices)
}

operator fun String.get(indices: IntRange): String {
    return this.slice(indices)
}

/**
 * It simplifies the repetition of a string using the times(*) operator.
 *
 * @param [n] the number of times the string should be repeated.
 * @return a string containing the original string repeated the specified number of times.
 */
operator fun String.times(n: Int): String {
    return this.repeat(n)
}

/**
 * It makes a copy of a string with uppercase alphabetic characters converted to lowercase and lowercase characters converted to uppercase.
 * The case of non-alphabetic characters is not changed.
 * @return a copy of the string with the characters converted to the opposite case.
 */
fun String.swapcase(): String {
    return this.map {
        if (it.isUpperCase()) it.lowercase() else it.uppercase()
    }.joinToString("")
}

/**
 * It makes a copy of a string with the first character converted to uppercase.
 * @return a copy of the string capitalized
 */
fun String.capitalized(): String {
    return replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}

/**
 * It inserts the given [otherString] into this string at the specified index.
 * @return a new string with the [otherString] inserted into this.
 * @throws StringIndexOutOfBoundsException if index < 0
 */
fun String.insert(index: Int, otherString: String): String {
    return this.substring(0, index) + otherString + this.substring(index)
}
