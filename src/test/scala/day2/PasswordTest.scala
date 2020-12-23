package com.blakekhan.adventofcode2020
package day2

import org.scalatest.funsuite.AnyFunSuite

class PasswordTest extends AnyFunSuite {
  test("Password.isValid") {
    // Part 1 Validation Policy
    assert(Password(1, 3, 'a', "abcde").isValid(ValidationPolicyType.MIN_MAX_COUNT))
    assert(!Password(1, 3, 'b', "cdefg").isValid(ValidationPolicyType.MIN_MAX_COUNT))
    assert(Password(2, 9, 'c', "ccccccccc").isValid(ValidationPolicyType.MIN_MAX_COUNT))
    assert(Password(14, 15, 't', "tttttttttttnztttg").isValid(ValidationPolicyType.MIN_MAX_COUNT))

    // Part 2 Validation Policy
    assert(Password(1, 3, 'a', "abcde").isValid(ValidationPolicyType.INDEX))
    assert(!Password(1, 3, 'b', "cdefg").isValid(ValidationPolicyType.INDEX))
    assert(!Password(2, 9, 'c', "ccccccccc").isValid(ValidationPolicyType.INDEX))
    assert(!Password(14, 15, 't', "tttttttttttnztttg").isValid(ValidationPolicyType.INDEX))
  }
}
