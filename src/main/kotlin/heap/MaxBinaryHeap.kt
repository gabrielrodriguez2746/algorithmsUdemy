package heap

import kotlin.math.floor

class MaxBinaryHeap {

    internal val items: MutableList<Int> = mutableListOf()

    /**
     * Accept a @param value
     * Add the value to list
     * locate in the right position
     */
    fun insert(value: Int): MaxBinaryHeap {
        items.add(value)
        bubbleUp(items.lastIndex)
        return this
    }

    private fun bubbleUp(index: Int) {
        if (index == 0) return
        val rootIndex = floor((index - 1) / 2.0).toInt()
        val leaf = items[index]
        val root = items[rootIndex]
        if (leaf > root) {
            items[index] = root
            items[rootIndex] = leaf
            bubbleUp(rootIndex)
        }
    }

    /**
     * Remove from the root (first element)
     * Swap first with last
     * Put new first in the right position -> bubble down
     */
    fun remove(): Int? {
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
                if (root < leftChild) {
                    items[leftChildIndex] = root
                    items[index] = leftChild
                    bubbleDown(leftChildIndex)
                }
            }
            // compare both
            else -> {
                val rightChild = items[rightChildIndex]
                if (rightChild > leftChild) {
                    if (root < rightChild) {
                        items[rightChildIndex] = root
                        items[index] = rightChild
                        bubbleDown(rightChildIndex)
                    }
                } else {
                    if (root < leftChild) {
                        items[leftChildIndex] = root
                        items[index] = leftChild
                        bubbleDown(leftChildIndex)
                    }
                }
            }
        }
    }

}