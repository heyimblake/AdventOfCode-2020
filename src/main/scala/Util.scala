package com.blakekhan.adventofcode2020

import scala.io.Source

object Util {

  /**
   * Reads a file and puts each row as an element in a list
   *
   * @param path the path of the file to read
   * @return 1d list of file contents
   */
  def fileToStrList(path: String): List[String] = {
    if (path == null) {
      throw new NullPointerException
    }
    Source.fromResource(path).getLines().toList
  }
}
