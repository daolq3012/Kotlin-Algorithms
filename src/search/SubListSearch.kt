package search

import java.io.IOException
import java.util.*

class SubListSearch {

    // check firstList inside secondList
    fun findList(firstList: LinkedList<Int>, secondList: LinkedList<Int>): Boolean {

        // If both linked lists are empty, return true
        if (firstList.isEmpty() && secondList.isEmpty()) {
            return true
        }

        // Else If one is empty and other is not return false
        if (firstList.isEmpty() ||
                (firstList.isNotEmpty() && secondList.isEmpty())) {
            return false
        }

        // Traverse the secondList list by picking nodes
        // one by one
        var index = 0
        while (secondList.size >= firstList.size) {
            // Initialize value with current node of secondList
            val secondValue = secondList.pop()

            if (firstList[index] == secondValue) {
                index++
            } else {
                // reset index
                index = 0
            }

            if (index == firstList.size) {
                return true
            }
        }
        return false
    }

    object Run {
        @Throws(IOException::class)
        @JvmStatic
        fun main(args: Array<String>) {

            val first = LinkedList<Int>()
            first.addAll(arrayListOf(4, 2, 3))
            val second = LinkedList<Int>()
            second.addAll(arrayListOf(0, 1, 2, 3, 4, 2, 3, 5, 6, 7, 8, 9))
            val secondClone = second.clone() as LinkedList<Int>

            val result = SubListSearch().findList(first, secondClone)
            System.out.print("---------Result---------\n")
            if (result) {
                System.out.print("Found \n$first \ninside \n$second")
            } else {
                System.out.print("Not found \n$first \ninside \n$second")
            }
        }
    }
}
