package execises

//Find the first repeating element in an array of integers
//Given an array of integers, find the first repeating element in it.
// We need to find the element that occurs more than once and whose index of first occurrence is smallest.

//Input:  arr[] = {10, 5, 3, 4, 3, 5, 6}
//Output: 5 [5 is the first element that repeats]
//
//Input:  arr[] = {6, 10, 5, 4, 9, 120, 4, 6, 10}
//Output: 6 [6 is the first element that repeats]

data class FoundValue(val value: Int, val index: Int)

// Input trust all integers from 1 to n, unsorted array
// Output: First repeated (find :D) if not repeated just return null

fun firstRepeated(array: IntArray): Int? {

    // base scenarios array empty and with 1 element

    if (array.size in 0..1) return null

    // Use a map to save if the value is already repeated
    val mapValues = mutableMapOf<Int, FoundValue>()
    // helper variable to save the value to be returned
    var repeatedValue: FoundValue? = null


    // loop the array
    array.forEachIndexed { index, element ->
        // if the value already in the Map update repeated
        if (mapValues.containsKey(element)) {
            val repeatedMapValue = mapValues[element]
            // if the helper variable is empty or the previous index was bigger update
            if (repeatedValue == null || repeatedValue!!.index > repeatedMapValue!!.index) {
                repeatedValue = repeatedMapValue
            }
        } else {
            // else just put it into the Map with repeated false
            mapValues[element] = FoundValue(element, index)
        }
    }

    // return the helper variable
    return repeatedValue?.value
}
