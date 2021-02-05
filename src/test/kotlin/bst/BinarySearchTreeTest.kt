package bst

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BinarySearchTreeTest {

    @Test
    fun insertAndFind() {
        with(BinarySearchTree()) {
            assertFalse { find(100) }
            insert(100)
            insert(50)
            insert(150)
            insert(200)
            insert(120)
            insert(20)
            insert(30)
            insert(70)
            assertTrue { find(20) }
            assertTrue { find(100) }
            assertFalse { find(10) }
        }
    }

}