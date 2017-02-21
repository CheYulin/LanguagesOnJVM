/**
  * Created by cheyulin on 2/21/17.
  */
object chapter2 {
  def demoIf(): Unit = {
    def demoIfInner(x: Int): Int = {
      val s = if (x > 0) 1
      else if (x == 0) 0
      else -1

      s + 1
    }

    val numbers = List(2, 0, -2)
    numbers.foreach((i: Int) => println(demoIfInner(i)))
  }

  def demoRangeFor(): Unit = {
    for (i <- 1 to 2) {
      println(i * i)
    }
    for (i <- 1 until 2) {
      println(i * i)
    }
    for (i <- 1 to 3; j <- 1 to 3 if i != j) {
      print((10 * i + j) + " ")
    }

    println()

    val myVec = for (i <- 1 to 5) yield i % 3
    println(myVec)
  }

  def demoFunction(): Unit = {
    def fac(n: Int) = {
      var r = 1
      for (i <- 1 to n) r *= i
      r
    }

    def recFac(n: Int): Int = if (n <= 0) 1 else n * recFac(n - 1)

    println(fac(5))
    println(recFac(5))
  }

  def demoVaradicParameter(): Unit = {
    def sum(args: Int*) = {
      var res = 0
      for (arg <- args) res += arg
      res
    }

    println(sum(1, 4, 9, 16, 25))
    println(sum((1 to 5).map((i: Int) => i * i): _*))
  }

  def main(args: Array[String]): Unit = {
    demoIf()
    demoRangeFor()
    demoFunction()
    demoVaradicParameter()
  }
}
