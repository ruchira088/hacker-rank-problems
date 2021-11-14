package com.ruchij.problems

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers

class BiggerIsGreaterSpec extends AnyFlatSpec with Matchers {

  "BiggerIsGreater.nextSmallest" should "return result" in {
    BiggerIsGreater.nextBigger(List(1, 2, 3, 4)) mustBe Some(List(1, 2, 4, 3))
    BiggerIsGreater.nextBigger(List(1, 2, 2, 2)) mustBe Some(List(2, 1, 2, 2))
    BiggerIsGreater.nextBigger(List(3, 2, 1)) mustBe None
    BiggerIsGreater.nextBigger(List(3, 1, 2)) mustBe Some(List(3, 2, 1))
    BiggerIsGreater.nextBigger(List(5, 6, 2)) mustBe Some(List(6, 2, 5))
    BiggerIsGreater.nextBigger(List(5, 6, 2, 1)) mustBe Some(List(6, 1, 2, 5))
    BiggerIsGreater.nextBigger(List(5, 7, 6, 1)) mustBe Some(List(6, 1, 5, 7))
  }

  "BiggerIsGreater.biggerIsGreater" should "return the correct result" in {
    BiggerIsGreater.biggerIsGreater("abcd") mustBe "abdc"
    BiggerIsGreater.biggerIsGreater("bb") mustBe "no answer"
    BiggerIsGreater.biggerIsGreater("hefg") mustBe "hegf"
    BiggerIsGreater.biggerIsGreater("dhck") mustBe "dhkc"
    BiggerIsGreater.biggerIsGreater("dkhc") mustBe "hcdk"
  }

  "removeFromList" should "remove element from the list" in {
    BiggerIsGreater.removeFromList(List(1, 2, 3, 4), 3) mustBe List(1, 2, 4)
    BiggerIsGreater.removeFromList(List(1, 2, 3, 3, 4), 3) mustBe List(1, 2, 3, 4)
  }

}
