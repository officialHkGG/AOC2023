package `2023`.day03_2.src.main.kotlin

import java.io.File

fun main() {
    val filename = "src/2023/day03_2/src/main/resources/input"
    val engineSchematic = readFile(filename)
    val sumOfPartNumbers = calculateSumOfPartNumbers(engineSchematic)
    println("Sum of all part numbers: $sumOfPartNumbers")
}

fun readFile(filename: String): List<String> {
    return File(filename).readLines()
}

fun calculateSumOfPartNumbers(engineSchematic: List<String>): Int {
    return engineSchematic.map { line ->
        line.filterIndexed { index, _ ->
            isPartNumber(engineSchematic, line, index)
        }.sumBy { it.toString().toInt() }
    }.sum()
}

fun isPartNumber(engineSchematic: List<String>, line: String, index: Int): Boolean {
    if (line[index] == '.') return false
    val symbols = setOf('*', '#', '+', '$')
    val directions = listOf(
        Pair(-1, -1), Pair(-1, 0), Pair(-1, 1),
        Pair(0, -1), /* Current position */ Pair(0, 1),
        Pair(1, -1), Pair(1, 0), Pair(1, 1)
    )
    for ((dx, dy) in directions) {
        val newRow = engineSchematic.indexOf(line) + dx
        val newCol = index + dy
        if (newRow in engineSchematic.indices && newCol in line.indices &&
            symbols.contains(engineSchematic[newRow][newCol])
        ) {
            return true
        }
    }
    return false
}
