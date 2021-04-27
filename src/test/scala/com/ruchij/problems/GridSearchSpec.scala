package com.ruchij.problems

import com.ruchij.problems.GridSearch.Outcome
import com.ruchij.problems.GridSearchSpec.GridHelper
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers

class GridSearchSpec extends AnyFlatSpec with Matchers {

  "findIndexes" should "return the encountered indexes" in {
    GridSearch.findIndexes("hello world", "l", 0) mustBe List(2, 3, 9)

    GridSearch.findIndexes("hi", "a", 0) mustBe List.empty
  }

  "hasMatch" should "return true if there is a match" in {
    GridSearch.hasMatch(0 -> 0, List.empty, List.empty) mustBe true

    GridSearch.hasMatch(0 -> 2, List("abcd", "efgh"), List("cd", "gh")) mustBe true

    GridSearch.hasMatch(0 -> 0, List("abcd", "efgh"), List("cd", "gh")) mustBe false
  }

  "gridSearch" should "return if the pattern exists or not" in {
    GridSearch.gridSearch(
      grid"""
            1234567890
            0987654321
            1111111111
            1111111111
            2222222222
          """,
      grid"""
            876543
            111111
            111111
          """
    ) mustBe Outcome.YES.toString

    GridSearch.gridSearch(
      grid"""
            1234567890
            0987654321
            1111111111
            1111111111
            2222222222
          """,
      grid"""
            876543
            11d111
            111111
          """
    ) mustBe Outcome.NO.toString

    GridSearch.gridSearch(
      grid"""
            1234
            5678
            1234
            5670
          """,
      grid"""
            234
            670
          """
    ) mustBe Outcome.YES.toString
  }

}

object GridSearchSpec {
  implicit class GridHelper(val stringContext: StringContext) extends AnyVal {
    def grid(args: Any*): Array[String] =
      stringContext.s(args: _*).split("\n").map(_.trim).filter(_.nonEmpty)
  }
}
