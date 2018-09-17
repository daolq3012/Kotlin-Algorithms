package search

import sort.HeapSort
import java.io.IOException
import java.util.*

class JumpSearch : SearchAlgorithms<Int> {

    override fun findIndexOf(arr: ArrayList<Int>, value: Int): Int {
        var left = 0
        var right = 0

        // Finding block size to be jumped
        val jump = Math.sqrt(arr.size.toDouble()).toInt()
        while (left < arr.size && arr[left] <= value) {
            right = Math.min(arr.size - 1, left + jump)
            if (arr[right] >= value) {
                break
            }
            left += jump
        }

        if (left >= arr.size || arr[left] > value) {
            return -1
        }

        // Doing a linear search for x in block
        // beginning with left.
        while (left <= right && arr[left] <= value) {
            // If element is found
            if (arr[left] == value) {
                return left
            }
            left++
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

            val searchAlgorithms: SearchAlgorithms<Int> = JumpSearch()
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
