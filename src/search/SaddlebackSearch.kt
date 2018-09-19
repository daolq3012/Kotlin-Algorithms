package search

import java.io.IOException
import java.util.*

class SaddlebackSearch {

    fun findPositionOf(mat: Array<Array<Int>>, value: Int): Position {
        if (mat.isEmpty()) {
            return Position(-1, -1)
        }

        val row = mat.size
        val col = mat[0].size
        // set indexes for
        // top right element
        var i = 0
        var j = col - 1
        while (i < row && j >= 0) {
            when {
                (mat[i][j] == value) -> return Position(i, j)
                (mat[i][j] < value) -> i++
                else -> j--
            }
        }
        return Position(-1, -1)
    }

    object Run {
        @Throws(IOException::class)
        @JvmStatic
        fun main(args: Array<String>) {
            val matrixInputs = arrayOf(
                    arrayOf(5, 17, 28, 31),
                    arrayOf(11, 21, 30, 37),
                    arrayOf(12, 23, 32, 38),
                    arrayOf(15, 25, 35, 39),
                    arrayOf(27, 29, 36, 40))

            val searchAlgorithms = SaddlebackSearch()

            val randomValue = Random().nextInt(41)// random 0-40
            val result = searchAlgorithms.findPositionOf(matrixInputs, randomValue)
            System.out.print("---------Result---------\n")
            if (result.row != -1) {
                System.out.print("Found $randomValue in matrixInputs at position [${result.row},${result.column}]")
            } else {
                System.out.print("$randomValue not found in matrixInputs!")
            }
        }
    }

    data class Position(var row: Int, var column: Int)
}
