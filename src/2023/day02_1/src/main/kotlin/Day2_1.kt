package day02_1
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
    val games = mutableListOf<Pair<Int, List<Cube>>>()
    File(filename).forEachLine { line ->
        val parts = line.split(": ")
        val gameID = parts[0].substringAfter("Game ").toInt()
        val cubes = parts[1].split("; ").map { parseCubes(it) }
        games.add(gameID to cubes)
    }
    return games
}

fun parseCubes(input: String): Cube {
    val (count, color) = input.split(" ")
    return Cube(color, count.toInt())
}

fun findPossibleGames(games: List<Pair<Int, List<Cube>>>, red: Int, green: Int, blue: Int): List<Pair<Int, List<Cube>>> {
    val possibleGames = mutableListOf<Pair<Int, List<Cube>>>()
    for ((gameID, cubes) in games) {
        var redCount = red
        var greenCount = green
        var blueCount = blue
        var possible = true
        for (cube in cubes) {
            when (cube.color) {
                "red" -> redCount -= cube.count
                "green" -> greenCount -= cube.count
                "blue" -> blueCount -= cube.count
            }
            if (redCount < 0 || greenCount < 0 || blueCount < 0) {
                possible = false
                break
            }
        }
        if (possible) {
            possibleGames.add(gameID to cubes)
        }
    }
    return possibleGames
}
