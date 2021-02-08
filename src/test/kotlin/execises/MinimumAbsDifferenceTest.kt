package execises

import org.junit.Test

class MinimumAbsDifferenceTest {

    @Test
    fun minimumAbsDifferenceTest() {
        val expected = arrayOf(listOf(-14, -10), listOf(19, 23), listOf(23, 27))
        val input = intArrayOf(3, 8, -10, 23, 19, -4, -14, 27)
        kotlin.test.assertTrue {
            minimumAbsDifference(input).toTypedArray() contentEquals expected
        }
    }
}