package text

import org.junit.Assert.assertEquals
import org.junit.Test

class StringExtTest {

    @Test
    fun count() {
        // Given
        val testCase1 = "foo"
        val testCase2 = "oioioi oioioi vamos dancar"
        val testCase3 = """First line
                               Second line
                               Third line
                               Fourth line"""

        // Then
        assertEquals(2, testCase1.count("o"))
        assertEquals(0, testCase1.count("z"))
        assertEquals(6, testCase2.count("oi"))
        assertEquals( 4, testCase3.count("line"))
    }

    @Test
    fun getOperator(){
        // Given
        val testCase1 = "Hello World"
        val testCase2 = "United States of America"

        // Then
        assertEquals("World", testCase1[6..(testCase1.length - 1)])
        assertEquals("olleH", testCase1[4 downTo 0])
        assertEquals("United", testCase2[0 until 6])
        assertEquals("States", testCase2[7.rangeTo(12)])
    }
}