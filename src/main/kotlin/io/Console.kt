package io

/**
 * It prints the given [message] appended with a new line to the standard output stream.
 * @param message the message to print to stdout.
 * @return Unit
 */
fun puts(message: Any?) {
    println(message)
}

/**
 * It gets a line of input text from the standard input stream.
 * @return the string read from the stdin
 */
fun gets() : String {
    return readLine().orEmpty()
}