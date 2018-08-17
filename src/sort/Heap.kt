package sort

import extention.swap
import java.io.IOException

/**
 * * Heap Sort Algorithm.
 * * @see: http://staff.ustc.edu.cn/~csli/graduate/algorithms/book6/chap07.htm
 */
class Heap {

    fun heapSort(arr: ArrayList<Int>): ArrayList<Int> {
        val count = arr.size

        //first place arr in max-heap order
        buildMaxHeap(arr, count)

        var endIndex = count - 1
        while (endIndex > 0) {
            //swap the root(maximum value) of the heap with the last element of the heap
            arr.swap(0, endIndex)
            //put the heap back in max-heap order
            siftDown(arr, 0, endIndex - 1)
            //decrement the size of the heap so that the previous
            //max value will stay in its proper place
            endIndex--
        }
        return arr
    }

    private fun buildMaxHeap(arr: ArrayList<Int>, count: Int) {
        //start is assigned the index in a of the last parent node
        var start = (count - 2) / 2 //binary heap

        while (start >= 0) {
            //sift down the node at index start to the proper place
            //such that all nodes below the start index are in heap
            //order
            siftDown(arr, start, count - 1)
            start--
        }
        //after sifting down the root all nodes/elements are in heap order
    }

    private fun siftDown(arr: ArrayList<Int>, start: Int, end: Int) {
        //end represents the limit of how far down the heap to sift
        var root = start

        while (root * 2 + 1 <= end) {      //While the root has at least one child

            var child = root * 2 + 1           //root*2+1 points to the left child
            //if the child has a sibling and the child's value is less than its sibling's...
            if (child + 1 <= end && arr[child] < arr[child + 1]) {
                child = root * 2 + 2          //... then point to the right child instead
            }
            if (arr[root] < arr[child]) {     //out of max-heap order
                arr.swap(root, child)
                root = child                //repeat to continue sifting down the child now
            } else {
                break
            }
        }
    }
}

object Run {

    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val input = arrayListOf(6, 5, 3, 11, 1, 100, 8, 25, 26, 15, 14, 9, 7, 2, 4, 0, 33, 55, 26)
        val outPut = Heap().heapSort(input)
        System.out.print("---------Result---------\n$outPut ")
    }
}
