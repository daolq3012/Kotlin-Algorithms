package search

import sort.HeapSort
import java.io.IOException
import java.util.*
import kotlin.collections.ArrayList

class TernarySearch : SearchAlgorithms<Int> {

    override fun findIndexOf(arr: ArrayList<Int>, value: Int): Int {
        return ternarySearch(arr, value, 0, arr.size - 1)
    }

    /**
     * @param arr The **Sorted** array in which we will search the element.
     * @param key The value that we want to search for.
     * @param left The starting index from which we will left Searching.
     * @param right The ending index till which we will Search.
     * @return Returns the index of the Element if found.
     * Else returns -1.
     */
    private fun ternarySearch(arr: ArrayList<Int>, key: Int, left: Int, right: Int): Int {
        if (left > right) {
            return -1
        }
        /* First boundary: add 1/3 of length to left */
        var mid1 = left + (right - left) / 3
        /* Second boundary: add 2/3 of length to left */
        var mid2 = left + 2 * (right - left) / 3

        return when {
            key == arr[mid1] -> mid1
            key == arr[mid2] -> mid2
        /* Search the first (1/3) rd part of the array.*/
            key < arr[mid1] -> ternarySearch(arr, key, left, --mid1)
        /* Search 3rd (1/3)rd part of the array */
            key > arr[mid2] -> ternarySearch(arr, key, ++mid2, right)
        /* Search middle (1/3)rd part of the array */
            else -> ternarySearch(arr, key, mid1, mid2)
        }
    }

    object Run {
        @Throws(IOException::class)
        @JvmStatic
        fun main(args: Array<String>) {
            val dataInputs = arrayListOf(6, 5, 3, 1, 8, 7, 2, 4)
            // sort data inputs
            HeapSort().sort(dataInputs)
            System.out.print("---------Input---------\n$dataInputs\n")

            val searchAlgorithms: SearchAlgorithms<Int> = TernarySearch()
            val randomInput = Random().nextInt(10)
            val result = searchAlgorithms.findIndexOf(dataInputs, randomInput)
            System.out.print("---------Result---------\n")
            if (result != -1) {
                System.out.print("Found $randomInput at index $result")
            } else {
                System.out.print("$randomInput not found in dataInputs!")
            }
        }
    }
}
