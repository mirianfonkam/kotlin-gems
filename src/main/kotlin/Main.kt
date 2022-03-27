import java.util.*

/**
 * @suppress
 */
fun main() {
    println("Hello, world!".replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() })
}