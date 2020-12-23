package com.blakekhan.adventofcode2020

import org.scalatest.funsuite.AnyFunSuite

class Day1Test extends AnyFunSuite {

  test("Day1.readAndSortLines") {
    assert(Day1.readAndSortLines("SampleInts.txt") sameElements Array(1721, 979, 366, 299, 675, 1456).sorted)
  }

  test("Day1.part1") {
    assert(Day1.part1(Array(1721, 979, 366, 299, 675, 1456), 2020) == 514579L)
    assert(Day1.part1(Day1.readAndSortLines("Day1Input.txt"), 2020) == 259716L)
  }

  test("Day1.part2") {
    assert(Day1.part2(Array(1721, 979, 366, 299, 675, 1456), 2020) == 241861950L)
    assert(Day1.part2(Day1.readAndSortLines("Day1Input.txt"), 2020) == 120637440L)
  }
}
