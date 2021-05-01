package com.ruchij.problems

import com.ruchij.problems.AbsolutePermutationSpec.ArrayStringContext
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers

class AlmostSortedSpec extends AnyFlatSpec with Matchers {

  "mergeSort" should "sort the elements" in {
    AlmostSorted.mergeSort(Vector(4, 2, 5, 6, 2, 1)) mustBe Vector(1, 2, 2, 4, 5, 6)
  }

  "almostSorted" should "return the sort operations" in {
    AlmostSorted.almostSorted(array"1 5 4 3 2 6")
  }

}
