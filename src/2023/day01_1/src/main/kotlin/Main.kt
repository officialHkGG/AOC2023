package day01_1
import java.io.File

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Usage: java -classpath . day01_1.MainKt <src/2023/day01_1/src/main/resources/small_input>")
        return
    }

    println("AOC 2023, Day 1, Part 1 starting!!!")

    var answer: Int = 0

    File(args[0]).forEachLine {
        answer += parseLine(it)
    }

    println("The answer: $answer")
    println("AOC 2023, Day 1, Part 1 completed!!")
}

fun parseLine(line: String): Int {
    val answerTens: Int = parseLeftToRight(line)
    val answerOnes: Int = parseRightToLeft(line)
    return (answerTens * 10) + answerOnes
}

fun parseLeftToRight(line: String): Int {
    if (!line.any { it.isDigit() }) {
        return 0
    }
    return line.first { it.isDigit() }.digitToInt()
}

fun parseRightToLeft(line: String): Int {
    if (!line.any { it.isDigit() }) {
        return 0
    }
    return line.last { it.isDigit() }.digitToInt()
}
