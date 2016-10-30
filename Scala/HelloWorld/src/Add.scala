/**
  * Created by cheyulin on 10/30/16.
  * Study Material From http://www.runoob.com/scala
  */


object Add {
  def addInt(a: Int, b: Int): Int = {
    var sum: Int = 0
    sum += a + b
    return sum
  }

  def main(args: Array[String]): Unit = {
    //Function Demo
    println(addInt(1, 4))

    //Closure
    val multiplier = (i: Int) => i * 10
    println(multiplier(10))

    //Closure Capture Global Variable Demo
    var factor = 3
    val multiplier1 = (i: Int) => i * factor
    println(multiplier1(10))


    //String & StringBuilder Demo
    val greeting: String = "Hello,World!"
    println(greeting)
    val stringBuilder = new StringBuilder
    stringBuilder += 'a'
    stringBuilder ++= "bcdef"
    stringBuilder ++= "gh"
    println("string is " + stringBuilder.toString() + ",len:" + stringBuilder.toString().length)

    //Array Demo
    var my_arr: Array[String] = new Array[String](3)
    my_arr(0) = "abc"
    my_arr(1) = "def"
    my_arr(2) = "ghi"
    for (x <- my_arr) {
      println(x)
    }

    for (i <- 0 to (my_arr.length - 1)) {
      println(my_arr(i))
    }

    //Collection Demo
    val my_list = List(3, 2, 1, 4)
    for (ele <- my_list) {
      print(ele)
    }
    println()

    var my_set = Set(3, 2, 1, 4)
    for (ele <- my_set) {
      print(ele)
    }
    println()

    val my_map = Map("one" -> 1, "two" -> 2, "three" -> 3)
    for (ele <- my_map) {
      print(ele._1)
      print(ele._2)
    }
    println()

    val my_tuple = (10, "Runoob")
    println(my_tuple)
    val x: Option[Int] = Some(5)

  }
}
