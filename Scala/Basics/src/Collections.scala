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
    val myFuncMap = Map("timesTwo" -> {
      timesTwo(_)
    })

  }

  //Similar to the usage in Python
  def demoFunctional() = {
    val myList = List(1, 2, 3, 4)
    val newList = myList.map((i: Int) => i * i)
    newList.foreach((i: Int) => println(i))
    val filteredList = newList.filter((i: Int) => i % 2 == 0)
    filteredList.foreach((i: Int) => println(i))
  }

  def main(args: Array[String]) = {
    demoCollections()
    demoFunctional()
  }
}
