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

}
