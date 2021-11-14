package com.ruchij.problems

import scala.annotation.tailrec
import scala.collection.Factory

object BiggerIsGreater {

  val charMap: Map[Char, Int] = Range(0, 26).map(int => (int + 'a').toChar -> int).toMap
  val intMap: Map[Int, Char] = charMap.map { case (char, int) => int -> char }

  def biggerIsGreater(word: String): String =
    nextBigger(quantify(word).toList).map(stringify).getOrElse("no answer")

  def quantify(word: String): Seq[Int] = word.flatMap(charMap.get)

  def stringify(values: Seq[Int]): String = values.flatMap(intMap.get).mkString

  def nextBigger(value: List[Int]): Option[List[Int]] = nextBigger(value, List.empty)

  @tailrec
  private def nextBigger(input: List[Int], earlier: List[Int]): Option[List[Int]] =
    input.lastOption match {
      case None => None

      case Some(value) if earlier.exists(_ > value) =>
        earlier.filter(_ > value).minOption.map { next => (input.init :+ next) ++ (value :: removeFromList(earlier, next)).sorted }

      case Some(value) => nextBigger(input.init, value :: earlier)
    }

  def removeFromList[Itr[x] <: Iterable[x], A](iterable: Itr[A], value: A)(implicit factory: Factory[A, Itr[A]]): Itr[A] =
    factory.fromSpecific {
      val (list, _) = iterable.foldLeft((List.empty[A], false)) {
        case ((list, done), current) => if (done || current != value) (current :: list, done) else (list, true)
      }

      list.reverse
    }

}
