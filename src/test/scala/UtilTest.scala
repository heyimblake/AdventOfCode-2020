package com.blakekhan.adventofcode2020

import org.scalatest.funsuite.AnyFunSuite

class UtilTest extends AnyFunSuite {
  test("Util.fileToStrList") {
    assert(Util.fileToStrList("day2/SamplePasswords.txt") == List[String](
      "1-3 a: abcde",
      "1-3 b: cdefg",
      "2-9 c: ccccccccc",
      "14-15 t: tttttttttttnztttg"
    ))

    assertThrows[NullPointerException](Util.fileToStrList(null))
  }
}
