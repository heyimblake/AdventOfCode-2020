package com.blakekhan.adventofcode2020
package day3

import org.scalatest.funsuite.AnyFunSuite

class TobogganMapTest extends AnyFunSuite {

  test("TobogganMap.getAdjustedPoint") {
    val tm: TobogganMap = new TobogganMap(Util.fileToStrList("day3/Sample.txt"))
    assert(tm.getAdjustedPoint(0, 0) == (0, 0))
    assertThrows[IllegalArgumentException](tm.getAdjustedPoint(11, 0)) // Row too large
    assert(tm.getAdjustedPoint(8, 8) == (8, 8))
    assert(tm.getAdjustedPoint(8, 15) == (8, 4)) // Col val adjusted
    assert(tm.getAdjustedPoint(8, 11) == (8, 0)) // Col val adjusted
  }

  test("TobogganMap.isPointTree") {
    val tm: TobogganMap = new TobogganMap(Util.fileToStrList("day3/Sample.txt"))
    assert(!(tm.isPointTree _).tupled(tm.getAdjustedPoint(8, 15)))
    assert((tm.isPointTree _).tupled(tm.getAdjustedPoint(10, 1)))
  }

  test("TobogganMap.isPointEmpty") {
    val tm: TobogganMap = new TobogganMap(Util.fileToStrList("day3/Sample.txt"))
    assert((tm.isPointEmpty _).tupled(tm.getAdjustedPoint(8, 15)))
    assert(!(tm.isPointEmpty _).tupled(tm.getAdjustedPoint(10, 1)))
  }

  test("TobogganMap.countTreesInSlope") {
    val tmSample: TobogganMap = new TobogganMap(Util.fileToStrList("day3/Sample.txt"))
    val tm: TobogganMap = new TobogganMap(Util.fileToStrList("day3/Day3Input.txt"))

    assert(tmSample.countTreesInSlope(3, 1, 0, 0) == 7L) // Part 1 Sample Given
    assert(tm.countTreesInSlope(3, 1, 0, 0) == 214L) // Part 1 Answer

    // Part 2 Sample Given
    assert(
      tmSample.countTreesInSlope(1, 1, 0, 0) * tmSample.countTreesInSlope(3, 1, 0, 0) *
        tmSample.countTreesInSlope(5, 1, 0, 0) * tmSample.countTreesInSlope(7, 1, 0, 0) *
        tmSample.countTreesInSlope(1, 2, 0, 0) == 336L
    )

    // Part 2 Answer
    assert(
      tm.countTreesInSlope(1, 1, 0, 0) * tm.countTreesInSlope(3, 1, 0, 0) *
        tm.countTreesInSlope(5, 1, 0, 0) * tm.countTreesInSlope(7, 1, 0, 0) *
        tm.countTreesInSlope(1, 2, 0, 0) == 8336352024L
    )
  }

}
