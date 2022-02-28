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

    @Test
    fun timesOperator(){
        // Given
        val testCase1 = "Hi!"
        val testCase2 = "_ "

        // Then
        assertEquals("Hi!Hi!Hi!", testCase1 * 3)
        assertEquals("Hi!", testCase1 * 1)
        assertEquals("", testCase1 * 0)
        assertEquals("_ _ _ _ _ ", testCase2 * 5)
    }
}