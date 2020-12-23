package com.blakekhan.adventofcode2020

import scala.io.Source

object Day1 {

  /**
   * The number representing that an error has occurred for operations in this class.
   */
  val SOLVE_ERROR: Int = -1

  /**
   * Given an array of numbers and a target, returns the product of the two numbers which sum to the target.
   * @param numbers non-empty array of positive numbers
   * @param target positive target
   * @return product of the two numbers which sum to the target or `SOLVE_ERROR` if there was an error
   */
  def part1(numbers: Array[Int], target: Int): Long = {
    if (numbers.length == 0 || target < 0) {
      return SOLVE_ERROR
    }

    val half: Int = target / 2

    // Split the numbers into two halves
    val bottomHalf: Array[Int] = for (value <- numbers if value < half) yield value
    val topHalf: Array[Int] = (for (value <- numbers if value >= half) yield value).reverse

    // Compare elements in the top and bottom half together
    for (btm <- bottomHalf) {
      for (top <- topHalf) {
        if (btm + top == target) {
          return btm * top
        }
      }
    }

    // If there was no result
    SOLVE_ERROR
  }

  /**
   * Given an array of numbers and a target, returns the product of the three numbers which sum to the target.
   * @param numbers non-empty array of positive numbers
   * @param target positive target
   * @return product of the three numbers which sum to the target or `SOLVE_ERROR` if there was an error
   */
  def part2(numbers: Array[Int], target: Int): Long = {
    if (numbers.length == 0 || target < 0) {
      return SOLVE_ERROR
    }

    val resultTuple: (Int, Int, Int) = (for (x <- numbers; y <- numbers; z <- numbers) yield (x, y, z)).find(tuple3 => tuple3._1 + tuple3._2 + tuple3._3 == target).getOrElse((1, 1, SOLVE_ERROR))
    resultTuple._1 * resultTuple._2 * resultTuple._3
  }

  /**
   * Reads a file containing an integer on each line and returns a sorted array of the file contents.
   * @param path non-null path to the file
   * @return sorted array of integers from the file
   */
  def readAndSortLines(path: String): Array[Int] = {
    assert(path != null)
    Source.fromResource(path).getLines.map[Int](line => line.toInt).toArray.sorted
  }
}
