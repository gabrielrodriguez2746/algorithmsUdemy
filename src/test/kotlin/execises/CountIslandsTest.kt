package execises

import org.junit.Test
import kotlin.test.assertTrue

class CountIslandsTest {

    @Test
    fun numIslandsTest() {
        assertTrue { numIslands(arrayOf(
            charArrayOf('1','1','1','1','0'),
            charArrayOf('1','1','0','1','0'),
            charArrayOf('1','1','0','0','0'),
            charArrayOf('0','0','0','0','0'))) == 1 }

        assertTrue { numIslands(
            arrayOf(
                charArrayOf('1','1','0','0','0'),
                charArrayOf('1','1','0','0','0'),
                charArrayOf('0','0','1','0','0'),
                charArrayOf('0','0','0','1','1'))) == 3 }
    }
}