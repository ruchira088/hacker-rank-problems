package com.ruchij.problems

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers

class ClimbingTheLeaderboardSpec extends AnyFlatSpec with Matchers {

  "myDistinct" should "only return iterable with distinct items" in {
    ClimbingTheLeaderboard.myDistinct(Array(1, 1, 2, 3, 4)) mustBe Array(1, 2, 3, 4)
    ClimbingTheLeaderboard.myDistinct(Array(1, 1, 1, 1)) mustBe Array(1)
    ClimbingTheLeaderboard.myDistinct(Array.empty) mustBe Array.empty
  }

  "findIndexForElement" should "return the index where the element should fit" in {
    ClimbingTheLeaderboard.findIndexForElement(Array(6, 4, 3), 5) mustBe 1
    ClimbingTheLeaderboard.findIndexForElement(Array(), 2) mustBe 0
    ClimbingTheLeaderboard.findIndexForElement(Array(6, 4, 3), 2) mustBe 3
    ClimbingTheLeaderboard.findIndexForElement(Array(6, 4, 1), 2) mustBe 2
  }

  "climbingLeaderboard" should "return the position of the player after each round" in {
    ClimbingTheLeaderboard.climbingLeaderboard(Array(100, 100, 50, 40, 40, 20, 10), Array(5, 25, 50, 120)) mustBe
      Array(6, 4, 2, 1)

    ClimbingTheLeaderboard.climbingLeaderboard(Array(100, 90, 90, 80, 75, 60), Array(50, 65, 77, 90, 102)) mustBe
      Array(6, 5, 4, 2, 1)

  }

}
