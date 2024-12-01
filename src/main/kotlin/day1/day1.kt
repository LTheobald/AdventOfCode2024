package day1

import java.io.File

fun main(args: Array<String>) {
    val leftLocationIds = mutableListOf<Int>()
    val rightLocationIds = mutableListOf<Int>()

    File("src/main/resources/day1.txt").readLines().forEach{
        val parts = Regex("\\s+").split(it)
        leftLocationIds.add(parts[0].toInt())
        rightLocationIds.add(parts[1].toInt())
    }

    leftLocationIds.sort()
    rightLocationIds.sort()

    val totalDistance = leftLocationIds.indices.sumOf { i ->
        Math.abs(leftLocationIds[i] - rightLocationIds[i])
    }

    val rightLocationFrequency = rightLocationIds.groupingBy { it }.eachCount()
    val similarityScore = leftLocationIds.sumOf { id ->
        id * (rightLocationFrequency[id] ?: 0)
    }

    println("Total Distance: ${totalDistance}")
    println("Similarity Score: ${similarityScore}")
}