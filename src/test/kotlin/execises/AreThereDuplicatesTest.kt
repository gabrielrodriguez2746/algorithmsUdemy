package execises

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class AreThereDuplicatesTest {

    @Test
    fun areThereDuplicatesTest() {
        assertFalse { areThereDuplicates(1, 2, 3) }
        assertTrue { areThereDuplicates(1, 2, 2) }
        assertTrue { areThereDuplicates('a', 'b', 'c', 'a') }
    }
}