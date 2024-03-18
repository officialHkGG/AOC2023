import java.io.File

fun main() {
    val filename = "src/2023/day01_2/src/main/resources/input"
    val document = readFile(filename)
    val sum = calculateSumOfCalibrationValues(document)
    println("Sum of calibration values: $sum")
}

fun readFile(filename: String): String {
    val file = File(filename)
    return file.readText()
}

fun calculateSumOfCalibrationValues(document: String): Int {
    val regex = Regex("""\d+""")
    val matches = regex.findAll(document)

    var sum = 0
    for (match in matches) {
        val digits = match.value
        val firstDigit = digits.first().toString().toInt()
        val lastDigit = digits.last().toString().toInt()
        sum += firstDigit * 10 + lastDigit
    }

    return sum
}
