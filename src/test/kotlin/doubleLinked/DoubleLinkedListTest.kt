package doubleLinked

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class DoubleLinkedListTest {

    @Test
    fun pushAndPop() {
        with(DoubleLinkedList()) {
            push(5)
            assertTrue { length == 1 }
            assertTrue { head?.value == 5 }
            assertTrue { tail?.value == 5 }
            assertTrue { head?.previous == null }

            push(10)
            assertTrue { length == 2 }
            assertTrue { head?.value == 5 }
            assertTrue { head?.next?.value == 10 }
            assertTrue { tail?.value == 10 }
            assertTrue { head?.next?.previous?.value == 5 }

            push(15)
            assertTrue { length == 3 }
            assertTrue { head?.value == 5 }
            assertTrue { tail?.value == 15 }
            assertTrue { tail?.previous?.value == 10 }
            assertTrue { head?.next?.next?.value == 15 }

            assertTrue { pop()?.value == 15 }
            assertTrue { length == 2 }
            assertTrue { pop()?.value == 10 }
            assertTrue { length == 1 }
            assertTrue { pop()?.value == 5 }
            assertTrue { length == 0 }
            assertTrue { pop()?.value == null }
            assertTrue { length == 0 }
        }
    }

    @Test
    fun unShiftAndShift() {
        with(DoubleLinkedList()) {
            unShift(5)
            assertTrue { length == 1 }
            assertTrue { head?.value == 5 }
            assertTrue { tail?.value == 5 }

            unShift(10)
            assertTrue { length == 2 }
            assertTrue { head?.value == 10 }
            assertTrue { head?.next?.value == 5 }
            assertTrue { tail?.value == 5 }

            unShift(15)
            assertTrue { length == 3 }
            assertTrue { head?.value == 15 }
            assertTrue { tail?.value == 5 }
            assertTrue { head?.next?.next?.value == 5 }

            assertTrue { shift()?.value == 15 }
            assertTrue { length == 2 }
            assertTrue { shift()?.value == 10 }
            assertTrue { length == 1 }
            assertTrue { shift()?.value == 5 }
            assertTrue { length == 0 }
            assertTrue { shift()?.value == null }
            assertTrue { length == 0 }
        }
    }

    @Test
    fun get() {
        with(DoubleLinkedList()) {
            push(5).push(10).push(15).push(20)

            assertTrue { get(0)?.value == 5 }
            assertTrue { get(1)?.value == 10 }
            assertTrue { get(2)?.value == 15 }
            assertTrue { get(3)?.value == 20 }
            assertTrue { get(4)?.value == null }

        }
    }

    @Test
    fun set() {
        with(DoubleLinkedList()) {
            push(5).push(10).push(15).push(20)

            assertTrue { set(0, 10) }
            assertTrue { length == 4 }
            assertTrue { head?.value == 10 }

            assertFalse { set(10, 10) }

            assertTrue { set(2, 100) }
            assertTrue { head?.next?.next?.value == 100 }
        }
    }

    @Test
    fun insert() {
        with(DoubleLinkedList()) {
            push(5).push(10).push(15).push(20)
            assertTrue { insert(2, 12) }
            assertFalse { insert(100, 12) }

            assertTrue { length == 5 }
            assertTrue { head?.value == 5 }
            assertTrue { head?.next?.value == 10 }
            assertTrue { head?.next?.next?.value == 12 }
            assertTrue { head?.next?.next?.next?.value == 15 }
            assertTrue { head?.next?.next?.next?.next?.value == 20 }
        }
    }

    @Test
    fun remove() {
        with(DoubleLinkedList()) {
            push(5).push(10).push(15).push(20)

            assertTrue { remove(2)?.value == 15 }
            assertTrue { remove(100)?.value == null }

            assertTrue { length == 3 }
            assertTrue { head?.value == 5 }
            assertTrue { head?.next?.value == 10 }
            assertTrue { head?.next?.next?.value == 20 }

        }
    }
}