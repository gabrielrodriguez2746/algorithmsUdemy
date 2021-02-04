package linked

data class LinkedList(private var head: Node? = null, private var tail: Node? = null, private var length: Int = 0) {

    /**
     * Should receive a @param value
     * Create a new node using the value
     * If there is not head set the head and the tail to be the created node
     * Otherwise set the next property on the tail to be the new node and set the tail property on the list to be the newly created node
     * Increment the length by one
     * @return  the list
     */
    fun push(value: Any): LinkedList {
        val node = Node(value)
        when (head) {
            null -> {
                head = node
                tail = node
            }
            else -> {
                tail?.next = node
                tail = node
            }
        }
        length++
        return this
    }

    /**
     * If there are no nodes in the list
     * @return null
     * Loop until reach the tail as next
     * Set the next to null and the tail to this found value
     * Decrement the length
     * Return the started tail
     */
    fun pop(): Node? {
        return when {
            length == 0 -> null //  I would throw exception
            head == tail -> {
                val popValue = tail
                head = null
                tail = null
                length--
                return popValue
            }
            else -> {
                val popValue = tail
                var newTale = head
                while (newTale?.next != tail) {
                    newTale = newTale?.next
                }
                newTale?.next = null
                tail = newTale
                length--
                return popValue
            }
        }
    }

    /**
     * If there are no nodes return undefined
     * Store the head in a variable
     * Set the head to the next current head
     * Decrement length
     * @return value
     */
    fun shift(): Node? {
        return when {
            length == 0 -> null //  I would throw exception
            head == tail -> {
                val shiftValue = head
                head = null
                tail = null
                length--
                return shiftValue
            }
            else -> {
                val shiftValue = head
                head = head?.next
                length--
                return shiftValue
            }
        }
    }

    /**
     * Accept a @param value
     * Create new node
     * No head -> set head and tail to be the new created node
     * Otherwise new node next = previous head
     * Increment the length
     * @return the list
     */
    fun unShift(value: Any): LinkedList {
        val node = Node(value)
        when (head) {
            null -> {
                head = node
                tail = node
            }
            else -> {
                node.next = head
                head = node
            }
        }
        length++
        return this
    }

    /**
     * This function should accept a @param index
     * If the index is less than 0 or greater than length then return null
     * Loop through the list until you reach the index and
     * @return the node at that index
     */
    fun get(index: Int): Node? {
        return when {
            index < 0 || index > length -> null
            else -> {
                var nodeIndex = 0
                var indexNode = head
                while (nodeIndex != index) {
                    indexNode = indexNode?.next
                    nodeIndex++
                }
                indexNode
            }

        }
    }

    /**
     * This function should accept a @param index
     * Use get to find the node
     * If no node
     * @return false
     * If it is found, set the @param value and
     * @return true
     */
    fun set(index: Int, value: Any): Boolean {
        return get(index)?.let {
            it.value = value
            true
        } ?: false
    }

    /**
     * Take the @param index and a @param value
     * Invalid index
     * @return false
     * Index equals to length use push
     * Index 0 use unShift
     * Otherwise access node at index -1
     * Set the next to be the new node
     * Set the next for the new to be the previous next
     * Increment the length
     * @return true
     */
    fun insert(index: Int, value: Any): Boolean {
        if (index < 0 || index > length) return false
        when (index) {
            length -> push(value)
            0 -> unShift(value)
            else -> {
                val previousNode = get(index - 1)
                val previousNext = previousNode?.next
                previousNode?.next = Node(value, previousNext)
                length++
            }
        }

        return true
    }

    /**
     * Take the @param index
     * Invalid index
     * @return null
     * Index equals to length -1 use pop
     * Index 0 use shift
     * Otherwise access node at index -1
     * Set the next to be the next of removed node
     * Decrement the length
     * @return value removed
     */
    fun remove(index: Int): Node? {
        if (index < 0 || index >= length) return null
        return when (index) {
            length - 1 -> pop()
            0 -> shift()
            else -> {
                val previousNode = get(index - 1)
                val toBeRemoved = previousNode?.next
                previousNode?.next = toBeRemoved?.next
                toBeRemoved
            }
        }
    }

    /**
     * Swap the head and the tail
     * Create a variable called next
     * Create a variable called previous
     * Create a variable called node and initialize it to the head property
     * Loop through the list
     * Set next to be the next property on whatever node is
     * Set next on the node to what ever previous is
     * Set the previous to be the value of the node variable
     * Set the node variable to be the value of the next variable
     */
    fun reverse(): LinkedList {
        var node = head
        head = tail
        tail = node
        var next: Node?
        var previous: Node? = null
        for (i in 0..length) {
            next = node?.next
            node?.next = previous
            previous = node
            node = next
        }
        return this
    }

}