package sort

import extention.swap
import java.io.IOException

class BubbleSort : SortAlgorithms<ArrayList<Int>> {
    override fun sort(arr: ArrayList<Int>) {
        val size = arr.size
        for (i in 0 until size) {
            for (j in 1 until size - i) {
                if (arr[j - 1] > arr[j]) {
                    //swap elements
                    arr.swap(j, j - 1)
                }
            }
        }
    }

    object Run {
        @Throws(IOException::class)
        @JvmStatic
        fun main(args: Array<String>) {
            val input = arrayListOf(6, 5, 3, 1, 8, 7, 2, 4)
            val sortAlgorithms: SortAlgorithms<ArrayList<Int>> = BubbleSort()
            sortAlgorithms.sort(input)
            System.out.print("---------Result---------\n$input")
        }
    }
}
