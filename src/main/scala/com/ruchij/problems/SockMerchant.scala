package com.ruchij.problems

object SockMerchant {
  def sockMerchant(count: Int, socks: Array[Int]): Int =
    socks.groupBy(identity)
      .map {
        case (_, values) => values.length / 2
      }
      .sum

}
