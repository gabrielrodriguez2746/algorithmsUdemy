package execises

import kotlin.math.abs

// Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.

// Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows

// a, b are from arr
// a < b
// b - a equals to the minimum absolute difference of any two elements in arr
fun minimumAbsDifference(arr: IntArray): List<List<Int>> {

    if (arr.isEmpty()) return emptyList()

    // sorting the array make a < b
    arr.sort()

    if (arr.size == 2) return listOf(arr.toList())

    var minDifference = Int.MAX_VALUE
    val resultMap = mutableMapOf<Int, MutableList<List<Int>>>()

    for (i in 0..arr.size - 2) {

        val minorNumber = arr[i]
        val greaterNumber = arr[i + 1]

        val difference = abs(greaterNumber - minorNumber)

        if (minDifference > difference) {
            minDifference = difference
        }

        if (resultMap.containsKey(difference)) {
            resultMap[difference]?.apply { add(listOf(minorNumber, greaterNumber)) }
        } else {
            resultMap[difference] = mutableListOf(listOf(minorNumber, greaterNumber))
        }
    }



    return resultMap[minDifference]!!


}