package number

/**
 * It compares this number with the specified integer.
 *
 * @return Returns zero if this number is equal to the [other] integer,
 * a negative integer if it's less than [other], or a positive integer
 * if it's greater than [other].
 * @throws IllegalArgumentException if the specified number is unsupported.
 */
operator fun Number.compareTo(other: Int): Int {
    return when (this) {
        is Int -> this.compareTo(other)
        is Double -> this.compareTo(other)
        is Float -> this.compareTo(other)
        is Long -> this.compareTo(other)
        is Short -> this.compareTo(other)
        is Byte -> this.compareTo(other)
        else -> throw IllegalArgumentException("Unsupported number type: $this")
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
