package org.yche.collection

/**
  * Created by cheyulin on 12/6/16.
  */
object CollectionsReview {

  def demoBasics() = {
    println(List(1, 2, 3))
    println(1 :: 2 :: 3 :: Nil)

    println(Set(1, 1, 2))

    //(Notice that returned a List. Seq is a trait;
    // List is a lovely implementation of Seq. There’s a factory object Seq which, as you see here, creates Lists.)
    println(Seq(1, 3, 2))

    // -> is a function ....
    println(Map('a' -> (1), 'b' -> (2)))

    println(Map(("a", 2), ("b", 2)))
  }

  def demoHierarchy() = {
    val arr = Map(1 -> "one", 2 -> "two").toArray
    arr.foreach((pair: (Int, String)) => println(pair._1.toString + " " + pair._2))
  }

  def demoCommonUsed() = {
    //Vector Usage
    val vector = IndexedSeq(1, 4, 5)

    //Range Usage
    println(vector.indices)
    for (i <- vector.indices) {
      println(vector(i))
    }

    // i think <- is a function to...
    for (i <- 1 to 3) {
      println(i)
    }

    println((1 to 3).map(i => i * i))
  }

  def demoMutable() = {
    val numbers = collection.mutable.Map(1 -> "one")
    println(numbers.get(1))
    println(numbers.getOrElseUpdate(2, "two"))
    println(numbers)
    numbers += (4 -> "four")
    println(numbers)
  }


  def main(args: Array[String]): Unit = {
    demoBasics()
    demoHierarchy()
    demoCommonUsed()
    demoMutable()
  }
}
