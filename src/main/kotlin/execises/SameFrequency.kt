package execises

/**
 * Given two positive Int
 * @return true if the @param value1 is a permutation of two and the other way around
 */
internal fun sameFrequency(value1: Int, value2: Int) : Boolean {
    // I could sum each individual number and if the result is equals there is a permutation :D
    // Map both values to String and check the length of bot values first, if are not the same the answer is false
    val string1 = value1.toString()
    val string2 = value2.toString()
    if (string1.length != string2.length) {
        return false
    }
    // Map the String to a List of individual characters
    // Then map to int and sum all together
    val value1Sum = string1.toCharArray().sumBy { it.toInt() }
    val value2Sum = string2.toCharArray().sumBy { it.toInt() }
    // Return the result comparison
    return value1Sum == value2Sum

}

// For example 123456 and 654321 returns true