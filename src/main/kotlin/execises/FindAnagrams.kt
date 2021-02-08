package execises

// Given an array of strings group the anagrams
// Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
// typically using all the original letters exactly once.

// Basically need to find the way to see if a[i] is anagram of a[j]
// It is easier to compare Int so if I am able to map the characters to an ascii code and obtain
// te sum result for the word, bingo

// Lets code

fun findAnagram(input: Array<String>) : List<List<String>> {

    // Need to translate the word to a comparable number without losing the word
    // Lets choose Pair as a data structure Pair<String, Int>
    // Two words could also sum the same, but if I sort the word and use it as a key... all good
    val listOfPairs = input.map {
            string ->  string to string.toSortedKey()
    }

    // Here Having an array of pair I need to group them by the sum, having a Map<Int, List<String>>

    val mapOfAnagrams = listOfPairs.groupBy { it.second }


    // Then just do a final mapping to return the array of array
    return mapOfAnagrams.values.map { it.mapToStringList() }

}

private fun String.toSortedKey() : String {
    return toList().sorted().toString()
}

private fun List<Pair<String, String>>.mapToStringList() : List<String> {
    return map { it.first }
}