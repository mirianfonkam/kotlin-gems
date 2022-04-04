package io

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.extensions.system.captureStandardOut
import io.kotest.matchers.shouldBe
import java.io.ByteArrayInputStream

class ConsoleExtTest : DescribeSpec({
    describe("puts") {
        it("should print line to stdout with newline") {
            forAll(
                row("", "\n"),
                row("kotest", "kotest\n"),
            ) {text: String, result: String ->
                captureStandardOut {
                    puts(text)
                } shouldBe result
            }
        }
    }

    describe("gets") {
        it("should read line from stdin") {
            listOf("kotest", "junit", "mockk").forEach { text ->
                val inputStream = ByteArrayInputStream(text.toByteArray())
                System.setIn(inputStream)
                val result = gets()
                text shouldBe result
            }
        }
    }
})
