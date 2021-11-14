package com.ruchij.problems

object NonDivisibleSubset {

  def nonDivisibleSubset(divisor: Int, array: Array[Int]): Int = {
    val grouped: List[(Int, Int)] =
      array
        .groupBy(int => int % divisor)
        .map { case (remainder, values) => remainder -> values.distinct.length }
        .toList
        .sortBy {
          case (_, length) => -length
        }

    grouped match {
      case (0, _) :: Nil => 1

      case _ =>
        grouped.foldLeft(Set.empty[(Int, Int)]) {
          case (acc, value @ (remainder, _)) =>
            if (acc.exists { case (rem, _) => (rem + remainder) % divisor == 0 })
              acc
            else if (remainder == 0 || remainder * 2 == divisor)
              acc ++ Set(remainder -> 1)
            else
              acc + value
        }
          .toList
          .map {
            case (_, size) => size
          }
          .sum
    }
  }
}
