package com.blakekhan.adventofcode2020
package day2

import org.scalatest.funsuite.AnyFunSuite

class Day2Test extends AnyFunSuite {

  // Part 1 Validation Policy
  test("Day2.countValidPasswords") {
    assert(Day2.countValidPasswords(List[Password](
      Password(1, 3, 'a', "abcde"),
      Password(1, 3, 'b', "cdefg"),
      Password(2, 9, 'c', "ccccccccc"),
      Password(14, 15, 't', "tttttttttttnztttg")
    ), ValidationPolicyType.MIN_MAX_COUNT) == 3)

    assert(Day2.countValidPasswords(Day2.readPasswordsFromFile("day2/Day2Input.txt"), ValidationPolicyType.MIN_MAX_COUNT) == 528)

    // Part 2 Validation Policy
    assert(Day2.countValidPasswords(List[Password](
      Password(1, 3, 'a', "abcde"),
      Password(1, 3, 'b', "cdefg"),
      Password(2, 9, 'c', "ccccccccc"),
      Password(14, 15, 't', "tttttttttttnztttg")
    ), ValidationPolicyType.INDEX) == 1)

    assert(Day2.countValidPasswords(Day2.readPasswordsFromFile("day2/Day2Input.txt"), ValidationPolicyType.INDEX) == 497)
  }

  test("Day2.readPasswordsFromFile") {
    assert(Day2.readPasswordsFromFile("day2/SamplePasswords.txt") ==
      List[Password](
        Password(1, 3, 'a', "abcde"),
        Password(1, 3, 'b', "cdefg"),
        Password(2, 9, 'c', "ccccccccc"),
        Password(14, 15, 't', "tttttttttttnztttg")
      )
    )

    assert(Day2.readPasswordsFromFile("day2/Day2Input.txt").size == 1000)
  }
}
