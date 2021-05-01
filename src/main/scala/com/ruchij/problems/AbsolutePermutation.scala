package com.ruchij.problems

import scala.annotation.tailrec
import scala.collection.mutable

object AbsolutePermutation {

  def absolutePermutation(limit: Int, diff: Int): Array[Int] =
    run(findMatch(range(limit, List.empty), diff, limit), mutable.Set.empty, List.empty).toArray

  @tailrec
  def run(values: List[List[Int]], used: mutable.Set[Int], result: List[Int]): List[Int] =
    values match {
      case head :: tail =>
        head.find(value => !used.contains(value)) match {
          case None => List(-1)

          case Some(value) =>
            used.add(value)
            run(tail, used, value :: result)
        }

      case Nil => result.reverse
    }

  def findMatch(values: List[Int], diff: Int, size: Int): List[List[Int]] =
    values
      .map { value =>
        List(value - diff, value + diff).filter(value => value > 0 && value <= size)
      }

  @tailrec
  def range(value: Int, result: List[Int]): List[Int] =
    if (value == 0) result else range(value - 1, value :: result)

}
