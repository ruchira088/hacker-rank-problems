package com.ruchij.problems

import com.ruchij.problems.AlmostSorted.SortOperation.{AlreadySorted, CannotBeSorted, Reverse, Swap}

import scala.annotation.tailrec

object AlmostSorted {
  sealed trait SortOperation {
    val pretty: String
  }

  object SortOperation {
    case object AlreadySorted extends SortOperation {
      override val pretty: String = "yes"
    }

    case object CannotBeSorted extends SortOperation {
      override val pretty: String = "no"
    }

    case class Swap(first: Int, second: Int) extends SortOperation {
      override val pretty: String =
        s"""yes
          |swap $first $second""".stripMargin
    }

    case class Reverse(start: Int, end: Int) extends SortOperation {
      override val pretty: String =
      s"""yes
        |reverse $start $end""".stripMargin
    }
  }

  def almostSorted(array: Array[Int]): Unit =
    println {
      sort(array.toVector).pretty
    }

  def sort(vector: Vector[Int]): SortOperation =
    sortOperation {
      vector.zip(mergeSort(vector)).zipWithIndex.collect {
        case ((value, sortedValue), index) if value != sortedValue => (index + 1) -> (value, sortedValue)
      }
    }

  def sortOperation(diffs: Vector[(Int, (Int, Int))]): SortOperation =
    diffs match {
      case Vector() => AlreadySorted

      case Vector((a, (a1, a2)), (b, (b1, b2))) if a1 == b2 && a2 == b1 => Swap(a, b)

      case values =>
        val input = values.map { case (_, (a, _)) =>  a }.reverse
        val sorted = values.map { case (_, (_, b)) => b }

        if (input.zip(sorted).forall { case (a, b) => a == b }) {
            values.headOption.flatMap {
              case (start, _) =>
                values.lastOption.map {
                  case (end, _) => Reverse(start, end)
                }
            }
            .getOrElse(CannotBeSorted)
        } else CannotBeSorted
    }

  def mergeSort(vector: Vector[Int]): Vector[Int] =
    if (vector.length <= 1)
      vector
    else {
      val (first, second) = vector.splitAt(vector.size / 2)

      merge(mergeSort(first), mergeSort(second), Vector.empty)
    }

  @tailrec
  private def merge(one: Vector[Int], two: Vector[Int], result: Vector[Int]): Vector[Int] =
    (one.headOption, two.headOption) match {
      case (None, _) => result ++ two

      case (_, None) => result ++ one

      case (Some(first), Some(second)) if first <= second => merge(one.tail, two, result :+ first)

      case (_, Some(second)) => merge(one, two.tail, result :+ second)
    }

}
