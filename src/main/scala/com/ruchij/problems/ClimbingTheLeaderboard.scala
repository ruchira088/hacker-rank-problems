package com.ruchij.problems

import scala.annotation.tailrec
import scala.reflect.ClassTag

object ClimbingTheLeaderboard {

  def climbingLeaderboard(ranked: Array[Int], player: Array[Int]): Array[Int] = {
    val distinct = myDistinct(ranked)

    player.map(findIndexForElement(distinct, _)).map(_ + 1)
  }

  private[problems] def myDistinct[A: ClassTag](values: Array[A]): Array[A] = {

    val (vector, _) = values.foldLeft[(Vector[A], Option[A])](Vector.empty, None) {
      case ((iterable, None), element) => (iterable :+ element, Some(element))

      case ((iterable, Some(previous)), element) =>
        if (previous == element) (iterable, Some(previous)) else (iterable :+ element, Some(element))
    }

    vector.toArray[A]
  }

  private[problems] def findIndexForElement[A: Ordering](values: Array[A], element: A): Int =
    findIndexForElement(values, element, 0, values.length)

  @tailrec
  private def findIndexForElement[A: Ordering](values: Array[A], element: A, start: Int, end: Int): Int =
    if (start == end) start
    else {
      val midPointIndex = (start + end) / 2
      val midPointValue = values(midPointIndex)

      if (Ordering[A].gt(midPointValue, element))
        findIndexForElement(values, element, midPointIndex + 1, end)
      else if (Ordering[A].lt(midPointValue, element))
        findIndexForElement(values, element, start, midPointIndex)
      else midPointIndex
    }

}
