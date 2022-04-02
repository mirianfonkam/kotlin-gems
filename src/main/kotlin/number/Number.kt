package number
import kotlin.math.round

/**
 * It compares this number with the specified integer.
 *
 * @return Returns zero if this number is equal to the [other] integer,
 * a negative integer if it's less than [other], or a positive integer
 * if it's greater than [other].
 */
operator fun Number.compareTo(other: Int): Int {
    return when (this) {
        is Int -> this.compareTo(other)
        is Double -> this.compareTo(other)
        is Float -> this.compareTo(other)
        is Long -> this.compareTo(other)
        is Short -> this.compareTo(other)
        is Byte -> this.compareTo(other)
        else -> throw IllegalArgumentException("Unsupported number type: ${this.javaClass.name}")
    }
}

/**
 * It determines whether the specified number is positive.
 *
 * @return true if the specified number is greater than zero.
 */
fun Number.isPositive(): Boolean {
    return this > 0
}

/**
 * It determines whether the specified number is negative.
 *
 * @return true if the specified number is less than zero.
 */
fun Number.isNegative(): Boolean {
    return this < 0
}

/**
 * It determines whether the specified number has a zero value.
 *
 * @return true if the specified number is equal to zero.
 */
fun Number.isZero(): Boolean {
    return this.compareTo(0) == 0
}

/**
 * It determines if a number is equivalent to mathematical integer number, a number with no fractional part.
 * Please note that it may return false positives if the number is approximately equal to an integer.
 *
 * @return true if the double or float number is equivalent to an integer number, false otherwise. It returns true for
 * all Int, Long, Short, Byte numbers.
 */
fun <T: Number> T.isInteger(): Boolean {
    return when (this) {
        is Double -> this == round(this)
        is Float -> this == round(this)
        else -> true
    }
}