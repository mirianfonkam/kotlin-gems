package number

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class NumberExtTest {

    @Test
    fun isPositive(){
        // Given
        val intTestCase: Int = 11
        val longTestCase: Long = 80L
        val floatTestCase: Float = 1.55F
        val doubleTestCase: Double = 1.2
        val shortTestCase: Short = 8
        val zeroTestCase: Long = 0L
        val negativeTestCase1: Short = -1
        val negativeTestCase2: Long = -99999999999999

        // When
        assertTrue(intTestCase.isPositive())
        assertTrue(longTestCase.isPositive())
        assertTrue(floatTestCase.isPositive())
        assertTrue(doubleTestCase.isPositive())
        assertTrue(shortTestCase.isPositive())
        assertFalse(zeroTestCase.isPositive())
        assertFalse(negativeTestCase1.isPositive())
        assertFalse(negativeTestCase2.isPositive())
    }

    @Test
    fun isNegative(){
        // Given
        val intTestCase: Int = -11
        val longTestCase: Long = -80L
        val floatTestCase: Float = -1.55F
        val doubleTestCase: Double = -1.2
        val shortTestCase: Short = -8
        val zeroTestCase: Long = 0L
        val positiveTestCase1: Short = 1
        val positiveTestCase2: Double = 9999.0

        // When
        assertTrue(intTestCase.isNegative())
        assertTrue(longTestCase.isNegative())
        assertTrue(floatTestCase.isNegative())
        assertTrue(doubleTestCase.isNegative())
        assertTrue(shortTestCase.isNegative())
        assertFalse(zeroTestCase.isNegative())
        assertFalse(positiveTestCase1.isNegative())
        assertFalse(positiveTestCase2.isNegative())
    }

    @Test
    fun isZero(){
        // Given
        val zeroTestCase1: Int = 0
        val zeroTestCase2: Long = 0
        val zeroTestCase3: Float = 0.0F
        val zeroTestCase4: Double = 0.0
        val zeroTestCase5: Short = 0
        val zeroTestCase6: Byte = 0
        val nonZeroTestCase1: Long = 99999999
        val nonZeroTestCase2: Short = -1
        val nonZeroTestCase3: Double = 0.00001

        // When
        assertTrue(zeroTestCase1.isZero())
        assertTrue(zeroTestCase2.isZero())
        assertTrue(zeroTestCase3.isZero())
        assertTrue(zeroTestCase4.isZero())
        assertTrue(zeroTestCase5.isZero())
        assertTrue(zeroTestCase6.isZero())
        assertFalse(nonZeroTestCase1.isZero())
        assertFalse(nonZeroTestCase2.isZero())
        assertFalse(nonZeroTestCase3.isZero())
    }

    @Test
    fun compareToOperator() {
        // Given
        val numberTestCase1: Number = 2
        val numberTestCase2: Number = 1948L
        val numberTestCase3: Number = -30.0F

        // When
        assertTrue(numberTestCase1 > 0)
        assertFalse(numberTestCase1 < 0)
        assertEquals(1, numberTestCase1.compareTo(0))
        assertEquals(-1, numberTestCase2.compareTo(9999999))
        assertEquals(0, numberTestCase3.compareTo(-30))
    }
}