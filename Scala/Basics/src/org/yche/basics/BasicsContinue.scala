package org.yche.basics

/**
  * Created by cheyulin on 12/5/16.
  */
object BasicsContinue {

  //apply methods give you a nice syntactic sugar for when a class or object has one main use.
  class Foo {}

  object FooMaker {
    def apply() = new Foo()
  }

  def demoApplySyntaxSugar() = {
    val newFoo = FooMaker()
    println(newFoo.isInstanceOf[Foo])
  }

  //Objects are used to hold single instances of a class. Often used for factories.
  object Timer {
    var count = 0

    def currentCount: Long = {
      count += 1
      count
    }
  }

  def demoObjectSingleton() = {
    println(Timer.currentCount)
    println(Timer.currentCount)
  }

  //Classes and Objects can have the same name.
  // The object is called a ‘Companion Object’. We commonly use Companion Objects for Factories.

  class Bar(foo: String) {
    def printName() = println(foo)
  }

  //Factory
  object Bar {
    def apply(foo: String) = new Bar(foo)
  }

  def demoObject() = {
    Bar("user0").printName()
    Bar("user1").printName()
  }

  // Use syntax sugar, rather than Function1[Int, Int]
  object addOne extends ((Int) => Int) {
    def apply(m: Int): Int = m + 1
  }

  class AddOne extends ((Int) => Int) {
    def apply(m: Int): Int = m + 1
  }

  def demoFuncObjectClass() = {
    println(addOne(55))
    println(new AddOne()(55))
  }

  def demoPackageUsage() = {
    println("the color is " + org.yche.example.colorHolder.BLUE)
  }

  def demoPatMatch() = {
    def matchFunc(i: Int) = {
      i match {
        case i if i == 1 => "one"
        case i if i == 2 => "two"
        case _ => "some other words"
      }
    }

    val myList = List(1, 2, 3)
    var resList = myList.map(matchFunc(_))
    println(resList)

    println()

    def bigger(o: Any): Any = {
      o match {
        case i: Int if i < 0 => i - 1
        case i: Int => i + 1
        case d: Double if d < 0.0 => d - 0.1
        case d: Double => d + 0.1
        case text: String => text + " your string"
      }
    }

    val MyList = List[Any](-1, 2, -0.5, 0.5, "Hello")
    MyList.foreach((o: Any) => println(bigger(o)))


    def calcType(calc: Calculator) = calc match {
      case _ if calc.brand == "HP" && calc.model == "20GB" => "finicial"
      case _ => "Unknow"
    }

    val calc0 = Calculator("HP", "20GB")
    println(calcType(calc0))
    println(calcType(Calculator("fds", "dsa")))
    println()
  }

  class Calculator(str0: String, str1: String) {
    val brand = str0
    val model = str1
  }

  object Calculator {
    def apply(str0: String, str1: String): Calculator = new Calculator(str0, str1)
  }

  case class CaseCalculator(brand: String, model: String)


  def demoCaseClass() = {
    val hp20b = CaseCalculator("HP", "20b")

    def calcType(calc: CaseCalculator) = calc match {
      case CaseCalculator("HP", "20B") => "financial"
      case CaseCalculator("HP", "48G") => "scientific"
      case CaseCalculator("HP", "30B") => "business"
      case CaseCalculator(ourBrand, ourModel) => "Calculator: %s %s is of unknown type".format(ourBrand, ourModel)
    }

    val brandList = List[String]("HP", "HP", "HP", "HP")
    val modelList = List[String]("20B", "48G", "30B", "Test")
    val pairList = brandList.zip(modelList)

    pairList.map((myPair: (String, String)) => CaseCalculator(myPair._1, myPair._2)).map(calcType(_)).foreach((retStr: String) => println(retStr))
  }

  def main(args: Array[String]) = {
    demoApplySyntaxSugar()
    demoObjectSingleton()
    demoObject()
    demoFuncObjectClass()
    demoPackageUsage()
    demoPatMatch()
    demoCaseClass()
  }
}
