package execises

import countUniqueValues
import org.junit.Test
import kotlin.test.assertTrue

class CountUniquesTest {

    @Test
    fun countUniqueValuesTest() {
        val input1 = intArrayOf(1, 1, 1, 1, 1, 2)
        val input2 = intArrayOf(1, 2, 3, 4, 4, 4, 7, 7, 12, 12, 13)
        val input3 = intArrayOf()
        val input4 = intArrayOf(-2, -1, -1, 0, 1)
        assertTrue { countUniqueValues(input1) == 2 }
        assertTrue { countUniqueValues(input2) == 7 }
        assertTrue { countUniqueValues(input3) == 0 }
        assertTrue { countUniqueValues(input4) == 4 }
    }
}