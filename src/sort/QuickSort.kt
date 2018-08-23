package sort

import extention.swap
import java.io.IOException

class QuickSort : SortAlgorithms<ArrayList<Int>> {

    override fun sort(arr: ArrayList<Int>) {
        quicksort(arr, 0, arr.size - 1)
    }

    // Take Left (first) Index of the array and Right (last) Index of the array
    fun quicksort(arr: ArrayList<Int>, left: Int, right: Int) {
        // If the first index less or equal than the last index
        if (left <= right) {
            // Create a Key/Pivot Element
            val key = arr[(left + right) / 2]

            // Create temp Variables to loop through array
            var i = left
            var j = right

            while (i <= j) {
                while (arr[i] < key)
                    i++
                while (arr[j] > key)
                    j--

                if (i <= j) {
                    arr.swap(i, j)
                    i++
                    j--
                }
            }

            // Recursion to the smaller partition in the array after sorted above
            if (left < j) {
                quicksort(arr, left, j)
            }
            if (right > i) {
                quicksort(arr, i, right)
            }
        }
    }

    object Run {
        @Throws(IOException::class)
        @JvmStatic
        fun main(args: Array<String>) {
            val input = arrayListOf(6, 5, 3, 1, 8, 7, 2, 4)
            val sortAlgorithms: SortAlgorithms<ArrayList<Int>> = QuickSort()
            sortAlgorithms.sort(input)
            System.out.print("---------Result---------\n$input")
        }
    }
}
