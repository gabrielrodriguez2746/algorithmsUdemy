/**
 * Count unique values
 * Given a sorted IntArray
 * count the number of unique values
 * Considerations: Array empty -> 0
 * Assumptions: All numbers in the array could be represented in an Int
 * Will do it with the approach given at the course and with kotlin functions
 */
fun main() {
    val input1 = intArrayOf(1, 1, 1, 1, 1, 2)
    val input2 = intArrayOf(1, 2, 3, 4, 4, 4, 7, 7, 12, 12, 13)
    val input3 = intArrayOf()
    val input4 = intArrayOf(-2, -1, -1, 0, 1)
    println("countUniqueValues :: from $input1 ${countUniqueValues(input1)}")
    println("countUniqueValues :: from $input2 ${countUniqueValues(input2)}")
    println("countUniqueValues :: from $input3 ${countUniqueValues(input3)}")
    println("countUniqueValues :: from $input4 ${countUniqueValues(input4)}")
    println("countUniqueValuesKotlin :: from $input1 ${countUniqueValuesKotlin(input1)}")
    println("countUniqueValuesKotlin :: from $input2 ${countUniqueValuesKotlin(input2)}")
    println("countUniqueValuesKotlin :: from $input3 ${countUniqueValuesKotlin(input3)}")
    println("countUniqueValuesKotlin :: from $input4 ${countUniqueValuesKotlin(input4)}")
}

internal fun countUniqueValues(input: IntArray): Int {
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

internal fun countUniqueValuesKotlin(input: IntArray): Int {
    // Group by it and then return the count
    return input.groupBy { it }.size
}