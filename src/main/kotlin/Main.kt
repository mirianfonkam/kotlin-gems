import text.get

fun main() {
    val string = "Hello, World!"
    println(string[0..2])
    println(string.get(string.indices))
}