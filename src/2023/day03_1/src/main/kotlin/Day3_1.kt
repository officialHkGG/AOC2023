package `2023`.day03_1.src.main.kotlin

import java.io.File

fun main() {
    val filename = "src/2023/day03_1/src/main/resources/input"
    val engineSchematic = readFile(filename)
    val sumOfPartNumbers = calculateSumOfPartNumbers(engineSchematic)
    println("Sum of all part numbers: $sumOfPartNumbers")
}

fun readFile(filename: String): List<String> {
    return File(filename).readLines()
}

fun calculateSumOfPartNumbers(engineSchematic: List<String>): Int {
    var sum = 0
    for (i in engineSchematic.indices) {
        for (j in engineSchematic[i].indices) {
            if (engineSchematic[i][j] != '.' && isAdjacentToSymbol(engineSchematic, i, j)) {
                sum += engineSchematic[i][j].toString().toInt()
            }
        }
    }
    return sum
}

fun isAdjacentToSymbol(engineSchematic: List<String>, row: Int, col: Int): Boolean {
    val symbols = setOf('*', '#', '+', '$') // Add other symbols here if needed
    val directions = listOf(
        Pair(-1, -1), Pair(-1, 0), Pair(-1, 1),
        Pair(0, -1), /* Current position */ Pair(0, 1),
        Pair(1, -1), Pair(1, 0), Pair(1, 1)
    )
    for ((dx, dy) in directions) {
        val newRow = row + dx
        val newCol = col + dy
        if (newRow in engineSchematic.indices && newCol in engineSchematic[row].indices &&
            symbols.contains(engineSchematic[newRow][newCol])
        ) {
            return true
        }
    }
    return false
}
