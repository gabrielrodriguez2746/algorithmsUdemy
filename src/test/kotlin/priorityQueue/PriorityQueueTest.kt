package priorityQueue

import org.junit.Test
import kotlin.test.assertTrue

class PriorityQueueTest {

    @Test
    fun enqueueAndDequeue() {
        with(PriorityQueue()) {
            enqueue("common cold", 5)
            enqueue("gunshot wound", 1)
            enqueue("high fever", 4)
            enqueue("broken arm", 2)
            enqueue("glass in food", 3)
            assertTrue { dequeue() == Node("gunshot wound", 1) }
            assertTrue { dequeue() == Node("broken arm", 2) }
            assertTrue { dequeue() == Node("glass in food", 3) }
            assertTrue { dequeue() == Node("high fever", 4) }
            assertTrue { dequeue() == Node("common cold", 5) }
        }
    }
}