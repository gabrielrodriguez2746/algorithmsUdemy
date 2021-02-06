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
    fun bfs_DfsPreOrder_DfsPostOrder() {
        with(BinarySearchTree()) {
            insert(10)
            insert(6)
            insert(15)
            insert(3)
            insert(8)
            insert(20)
            assertTrue { bfs().toTypedArray() contentEquals listOf(10, 6, 15, 3, 8, 20).toTypedArray() }
            assertTrue { dfsPreOrder().toTypedArray() contentEquals listOf(10, 6, 3, 8, 15, 20).toTypedArray() }
            assertTrue { dfsPostOrder().toTypedArray() contentEquals listOf(3, 8, 6, 20, 15, 10).toTypedArray() }
            assertTrue { dfsInOrder().toTypedArray() contentEquals listOf(3, 6, 8, 10, 15, 20).toTypedArray() }
        }
    }

}