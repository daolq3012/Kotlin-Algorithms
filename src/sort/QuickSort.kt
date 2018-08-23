package sort

import extention.swap
import java.io.IOException

class QuickSort {

    // Take Left (first) Index of the array and Right (last) Index of the array
    fun sort(arr: ArrayList<Int>, l: Int = 0, r: Int = arr.size - 1) {
        // If the first index less or equal than the last index
        if (l <= r) {
            // Create a Key/Pivot Element
            val key = arr[(l + r) / 2]

            // Create temp Variables to loop through array
            var i = l
            var j = r

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
            if (l < j) {
                sort(arr, l, j)
            }
            if (r > i) {
                sort(arr, i, r)
            }
        }
    }

    object Run {
        @Throws(IOException::class)
        @JvmStatic
        fun main(args: Array<String>) {
            val input = arrayListOf(6, 5, 3, 1, 8, 7, 2, 4)
            QuickSort().sort(input)
            System.out.print("---------Result---------\n$input")
        }
    }
}
