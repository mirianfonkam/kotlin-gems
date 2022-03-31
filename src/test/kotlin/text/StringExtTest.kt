
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import text.capitalized
import text.count
import text.delete
import text.get
import text.insert
import text.swapcase
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

    describe("delete") {
        it("should delete all the occurrences of the matching substrings in a text") {
            forAll(
                row("I am, Sara", ",", "I am Sara"),
                row("Lorem ipsum dolor", " ", "Loremipsumdolor"),
                row("Java", "kt", "Java"),
                row("hello", "lo", "hel"),
            ) {text: String, substring: String, result: String ->
                text.delete(substring) shouldBe result
            }
            "hello".delete("l","lo") shouldBe "heo"
            "abcdefghijklmnopqrstuvwxyz".delete("a", "e", "i", "o", "u") shouldBe "bcdfghjklmnpqrstvwxyz"
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

    describe("swapcase") {
        it("should letter swap the case of the characters in the string") {
            forAll(
                row("Hello World", "hELLO wORLD"),
                row("cYbEr_PuNk11", "CyBeR_pUnK11")
            ) {text: String, result: String ->
                text.swapcase() shouldBe result
            }
        }
    }

    describe("capitalized") {
        it("should make the first char of a string uppercase") {
            forAll(
                row("money", "Money"),
                row("ruby is also great", "Ruby is also great"),
                row("","")
            ) {text: String, result: String ->
                text.capitalized() shouldBe result
            }
        }
    }

    describe("insert") {
        it("should insert the given otherString into this string"){
            forAll(
                row("Messi and Neymar scored", 5, ", Mbappe", "Messi, Mbappe and Neymar scored"),
                row("foo", 1, "bar", "fbaroo"),
                row("GitHub", 6, " Actions", "GitHub Actions"),
            ) {text: String, index: Int, otherString: String, result: String ->
                text.insert(index, otherString) shouldBe result
            }
        }
    }
})
