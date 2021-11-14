package com.ruchij.problems

object ContainerBallSwap {

  def run(container: Array[Array[Int]]): String = {
    val containers: Array[Array[Long]] = container.map(_.map(_.toLong))

    val containerSizes: Set[Long] = containers.map(_.sum).toSet

    val ballTypeCounts: Vector[Long] =
      containers.indices.foldLeft(Vector.empty[Long]) {
        (count, ballType) => count :+ containers.map(_.apply(ballType)).sum
      }

    if (ballTypeCounts.forall(containerSizes.contains)) "Possible" else "Impossible"
  }


}
