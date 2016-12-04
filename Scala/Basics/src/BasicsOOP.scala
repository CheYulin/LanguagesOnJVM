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


  def main(args: Array[String]) = {
    val calc = new Calculator("HP")
    println(calc.add(1, 2))
    println(calc.color)
  }

}


