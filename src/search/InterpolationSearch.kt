package search

import sort.HeapSort
import java.io.IOException
import java.util.*

class InterpolationSearch : SearchAlgorithms<Int> {

    override fun findIndexOf(arr: ArrayList<Int>, value: Int): Int {
        // Find indexes of two corners
        var low = 0
        var hight = arr.size - 1

        // Since array is sorted, an element present
        // in array must be in range defined by corner
        while (low <= hight && value >= arr[low] && value <= arr[hight]) {
            // Probing the position with keeping
            // uniform distribution in mind.
            val pos = low + (hight - low) / (arr[hight] - arr[low]) * (value - arr[low])

            // Condition of target found
            if (arr[pos] == value) {
                return pos
            }

            // If x is larger, x is in upper part
            if (arr[pos] < value) {
                low = pos + 1
            } else {
                hight = pos - 1// If x is smaller, x is in the lower part
            }
        }
        return -1
    }

    object Run {
        @Throws(IOException::class)
        @JvmStatic
        fun main(args: Array<String>) {
            val dataInputs = arrayListOf(6, 5, 3, 1, 8, 7, 2, 4)
            // sort data inputs
            HeapSort().sort(dataInputs)
            System.out.print("---------Input---------\n$dataInputs\n")

            val searchAlgorithms: SearchAlgorithms<Int> = InterpolationSearch()
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
