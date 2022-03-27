package number

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class IntExtTest : DescribeSpec({

    describe("isEven") {
        val evenList = listOf(40004, -10, 0)
        val oddList = listOf(1, -1, 111, 45)

        it("returns true for even integers") {
            evenList.forAll { it.isEven().shouldBeTrue() }
        }
        it("returns false for non-even/odd integers") {
            oddList.forAll { it.isEven().shouldBeFalse() }
        }
    }

    describe("isOdd") {
        val oddList = listOf(-1, 35, 111)
        val evenList = listOf(40004, 2,  -10, 0)

        it("returns true for odd integers") {
            oddList.forAll { it.isOdd().shouldBeTrue() }
        }
        it("returns false for non-odd/even integers") {
            evenList.forAll { it.isOdd().shouldBeFalse() }
        }
    }

    describe("toDigits") {
        it("converts an integer into a list of digits") {
            listOf(
                123 to listOf(1, 2, 3),
                -123 to listOf(1, 2, 3),
                0 to listOf(0),
                78768 to listOf(7, 8, 7, 6, 8)
            ).forEach { (integer: Int, listOfDigits: List<Int>) ->
                integer.toDigits() shouldBe listOfDigits
            }
        }
    }

    describe("isPrime") {
        val primeList = listOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47)
        val nonPrimeList = (0..50).filterNot { it in primeList }

        it("returns true for prime integers") {
            primeList.forAll { it.isPrime().shouldBeTrue() }
        }
        it("returns false for non prime integers") {
            nonPrimeList.forAll { it.isPrime().shouldBeFalse() }
        }
    }
})