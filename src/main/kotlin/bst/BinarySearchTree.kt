package bst

data class BinarySearchTree(internal var root: Node? = null) {

    /**
     * Create new node with @param value
     * Start at the root
     * No root -> root = new node
     * Else -> check root value greater or smaller than @param value
     * If greater check node to the right -> empty set, else move to the node and repeat logic
     * If smaller check node to the left -> empty ser, else move to the node and repeat logic
     */
    fun insert(value: Int): BinarySearchTree {
        root?.insert(value) ?: run {
            root = Node(value)
        }
        return this
    }

    /**
     * Start at the root, no root done
     * root -> check root value, no match
     * check greater than value -> go right until there are no more leaf
     * check lower than value -> go left until there are no more leaf
     */
    fun find(value: Int): Boolean {
        return root?.find(value) ?: false
    }

    /**
     * Create a queue (FIFO)
     * and list on node visited
     * Place the root in the queue
     * Loop until there is anything in the queue
     * If left push to the queue if right push to the queue
     * Keep processing until no more items
     * Not:: This method is for all binary trees
     * @return list BFS
     */
    fun bfs(): List<Int> {
        return root?.let {
            val data = mutableListOf<Int>()
            bfs(mutableListOf(it), data)
            data
        } ?: emptyList()
    }

    private fun bfs(queue: MutableList<Node>, data: MutableList<Int>) {
        if (queue.isEmpty()) return
        val node = queue.removeFirst()
        data.add(node.value)
        node.left?.let { queue.add(it) }
        node.right?.let { queue.add(it) }
        bfs(queue, data)
    }

    /**
     * Visit al nodes from one side until there are no more leaf
     * @return list DFS
     */
    fun dfsPreOrder(): List<Int> {
        val data = mutableListOf<Int>()
        dfsPreOrder(root, data)
        return data
    }

    private fun dfsPreOrder(node: Node?, data: MutableList<Int>) {
        if (node == null) return
        data.add(node.value)
        dfsPreOrder(node.left, data)
        dfsPreOrder(node.right, data)
    }

    /**
     * Explore al nodes are no more leaf and the "visit the nodes"
     * @return list DFS
     */
    fun dfsPostOrder(): List<Int> {
        val data = mutableListOf<Int>()
        dfsPostOrder(root, data)
        return data
    }

    private fun dfsPostOrder(node: Node?, data: MutableList<Int>) {
        if (node == null) return
        dfsPostOrder(node.left, data)
        dfsPostOrder(node.right, data)
        data.add(node.value)
    }
    /**
     * Explore al nodes to the left, then visit root and then go right
     * @return list DFS
     */
    fun dfsInOrder(): List<Int> {
        val data = mutableListOf<Int>()
        dfsInOrder(root, data)
        return data
    }

    private fun dfsInOrder(node: Node?, data: MutableList<Int>) {
        if (node == null) return
        dfsInOrder(node.left, data)
        data.add(node.value)
        dfsInOrder(node.right, data)
    }

}