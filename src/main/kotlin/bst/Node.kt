package bst

data class Node(val value: Int, var left: Node? = null, var right: Node? = null) {

    fun insert(value: Int) {
        if (value > this.value) {
            if (right == null) {
                right = Node(value)
            } else {
                right?.insert(value)
            }
        } else {
            if (left == null) {
                left = Node(value)
            } else {
                left?.insert(value)
            }
        }
    }

    fun find(value: Int) : Boolean {
        return when (value) {
            this.value -> true
            else -> {
                if (value > this.value) {
                    val right = this.right
                    right?.find(value) ?: false
                } else {
                    val left = this.left
                    left?.find(value) ?: false
                }
            }
        }
    }

}