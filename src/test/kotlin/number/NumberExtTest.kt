package number

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class NumberExtTest : DescribeSpec({

    describe("compareTo") {
        it("returns 1 when the left hand side number is greater than the right hand side integer") {
            val numberTestCase1: Number = 2
            numberTestCase1.compareTo(0) shouldBe 1
        }
        it("returns -1 when the left hand side number is less than the right hand side integer") {
            val numberTestCase2: Number = 1948L
            numberTestCase2.compareTo(999999999) shouldBe -1
        }
        it("returns 0 when the left hand side number is equal to the right hand side integer") {
            val numberTestCase1: Number = 1948L
            val numberTestCase2: Number = -30.0f
            numberTestCase1.compareTo(1948) shouldBe 0
            numberTestCase2.compareTo(-30) shouldBe 0
        }
    }

    describe("compareToOperator") {
        describe("<") {
            it("returns true when the left hand side number is less than the right hand side integer") {
                val numberTestCase1: Number = 2
                (numberTestCase1 < 6).shouldBeTrue()
            }
            it("returns false when the left hand side number is not less than the right hand side integer") {
                val numberTestCase1: Number = 2L
                (numberTestCase1 < -1).shouldBeFalse()
            }
        }
        describe(">") {
            it("returns true when the left hand side number is greater than the right hand side integer") {
                val numberTestCase1: Number = 66.9
                (numberTestCase1 > 6).shouldBeTrue()
            }
            it("returns false when the left hand side number is not greater than the right hand side integer") {
                val numberTestCase1: Number = -2L
                (numberTestCase1 > -1).shouldBeFalse()
            }
        }
    }

    // Begin test cases
    val negativeTestCase1: Int = -11
    val negativeTestCase2: Long = -80L
    val negativeTestCase3: Float = -1.55F
    val negativeTestCase4: Double = -1.2
    val negativeTestCase5: Short = -8
    val positiveTestCase1: Int = 1
    val positiveTestCase2: Long = 74L
    val positiveTestCase3: Float = 3.25F
    val positiveTestCase4: Double = 7.5
    val positiveTestCase5: Short = 9
    val zeroTestCase1: Int = 0
    val zeroTestCase2: Long = 0
    val zeroTestCase3: Float = 0.0F
    val zeroTestCase4: Double = 0.0
    val zeroTestCase5: Short = 0
    val zeroTestCase6: Byte = 0

    val negativeNumberList =
        listOf(
            negativeTestCase1, negativeTestCase2, negativeTestCase3, negativeTestCase4, negativeTestCase5
        )
    val positiveNumberList =
        listOf(
            positiveTestCase1, positiveTestCase2, positiveTestCase3, positiveTestCase4, positiveTestCase5
        )
    val zeroNumberList =
        listOf(
            zeroTestCase1, zeroTestCase2, zeroTestCase3, zeroTestCase4, zeroTestCase5, zeroTestCase6
        )

    // End testCase

    describe("isPositive") {
        it("returns true if number is positive") {
            positiveNumberList.forAll { it.isPositive().shouldBeTrue() }
        }
        it("returns false for non-positive/negative numbers") {
            negativeNumberList.forAll { it.isPositive().shouldBeFalse() }
        }
    }

    describe("isNegative") {
        it("returns true if number is negative") {
            negativeNumberList.forAll { it.isNegative().shouldBeTrue() }
        }
        it("returns false for non-negative/positive numbers") {
            positiveNumberList.forAll { it.isNegative().shouldBeFalse() }
        }
    }

    describe("isZero") {
        it("returns true if number is zero") {
            zeroNumberList.forAll { it.isZero().shouldBeTrue() }
        }
        it("returns false for non-zero numbers") {
            negativeNumberList.forAll { it.isZero().shouldBeFalse() }
            listOf(99999999, -1, 0.00001).forAll { it.isZero().shouldBeFalse() }
        }
    }
})