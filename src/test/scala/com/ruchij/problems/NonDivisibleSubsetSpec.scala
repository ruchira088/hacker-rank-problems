package com.ruchij.problems

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers

class NonDivisibleSubsetSpec extends AnyFlatSpec with Matchers {

  "nonDivisibleSubset" should "return the expected result" in {
//    NonDivisibleSubset.nonDivisibleSubset(7, Array(278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436)) mustBe 11
//    NonDivisibleSubset.nonDivisibleSubset(9, Array(422346306, 940894801, 696810740, 862741861, 85835055, 313720373)) mustBe 5
//    NonDivisibleSubset.nonDivisibleSubset(5, Array(2, 7, 12, 17, 22)) mustBe 5
    NonDivisibleSubset.nonDivisibleSubset(4, Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)) mustBe 5
  }

}
