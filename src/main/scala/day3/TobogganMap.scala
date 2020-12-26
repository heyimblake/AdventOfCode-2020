package com.blakekhan.adventofcode2020
package day3

class TobogganMap(parsed: List[String]) {

  /**
   * Validates and adjusts a given point.
   *
   * @param x row value (zero-indexed)
   * @param y col value (zero-indexed)
   * @return the adjusted equivalent point within the map
   */
  def getAdjustedPoint(x: Int, y: Int): (Int, Int) = {
    if (x >= parsed.size || x < 0) {
      throw new IllegalArgumentException("x is not within bounds")
    }

    val row: String = parsed(x)
    var col: Int = y

    // Adjust col until its at the corresponding place in the list
    while (col >= row.length) {
      col -= row.length
    }

    if (col < 0) {
      col = 0
    }

    (x, col)
  }

  /**
   * Determines if the provided point is a tree. The points are assumed to be adjusted and valid.
   *
   * @param x row (zero-indexed)
   * @param y col (zero-indexed)
   * @return `true` if the point is a tree, `false` otherwise
   */
  def isPointTree(x: Int, y: Int): Boolean = {
    parsed(x).charAt(y).equals('#')
  }

  /**
   * Determines if the provided point is empty. The points are assumed to be adjusted and valid.
   *
   * @param x row (zero-indexed)
   * @param y col (zero-indexed)
   * @return `true` if the point is empty, `false` otherwise
   */
  def isPointEmpty(x: Int, y: Int): Boolean = {
    parsed(x).charAt(y).equals('.')
  }

  /**
   * Starting at (x,y) and using slope mx+b, counts the number of trees in the slope.
   *
   * @param m the number of times to go right
   * @param b the number of times to go down
   * @param x the starting x point
   * @param y the starting y point
   * @return the number of trees in the provided slope
   */
  def countTreesInSlope(m: Int, b: Int, x: Int, y: Int): Long = {
    if (x >= parsed.size) {
      return 0L
    }

    val adjusted: (Int, Int) = getAdjustedPoint(x, y)
    (if ((isPointTree _).tupled(adjusted)) 1L else 0L) + countTreesInSlope(m, b, x + b, y + m)
  }
}
