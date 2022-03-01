package number

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class IntExtTest {

    @Test
    fun isEven() {
        // Given
        val evenTestCase1 = 40004
        val evenTestCase2 = -10
        val evenTestCase3 = 0
        val oddTestCase = 111

        // When
        assertTrue(evenTestCase1.isEven())
        assertTrue(evenTestCase2.isEven())
        assertTrue(evenTestCase3.isEven())
        assertFalse(oddTestCase.isEven())
    }

    @Test
    fun isOdd() {
        // Given
        val oddTestCase1 = 111
        val oddTestCase2 = 35
        val oddTestCase3 = -1
        val evenTestCase = 40004

        // When
        assertTrue(oddTestCase1.isOdd())
        assertTrue(oddTestCase2.isOdd())
        assertTrue(oddTestCase3.isOdd())
        assertFalse(evenTestCase.isOdd())
    }

    @Test
    fun toDigits(){
        // Given
        val testCase1 = 78768
        val testCase2 = -10
        val testCase3 = 0

        // When
        assertEquals(listOf(7,8,7,6,8),testCase1.toDigits())
        assertEquals(listOf(1,0),testCase2.toDigits())
        assertEquals(listOf(0),testCase3.toDigits())
    }
}