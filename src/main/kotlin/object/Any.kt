package `object`

/**
 * It determines whether the given object is null.
 * @return true if the object is null, false otherwise.
 */
fun Any?.isNull(): Boolean = this == null

/**
 * It determines whether the given object is not null.
 * @return true if the object is not null, false otherwise.
 */
fun Any?.isNotNull(): Boolean = this != null