package com.blakekhan.adventofcode2020
package day2

case class Password(low: Int, high: Int, letter: Char, pass: String) {

  /**
   * Checks if this password is valid according to a specified validation policy.
   * @param policyType the type of policy to validate with
   * @return `true` if password is valid, `false` otherwise
   */
  def isValid(policyType: ValidationPolicyType.Value): Boolean = {
    if (policyType == ValidationPolicyType.MIN_MAX_COUNT) {
      val count: Int = pass.count(c => c == letter)
      count >= low && count <= high
    } else {
      try {
        (pass.charAt(low - 1) == letter && pass.charAt(high - 1) != letter) || (pass.charAt(low - 1) != letter && pass.charAt(high - 1) == letter)
      } catch {
        case _: IndexOutOfBoundsException => false
      }
    }
  }
}
