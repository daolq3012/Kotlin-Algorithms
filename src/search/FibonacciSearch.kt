package search

import sort.HeapSort
import java.io.IOException
import java.util.*
import kotlin.collections.ArrayList

class FibonacciSearch : SearchAlgorithms<Int> {

    override fun findIndexOf(arr: ArrayList<Int>, value: Int): Int {
        /* Initialize fibonacci numbers */
        val fib = ArrayList<Int>()
        fib.add(0) // Fibonacci No 1.
        fib.add(1) // Fibonacci No 2.
        while (fib.last() < arr.size) {
            fib.add(fib.last() + fib[fib.lastIndex - 1])
        }

        var index = 0
        var k = 0
        while (arr.size > fib[k]) {
            k++
        }

        while (k > 0) {
            val pos = index + fib[k - 1]
            if (pos >= arr.size || value < arr[pos]) {
                k--
            } else if (value > arr[pos]) {
                index = pos
                k--
            } else {
                return pos
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

            val searchAlgorithms: SearchAlgorithms<Int> = FibonacciSearch()
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
