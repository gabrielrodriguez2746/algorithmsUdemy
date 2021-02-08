package execises

import org.junit.Test
import kotlin.test.assertTrue

class FindAnagramsTest {

    @Test
    fun findAnagramTest() {
        val expected = arrayOf(listOf("eat", "tea", "ate"), listOf("tan", "nat"), listOf("bat"))
        val input = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
        assertTrue {
            findAnagram(input).toTypedArray() contentEquals expected
        }
    }
}