package com.ruchij.problems

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers

class SockMerchantSpec extends AnyFlatSpec with Matchers {

  "sockMerchant" should "return the correct number of socks" in {
    SockMerchant.sockMerchant(7, Array(1, 2, 1, 2, 1, 3, 2)) mustBe 2
    SockMerchant.sockMerchant(9, Array(10, 20, 20, 10, 10, 30, 50, 10, 20)) mustBe 3
  }

}
