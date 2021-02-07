package execises

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class SameFrequencyTest {

    @Test
    fun sameFrequencyTest() {
        assertTrue { sameFrequency(182,281) }
        assertFalse { sameFrequency(34,14) }
        assertTrue { sameFrequency(3589578,5879385) }
        assertFalse { sameFrequency(22,222) }
    }
}