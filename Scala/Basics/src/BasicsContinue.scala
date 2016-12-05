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

  def main(args: Array[String]) = {
    demoApplySyntaxSugar()
    demoObjectSingleton()
    demoObject()
    demoFuncObjectClass()
    demoPackageUsage()
  }
}
