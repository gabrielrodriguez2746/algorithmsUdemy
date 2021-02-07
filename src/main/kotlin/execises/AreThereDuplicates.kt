package execises

/**
 * Given @param arguments
 * Check for duplicated values
 * @return true if there are duplicates or false otherwise
 */
fun <T> areThereDuplicates(vararg arguments: T): Boolean {
    return arguments.groupBy { it }.size < arguments.size
}

// TODO Think in a no kotlin friendly implementation ;D