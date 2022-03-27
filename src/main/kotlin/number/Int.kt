package number

import kotlin.math.abs

/**
 * It determines whether the specified integer is even.
 *
 * @return true if the specified integer is even.
 */
fun Int.isEven(): Boolean = this % 2 == 0


/**
 * It determines whether the specified integer is odd.
 *
 * @return true if the specified integer is odd.
 */
fun Int.isOdd(): Boolean = this % 2 != 0

/**
 * It returns the list of digits of the specified integer in the same order
 * as their value place representation.
 *
 * @return the list of integer digits of the specified integer.
 */
fun Int.toDigits(): List<Int> {
    return abs(this).toString().map { it.digitToInt() }
}

/**
 * It determines whether the specified integer is a [prime number](https://en.wikipedia.org/wiki/Prime_number).
 *
 * @return true if the specified integer is a prime number.
 */
fun Int.isPrime() : Boolean {
   return this > 1 && (2..(this / 2)).none { this % it == 0 }
}
