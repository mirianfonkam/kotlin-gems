
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import text.count
import text.get
import text.times

class StringExtTest : DescribeSpec({

    describe("count") {
        it("should return the frequency of a substring in a text") {
            forAll(
                row("foo", "o", 2),
                row("oioioi oioioi", "oi", 6),
                row("""First line
                               Second line
                               Third line
                               Fourth line""", "line", 4),
                row("Kotlin", "j", 0),
            ) {text: String, substring: String, countResult: Int ->
                text.count(substring) shouldBe countResult
            }
        }
    }

    describe("getOperator") {
        it("slices the string with the specified range of indices.") {
            val stringTest1 = "Hello World"
            val stringTest2 = "United States of America"

            stringTest1[6..(stringTest1.length - 1)] shouldBe "World"
            stringTest1[4 downTo 0] shouldBe "olleH"
            stringTest2[0 until 6] shouldBe "United"
            stringTest2[7.rangeTo(12)] shouldBe "States"
        }
    }

    describe("timesOperator") {
        it("repeats the string the specified number of times.") {
            forAll(
                row("Hi!", 3, "Hi!Hi!Hi!"),
                row("Kotlin", 1, "Kotlin"),
                row("_ ", 5, "_ _ _ _ _ "),
                row("Java", 0, ""),
            ) {text: String, multiplier: Int, textResult: String ->
                text * multiplier shouldBe textResult
            }
        }
    }
})
