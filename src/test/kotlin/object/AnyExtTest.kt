package `object`

import io.kotest.core.spec.style.DescribeSpec
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue

class AnyExtTest : DescribeSpec({

    context("isNull/isNotNull check") {
        val nullableStr: String? = null
        val nullableObj: Any? = null
        val listOfNulls = listOf(nullableStr, nullableObj, null)
        val listOfNonNulls = listOf("test", 11, 0.00, null.toString())

        describe("isNull") {
            it("should be able to check if an object is null") {
                listOfNulls.forEach {
                    assertTrue(it.isNull())
                }
                listOfNonNulls.forEach {
                    assertFalse(it.isNull())
                }
            }
        }

        describe("isNotNull()") {
            it("should be able to check if an object is not null") {
                listOfNulls.forEach {
                    assertFalse(it.isNotNull())
                }
                listOfNonNulls.forEach {
                    assertTrue(it.isNotNull())
                }
            }
        }
    }
})