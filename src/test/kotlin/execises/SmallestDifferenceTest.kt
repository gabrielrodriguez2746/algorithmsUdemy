package execises

import org.junit.Test
import kotlin.test.assertTrue

class SmallestDifferenceTest {

    @Test
    fun smallestDifferenceTest() {
        assertTrue {
            smallestDifference(intArrayOf(1, 3, 15, 11, 2), intArrayOf(23, 127, 235, 19, 8)) ==
                    SmallestDifferenceResult(11 to 8, 3)
        }
        assertTrue {
            smallestDifference(intArrayOf(10, 5, 40), intArrayOf(50, 90, 80)) ==
                    SmallestDifferenceResult(40 to 50, 10)
        }
    }
}