package com.ruchij.problems

object Encryption {

  def encryption(line: String): String = {
    val noSpaceLine: String = line.filter(!_.isSpaceChar)
    val sqrt: Double = Math.sqrt(noSpaceLine.length)

    val columns: Int = Math.ceil(sqrt).toInt
    val rows: List[String] = group(noSpaceLine, columns)

    inverse(rows).mkString(" ")
  }

  private def group(input: String, size: Int): List[String] =
    if (input.isEmpty) List.empty else input.take(size) :: group(input.drop(size), size)

  private def inverse(input: List[String]): IndexedSeq[String] =
    Range(0, input.headOption.map(_.length).getOrElse(0))
      .map {
        index =>
          input.map { string => string.applyOrElse[Int, Char](index, _ => ' ') }
      }
      .map(_.mkString.trim)

}
