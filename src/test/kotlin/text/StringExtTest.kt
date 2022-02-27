package text

import org.junit.Assert.assertEquals
import org.junit.Test



class StringExtTest {

    @Test
    fun count() {
        // Given
        val sampleString1 = "foo"
        val sampleString2 = "oioioi oioioi vamos dancar"
        val sampleString3 = """First line
                               Second line
                               Third line
                               Fourth line"""

        // Then
        assertEquals(2, sampleString1.count("o"))
        assertEquals(0, sampleString1.count("z"))
        assertEquals(6, sampleString2.count("oi"))
        assertEquals( 4, sampleString3.count("line"))
    }
}