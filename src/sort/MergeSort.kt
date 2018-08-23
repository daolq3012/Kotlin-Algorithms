package sort

import java.io.IOException

/**
 * * Merge Sort Algorithm.
 */
class MergeSort {

    /**
     * Method to do array merge sort of the passed
     * array of ints
     * @param arr the array to sort
     */
    fun sort(arr: IntArray) {
        // check if there is only 1 element return
        if (arr.size == 1) {
            return
        }

        // otherwise create two new arrays
        val middleIndex = arr.size / 2

        val left = IntArray(middleIndex)
        left.forEachIndexed { index, _ ->
            left[index] = arr[index]
        }

        val right = IntArray(arr.size - left.size)
        right.forEachIndexed { index, _ ->
            right[index] = arr[middleIndex + index]
        }

        // do the recursive call with the new sorters
        sort(left)
        sort(right)

        // merge the resulting arrays
        merge(arr, left, right)
    }

    /**
     * Method to merge two sorted arrays
     * back into this object's array
     * @param inputArr the original array
     * @param left sorted left array
     * @param right the sorted right array
     */
    private fun merge(inputArr: IntArray, left: IntArray,
                      right: IntArray) {
        var leftIndex = 0 // current left index
        var rightIndex = 0 // current right index
        var i = 0 // current index in inputArr

        // merge the left and right arrays into inputArr
        while (leftIndex < left.size && rightIndex < right.size) {
            if (left[leftIndex] < right[rightIndex]) {
                inputArr[i] = left[leftIndex]
                leftIndex++
            } else {
                inputArr[i] = right[rightIndex]
                rightIndex++
            }
            i++
        }

        // copy any remaining in left
        for (j in leftIndex until left.size) {
            inputArr[i] = left[j]
            i++
        }

        // copy any remaining in right
        for (j in rightIndex until right.size) {
            inputArr[i] = right[j]
            i++
        }
    }

    object Run {
        @Throws(IOException::class)
        @JvmStatic
        fun main(args: Array<String>) {
            val input = arrayListOf(6, 5, 3, 1, 8, 7, 2, 4).toIntArray()
            MergeSort().sort(input)
            System.out.print("---------Result---------\n${input.toMutableList()}")
        }
    }
}
