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

    @Test
    fun bfs() {
        with(BinarySearchTree()) {
            insert(10)
            insert(6)
            insert(15)
            insert(3)
            insert(8)
            insert(20)
            assertTrue { bfs().toTypedArray() contentEquals listOf(10, 6, 15, 3, 8, 20).toTypedArray() }
        }
    }

}