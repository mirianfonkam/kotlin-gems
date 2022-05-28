package collection

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class CollectionExtTest : DescribeSpec({
    describe("combination"){
        it("generates all combinations of size n") {
            forAll(
                row(listOf(0,1,2), 2, listOf(listOf(0,1), listOf(0,2), listOf(1,2))),
                row(listOf(0,1,2), 3, listOf(listOf(0,1,2))),
                row(listOf(0,1,2), 1, listOf(listOf(0), listOf(1), listOf(2))),
                row(listOf(0,1,2), 0, listOf()),
                row(listOf(0,1,2,3,4), 3, listOf(listOf(0, 1, 2), listOf(0, 1, 3), listOf(0, 1, 4),
                                             listOf(0, 2, 3), listOf(0, 2, 4), listOf(0, 3, 4),
                                             listOf(1, 2, 3), listOf(1, 2, 4), listOf(1, 3, 4), listOf(2, 3, 4))
                ),
                row(listOf("BRA","USA","NGA", "ENG"), 2, listOf(listOf("BRA","USA"), listOf("BRA","NGA"),
                                                            listOf("BRA", "ENG"), listOf("USA", "NGA"),
                                                            listOf("USA", "ENG"), listOf("NGA", "ENG"))
                ),
            ) { listReceiver: List<Any>, n: Int, result: List<List<Any>> ->
                listReceiver.combination(n) shouldBe result
            }
        }
        it("should throw an exception if n is negative or greater than the size of the list") {
            forAll(
                row(listOf("a","b","c"), -1),
                row(listOf("br", "en"), 3),
            ) { listReceiver: List<String>, n: Int ->
                shouldThrow<IllegalArgumentException> {
                    listReceiver.combination(n)
                }
            }
        }
    }
})