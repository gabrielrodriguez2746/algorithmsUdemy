package execises

import kotlin.math.abs

data class SmallestDifferenceResult(val valuePair: Pair<Int, Int>, val difference: Int)

// Smallest Difference pair of values between two unsorted Arrays
// Difficulty Level : Easy
//  Last Updated : 21 May, 2018
// Given two arrays of integers, compute the pair of values (one value in each array) with the smallest (non-negative) difference. Return the difference.

// Examples :

// Input : A[] = {l, 3, 15, 11, 2}
//         B[] = {23, 127, 235, 19, 8}
// Output : 3
// That is, the pair (11, 8)

// Input : A[] = {l0, 5, 40}
//         B[] = {50, 90, 80}
// Output : 10
// That is, the pair (40, 50)


// Input two int array, usorted
// Can I change the inout arrays? lets say that yes
// Question, does the int array include negative? lets say yes
// Difference will be the abs value
// Return the pair of values

fun smallestDifference(array1: IntArray, array2: IntArray): SmallestDifferenceResult? {
    // Base cases
    if (array1.isEmpty() || array2.isEmpty()) return null


    // if the input are unsorted i might need to iterate over all the elemnts of each
    // sorting the list I know the big difference I could get stablish a condition to move two pointer
    // at the same time
    array1.sort()
    array2.sort()


    // then with a save refrence of the diffrence update it base on new results

    var pointer1 = 0
    var pointer2 = 0

    var smallestDifference = Int.MAX_VALUE // This is just to cover the first iteration
    var pairResult: Pair<Int, Int>? = null

    do {
        val array1Value = array1[pointer1]
        val array2Value = array2[pointer2]

        val difference = abs(array1Value - array2Value)

        // update difference if smaller than the previous (save everything for now) pair and difference
        if (difference < smallestDifference) {
            smallestDifference = difference
            pairResult = array1Value to array2Value
        }

        // Need to move to something that give me less difference (move the smallest)
        // Waht if equal... Maybe just break and return
        if (array1Value < array2Value) {
            pointer1++
        } else {
            pointer2++
        }


    } while (pointer1 < array1.size && pointer2 < array2.size)


    // [1,2,3,11,15] [8,19,23,127,235]
    //  >             >                 difference 7 // which is samllest, first -> move first
    // [1,2,3,11,15] [8,19,23,127,235]
    //    >           >                 difference 6 update, smallest, first -> move first
    // and so on

    // lets save the pair of value and the difference to better debugging

    // return the difference reference

    return SmallestDifferenceResult(pairResult!!, smallestDifference)

}