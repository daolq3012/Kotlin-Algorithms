package sort

import extention.swap
import java.io.IOException

class InsertionSort : SortAlgorithms<ArrayList<Int>> {

    override fun sort(arr: ArrayList<Int>) {
        var pos: Int

        // Loop from second element on
        for (i in 1 until arr.size) {
            // Save current value at i and set position to i
            val temp = arr[i]
            pos = i

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (0 < pos && temp < arr[pos - 1]) {
                arr.swap(pos, pos - 1)
                pos--
            }
        }
    }

    object Run {
        @Throws(IOException::class)
        @JvmStatic
        fun main(args: Array<String>) {
            val input = arrayListOf(6, 5, 3, 1, 8, 7, 2, 4)
            val sortAlgorithms: SortAlgorithms<ArrayList<Int>> = InsertionSort()
            sortAlgorithms.sort(input)
            System.out.print("---------Result---------\n$input")
        }
    }
}
