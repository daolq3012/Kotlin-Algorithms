package sort

import extention.swap
import java.io.IOException

class ShellSort : SortAlgorithms<ArrayList<Int>> {

    override fun sort(arr: ArrayList<Int>) {
        var k = arr.size / 2
        while (k > 0) {
            for (i in k until arr.size) {
                var j = i
                while (j >= k && arr[j] < arr[j - k]) {
                    arr.swap(j, j - k)
                    j -= k
                }
            }
            k /= 2
        }
    }

    object Run {
        @Throws(IOException::class)
        @JvmStatic
        fun main(args: Array<String>) {
            val input = arrayListOf(6, 5, 3, 1, 8, 7, 2, 4)
            val sortAlgorithms: SortAlgorithms<ArrayList<Int>> = ShellSort()
            sortAlgorithms.sort(input)
            System.out.print("---------Result---------\n$input")
        }
    }
}
