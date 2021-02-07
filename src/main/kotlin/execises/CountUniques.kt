/**
 * Count unique values
 * Given a sorted IntArray
 * count the number of unique values
 * Considerations: Array empty -> 0
 * Assumptions: All numbers in the array could be represented in an Int
 */
fun countUniqueValues(input: IntArray): Int {
    // If empty array return 0
    if (input.isEmpty()) return 0
    // If only one element return 1
    if (input.size == 1) return 1
    // else have to pointer representing first and second position
    var initialPointer = 0
    var nextPointer = 1
    // Iterate over the input moving the second pointer
    while (nextPointer < input.size) {
        // Every time I found an element different than the one located at the initial pointer,
        val comparedValue = input[nextPointer]
        if (input[initialPointer] != comparedValue) {
            initialPointer++
            input[initialPointer] = comparedValue
        }
        // move i and update input[i] value
        nextPointer++
    }
    // output will be the index of i +1
    return initialPointer + 1
}
