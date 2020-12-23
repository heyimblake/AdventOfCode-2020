package com.blakekhan.adventofcode2020
package day2

import scala.io.Source

object Day2 {

  /**
   * Counts the number of valid passwords.
   *
   * @param passwords  list of passwords to validate
   * @param policyType the policy to validate with
   * @return the number of valid passwords
   */
  def countValidPasswords(passwords: List[Password], policyType: ValidationPolicyType.Value): Int = {
    passwords.count(password => password.isValid(policyType))
  }

  /**
   * Reads passwords from a provided file.
   *
   * @param path the path of the file to read
   * @return list of passwords from the file
   */
  def readPasswordsFromFile(path: String): List[Password] = {
    assert(path != null)
    Source.fromResource(path).getLines.map[Password](line => {
      val nums: Array[String] = line.split("-")
      val numChar: Array[String] = nums(1).split(" ")
      val low: Int = nums(0).toInt
      val high: Int = numChar(0).toInt
      val c: Char = numChar(1).charAt(0)
      val pass: String = numChar(2)
      Password(low, high, c, pass)
    }).toList
  }
}
