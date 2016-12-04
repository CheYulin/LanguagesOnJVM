/**
  * Created by cheyulin on 12/4/16.
  */
object BasicsOOP {

  //Constructors aren’t special methods, they are the code outside of method definitions in your class.
  // Let’s extend our Calculator example to take a constructor argument and use it to initialize internal state.
  class Calculator(brand: String) {
    val color: String = if (brand == "Ti") {
      "blue"
    }
    else if (brand == "HP") {
      "black"
    }
    else {
      "white"
    }

    def add(m: Int, n: Int): Int = m + n

  }


  class C {
    var acc = 0

    def method() = acc += 1

    def function() = () => acc += 1
  }

  def demoMethodFunc() = {
    val c = new C
    c.method()
    c.function()
    c.function()()
    println(c.acc)
  }

  // Effective Scala points out that a Type alias is better than extends if the subclass isn’t actually different from the superclass.
  // A Tour of Scala describes Subclassing.
  class ScientificCalculator(brand: String) extends Calculator(brand) {
    def log(m: Double, base: Double) = Math.log(m) / Math.log(base)
  }

  //Overloading
  class EvenMoreScientificCalculator(brand: String) extends ScientificCalculator(brand) {
    def log(m: Int): Double = log(m, math.exp(1))
  }

  //Abstract Class
  abstract class Shape {
    def getArea(): Int
  }

  class Circle(r: Int) extends Shape {
    override def getArea(): Int = r * r * 3
  }

  def demoAbstractClass() = {
    val s = new Circle(3)
    println(s.getArea())
  }

  //traits are collections of fields and behaviors that you can extend or mixin to your classes.

  def main(args: Array[String]) = {
    val calc = new Calculator("HP")
    println(calc.add(1, 2))
    println(calc.color)
    demoMethodFunc()
    demoAbstractClass()
  }
}


