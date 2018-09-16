package search

interface SearchAlgorithms<T : Comparable<T>> {
    fun findIndexOf(arr: ArrayList<T>, value: T) : Int
}
