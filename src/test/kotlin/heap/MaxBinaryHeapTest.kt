package heap

import org.junit.Test
import kotlin.test.assertTrue

class MaxBinaryHeapTest {

    @Test
    fun insert() {
        val expected = listOf(55, 39, 41, 18, 27, 12, 33).toTypedArray()
        val expectedAfterRemove = listOf(41, 39, 33, 18, 27, 12).toTypedArray()
        with(MaxBinaryHeap()) {
            insert(41)
            insert(39)
            insert(33)
            insert(18)
            insert(27)
            insert(12)
            assertTrue {
                expected contentEquals insert(55).items.toTypedArray()
            }
            assertTrue { remove() == 55 }
            assertTrue { expectedAfterRemove contentEquals items.toTypedArray() }
        }
    }
}