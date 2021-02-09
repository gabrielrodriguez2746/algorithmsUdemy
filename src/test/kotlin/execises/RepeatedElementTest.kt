package execises

import org.junit.Test
import kotlin.test.assertTrue

class RepeatedElementTest {

    @Test
    fun firstRepeatedTest() {
        assertTrue { firstRepeated(intArrayOf(10, 5, 3, 4, 3, 5, 6)) == 5 }
        assertTrue { firstRepeated(intArrayOf(6, 10, 5, 4, 9, 120, 4, 6, 10)) == 6 }
    }
}