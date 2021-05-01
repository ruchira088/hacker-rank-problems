package com.ruchij.problems

import com.ruchij.problems.AbsolutePermutationSpec.ArrayStringContext
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers

class AbsolutePermutationSpec extends AnyFlatSpec with Matchers {

  "range" should "return an array of numbers upto the limit" in {
    AbsolutePermutation.range(10, List.empty) mustBe List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  }

  "absolutePermutation" should "return the expected result" in {
    AbsolutePermutation.absolutePermutation(2, 1) mustBe Array(2, 1)
    AbsolutePermutation.absolutePermutation(3, 0) mustBe Array(1, 2, 3)
    AbsolutePermutation.absolutePermutation(3, 2) mustBe Array(-1)
    AbsolutePermutation.absolutePermutation(10, 5) mustBe Array(6, 7, 8, 9, 10, 1, 2, 3, 4, 5)
    AbsolutePermutation.absolutePermutation(10, 0) mustBe Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    AbsolutePermutation.absolutePermutation(94, 47) mustBe array"48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47"
    AbsolutePermutation.absolutePermutation(98, 7) mustBe array"8 9 10 11 12 13 14 1 2 3 4 5 6 7 22 23 24 25 26 27 28 15 16 17 18 19 20 21 36 37 38 39 40 41 42 29 30 31 32 33 34 35 50 51 52 53 54 55 56 43 44 45 46 47 48 49 64 65 66 67 68 69 70 57 58 59 60 61 62 63 78 79 80 81 82 83 84 71 72 73 74 75 76 77 92 93 94 95 96 97 98 85 86 87 88 89 90 91"
    AbsolutePermutation.absolutePermutation(100, 2) mustBe array"3 4 1 2 7 8 5 6 11 12 9 10 15 16 13 14 19 20 17 18 23 24 21 22 27 28 25 26 31 32 29 30 35 36 33 34 39 40 37 38 43 44 41 42 47 48 45 46 51 52 49 50 55 56 53 54 59 60 57 58 63 64 61 62 67 68 65 66 71 72 69 70 75 76 73 74 79 80 77 78 83 84 81 82 87 88 85 86 91 92 89 90 95 96 93 94 99 100 97 98"
  }
}

object AbsolutePermutationSpec {
  implicit class ArrayStringContext(val stringContext: StringContext) extends AnyVal {
    def array(args: Any*): Array[Int] =
      stringContext.s(args: _*).split(" ").map(_.toInt)
  }
}
