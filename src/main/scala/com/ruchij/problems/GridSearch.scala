package com.ruchij.problems


object GridSearch {
  sealed trait Outcome

  object Outcome {
    case object YES extends Outcome
    case object NO extends Outcome
  }

  def gridSearch(input: Array[String], pattern: Array[String]): String =
    pattern.headOption.fold[String](Outcome.YES.toString) {
      line =>
        exists(findMatch(input.toList, 0, line), input.toList, pattern.toList).toString
    }

  private def exists(origins: List[(Int, Int)], input: List[String], pattern: List[String]): Outcome =
    origins match {
      case Nil => Outcome.NO

      case origin :: rest =>
          if (hasMatch(origin, input, pattern)) Outcome.YES
          else exists(rest, input, pattern)
    }

  private[problems] def hasMatch(origin: (Int, Int), input: List[String], pattern: List[String]): Boolean =
    pattern match {
      case Nil => true

      case head :: tail =>
        val (y, x) = origin

        input.drop(y).headOption.exists { line => line.drop(x).take(head.length) == head } &&
          hasMatch((y + 1) -> x, input, tail)
    }

  private def findMatch(input: List[String], lineNumber: Int, line: String): List[(Int, Int)] =
    input match {
      case head :: tail =>
        findIndexes(head, line, 0).map(lineNumber -> _) ++ findMatch(tail, lineNumber + 1, line)

      case Nil => List.empty
    }

  private[problems] def findIndexes(input: String, pattern: String, offset: Int): List[Int] = {
    val index = input.indexOf(pattern)

    if (index == -1) List.empty else offset + index :: findIndexes(input.drop(index + 1), pattern, offset + index + 1)
  }

}
