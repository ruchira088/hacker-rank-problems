package com.ruchij.problems

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers

class ContainerBallSwapSpec extends AnyFlatSpec with Matchers {

  "ContainerBallSwap.run" should "return the result" in {
    ContainerBallSwap.run(Array(Array(0, 2, 1), Array(1, 1, 1), Array(2, 0, 0))) mustBe "Possible"
    ContainerBallSwap.run(Array(Array(1, 3, 1), Array(2, 1, 2), Array(3, 3, 3))) mustBe "Impossible"

    ContainerBallSwap.run(
      Array(
        Array(97, 98),
        Array(96, 97)
      )
    ) mustBe "Possible"
  }

}
