/**
  * Created by cheyulin on 12/4/16.
  */

object BasicsFunctional {

  def demoValVar() = {
    val constantTwo = 1 + 1
    var variable = 1 + 1
    variable = 1 + 2
  }

  //Functional Style, which is trivial in Scheme, actually just simple concepts here
  def demoAnonymousFunc() = {
    println(((x: Int) => x + 1) (1))
    val addOneFunc = (x: Int) => {
      println("multiple lines:")
      x + 1
    }
    println(addOneFunc(1))
  }

  def demoPartialApply() = {
    def adder(left: Int, right: Int): Int = left + right
    def partial_adder = adder(2, _: Int)
    println(partial_adder(3))
  }

  //Inner function is the returne-value of  multiply, capture is similar to Scheme
  def demoCurry() = {
    def multipy(m: Int)(n: Int): Int = m * n
    // apply function returned by multiply(2) on 3
    println(multipy(2)(3))
  }

  //Similar to C++11 Varadic Template
  def demoVaradicArguments() = {
    def capitalizeAll(args: String*) = {
      args.map { arg =>
        arg.capitalize
      }
    }
    println(capitalizeAll("rarity", "applejack"))
  }

  def main(args: Array[String]) {
    demoValVar()
    demoAnonymousFunc()
    demoPartialApply()
    demoCurry()
    demoVaradicArguments()
  }
}
