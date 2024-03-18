/*package `2023`.day01_1.src.main.kotlin

import java.io.File

private const val FILE_NAME = "src/2023/day01_1/src/main/resources/input"

fun main() {
    val fileName = FILE_NAME
    val calibrationDocument = readCalibrationDocument(fileName)

    if (calibrationDocument.isNotEmpty()) {
        val sumOfCalibrationValuesA = extractCalibrationValues(calibrationDocument, 'A').sum()
        val sumOfCalibrationValuesB = extractCalibrationValues(calibrationDocument, 'B').sum()

        println("Sum of all calibration values for Scenario A: $sumOfCalibrationValuesA")
        println("Sum of all calibration values for Scenario B: $sumOfCalibrationValuesB")
    } else {
        println("Calibration document is empty or couldn't be read.")
    }
}

fun readCalibrationDocument(fileName: String): List<String> {
    val file = File(fileName)
    return try {
        file.useLines { it.toList() }
    } catch (e: Exception) {
        println("Error reading file: ${e.message}")
        emptyList()
    }
}

fun extractCalibrationValues(calibrationDocument: List<String>, scenario: Char): List<Int> {
    return calibrationDocument.mapNotNull { line ->
        // Extract first and last digits and calculate the two-digit number based on the scenario
        val firstDigit = line.firstOrNull()?.toString()?.toIntOrNull()
        val lastDigit = line.lastOrNull()?.toString()?.toIntOrNull()
        if (firstDigit != null && lastDigit != null) {
            when (scenario) {
                'A' -> firstDigit * 10 + lastDigit
                'B' -> firstDigit + lastDigit
                else -> null
            }
        } else {
            null
        }
    }
}
*/