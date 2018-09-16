package search

import sort.HeapSort
import java.io.IOException
import java.util.*
import kotlin.collections.ArrayList

class BinarySearch : SearchAlgorithms<Int> {

    override fun findIndexOf(arr: ArrayList<Int>, value: Int): Int {
        return search(arr, value, 0, arr.size - 1)
    }

    /**
     * This method implements the Generic Binary Search
     *
     * @param array The array to make the binary search
     * @param key The number you are looking for
     * @param left The lower bound
     * @param right The  upper bound
     * @return the location of the key
     */
    private fun <T : Comparable<T>> search(array: ArrayList<T>, key: T, left: Int, right: Int): Int {

        // this means that the key not found
        if (right < left) {
            return -1
        }

        // find median
        val median = (left + right).ushr(1) // (It mean: >>> 1 or left + right /2)
        val comp = key.compareTo(array[median])

        if (comp < 0) {
            return search(array, key, left, median - 1)
        }

        return if (comp > 0) {
            search(array, key, median + 1, right)
        } else {
            median
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

            val searchAlgorithms: SearchAlgorithms<Int> = BinarySearch()
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
