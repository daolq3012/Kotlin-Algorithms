package sort

import extention.swap
import java.io.IOException

class SelectionSort : SortAlgorithms<ArrayList<Int>> {

    override fun sort(arr: ArrayList<Int>) {

        // loop from 0 to one before last
        for (i in 0 until arr.size - 1) {
            // set the position of the smallest value to i
            var smallestPos = i

            // loop from past current (i + 1) to end
            for (j in i + 1 until arr.size) {
                // if the current is smaller then save pos
                if (arr[j] < arr[smallestPos]) {
                    smallestPos = j
                }
            }
            // swap smallest with current value at i
            arr.swap(i, smallestPos)
        }
    }

    object Run {
        @Throws(IOException::class)
        @JvmStatic
        fun main(args: Array<String>) {
            val input = arrayListOf(6, 5, 3, 1, 8, 7, 2, 4, 13, 75, 16, 10)
            val sortAlgorithms: SortAlgorithms<ArrayList<Int>> = SelectionSort()
            sortAlgorithms.sort(input)
            System.out.print("---------Result---------\n$input ")
        }
    }
}
