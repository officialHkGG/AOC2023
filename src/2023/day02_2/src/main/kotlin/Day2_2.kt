package day02_2
import java.io.File

data class Cube(val color: String, val count: Int)

fun main() {
    val filename = "src/2023/day02_1/src/main/resources/input"
    val games = readFile(filename)
    val possibleGames = findPossibleGames(games, 12, 13, 14)
    val sumOfIDs = possibleGames.sumBy { it.first }
    println("Sum of IDs of possible games: $sumOfIDs")
}

fun readFile(filename: String): List<Pair<Int, List<Cube>>> {
    return File(filename).useLines { lines ->
        lines.map { line ->
            val parts = line.split(": ")
            val gameID = parts[0].substringAfter("Game ").toInt()
            val cubes = parts[1].split("; ").map { parseCubes(it) }
            gameID to cubes
        }.toList()
    }
}

fun parseCubes(input: String): Cube {
    val (count, color) = input.split(" ")
    return Cube(color, count.toInt())
}

fun findPossibleGames(games: List<Pair<Int, List<Cube>>>, red: Int, green: Int, blue: Int): List<Pair<Int, List<Cube>>> {
    return games.filter { game ->
        val (gameID, cubes) = game
        var remainingRed = red
        var remainingGreen = green
        var remainingBlue = blue
        var possible = true
        for (cube in cubes) {
            when (cube.color) {
                "red" -> remainingRed -= cube.count
                "green" -> remainingGreen -= cube.count
                "blue" -> remainingBlue -= cube.count
            }
            if (remainingRed < 0 || remainingGreen < 0 || remainingBlue < 0) {
                possible = false
                break
            }
        }
        possible
    }
}
