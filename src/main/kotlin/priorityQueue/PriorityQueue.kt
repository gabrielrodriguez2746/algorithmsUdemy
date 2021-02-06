package priorityQueue

import kotlin.math.floor

class PriorityQueue {

    internal val items: MutableList<Node> = mutableListOf()

    /**
     * Accept a @param value
     * Accept a @param priority
     * Add the value to list
     * locate in the right position base on priority. Lower number more priority
     */
    fun enqueue(value: Any, priority: Int): PriorityQueue {
        items.add(Node(value, priority))
        bubbleUp(items.lastIndex)
        return this
    }

    private fun bubbleUp(index: Int) {
        if (index == 0) return
        val rootIndex = floor((index - 1) / 2.0).toInt()
        val leaf = items[index]
        val root = items[rootIndex]
        if (leaf.priority < root.priority) {
            items[index] = root
            items[rootIndex] = leaf
            bubbleUp(rootIndex)
        }
    }

    /**
     * Remove from the root (first element)
     * Rearrange using priorities
     */
    fun dequeue(): Node? {
        if (items.isEmpty()) return null
        if (items.size == 1) return items.removeAt(0)
        val root = items.first()
        val lastElement = items.last()
        items[0] = lastElement
        items.removeLast()
        bubbleDown(0)
        return root
    }

    private fun bubbleDown(index: Int) {
        val leftChildIndex = 2 * index + 1
        if (leftChildIndex > items.lastIndex) return
        val rightChildIndex = leftChildIndex + 1
        val root = items[index]
        val leftChild = items[leftChildIndex]
        when {
            // only compare left
            rightChildIndex > items.lastIndex -> {
                if (root.priority > leftChild.priority) {
                    items[leftChildIndex] = root
                    items[index] = leftChild
                    bubbleDown(leftChildIndex)
                }
            }
            // compare both
            else -> {
                val rightChild = items[rightChildIndex]
                if (rightChild.priority < leftChild.priority) {
                    if (root.priority > rightChild.priority) {
                        items[rightChildIndex] = root
                        items[index] = rightChild
                        bubbleDown(rightChildIndex)
                    }
                } else {
                    if (root.priority > leftChild.priority) {
                        items[leftChildIndex] = root
                        items[index] = leftChild
                        bubbleDown(leftChildIndex)
                    }
                }
            }
        }
    }

}