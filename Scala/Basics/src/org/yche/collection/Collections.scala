package org.yche.collection

/**
  * Created by cheyulin on 12/4/16.
  */
object Collections {
  def demoCollections() = {
    val numbersArray = Array(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)
    val numbersList = List(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)
    val numbersSet = Set(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)
    val hostPortTuple = ("localhost", 80)
    println(hostPortTuple._1)
    println(hostPortTuple._2)
    Map(1 -> 2)
    Map("foo" -> "bar")
    Map(1 -> Map("foo" -> "bar"))
    def timesTwo(x: Int): Int = x * 2

    // partial apply, not difficult
    val myFuncMap = Map("timesTwo" -> {
      timesTwo(_)
    })

    println(myFuncMap("timesTwo")(55))

    val numbersMap = Map("one" -> 1, "two" -> 2)
    val res0 = numbersMap.get("two")
    val res1 = numbersMap.get("three")
    def patMachFunc(x: Option[Int]) = if (x.isDefined) {
      x.get * 2
    } else {
      0
    }

    println(patMachFunc(res0))
    println(patMachFunc(res1))

    def usePatMatchFunc(x: Option[Int]): Int = {
      x match {
        case Some(n) => n * 2
        case None => 0
      }
    }

    println(usePatMatchFunc(res0))
    println(usePatMatchFunc(res1))
    println()
  }

  //Similar to the usage in Python
  def demoFunctional() = {
    val myList = List(1, 2, 3, 4)
    val newList = myList.map((i: Int) => i * i)
    newList.foreach((i: Int) => println(i))

    val filteredList = newList.filter((i: Int) => i % 2 == 0)
    filteredList.foreach((i: Int) => println(i))

    val aggragatedList = List(1, 2, 3).zip(List("a", "b", "c"))
    aggragatedList.foreach((p: (Int, String)) => println(p._1.toString + "," + p._2))

    val numbersList = List(1, 2, 3, 4, 5, 6, 7, 8)
    val partitionList = numbersList.partition(_ % 2 == 0)
    println(partitionList._1)
    println(partitionList._2)

    val findRes = numbersList.find((i: Int) => i > 5) match {
      case Some(n) => n * 10
      case None => -1
    }
    println(findRes)

    //Drop first 5 elements
    var resList = numbersList.drop(5)
    println(resList)

    resList = numbersList.dropWhile(_ % 2 != 0)
    println(resList)
  }


  def main(args: Array[String]) = {
    demoCollections()
    demoFunctional()
  }
}
