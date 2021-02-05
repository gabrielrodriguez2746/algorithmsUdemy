package linked

import org.junit.Test
import kotlin.test.assertTrue

class LinkedListTest {

    @Test
    fun reverse() {
        with(LinkedList()) {
            push(5).push(10).push(15).push(20)
            reverse()
            assertTrue { length == 4 }
            assertTrue { head?.value == 20 }
            assertTrue { head?.next?.value == 15 }
            assertTrue { head?.next?.next?.value == 10 }
            assertTrue { head?.next?.next?.next?.value == 5 }
        }
    }
}