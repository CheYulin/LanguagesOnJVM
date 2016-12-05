package org.yche.advanced

/**
  * Created by cheyulin on 12/5/16.
  */
object Function {
  def f(s: String): String = "f" + "(" + s + ")"

  def g(s: String): String = "g" + "(" + s + ")"


  def demoFuncComposition() = {
    val fgx = f _ compose g _
    println(fgx("test"))
    val gfx = g _ compose f _
    println(gfx("test2"))
  }

  def demoPartialFunction() = {
    // Similar to C++ std::function<R(Args...)>
    val one: PartialFunction[Int, String] = {
      case 1 => "one"
    }
    println(one.isDefinedAt(1))
    println(one.isDefinedAt(2))

    val two: PartialFunction[Int, String] = {
      case 2 => "two"
    }

    val three: PartialFunction[Int, String] = {
      case 3 => "three"
    }

    val wildcard: PartialFunction[Int, String] = {
      case _ => "something else"
    }

    val partialFunc = one orElse two orElse three orElse wildcard

    val myNumbers = List[Int](1, 2, 3, 4, 5)
    myNumbers.foreach((x: Int) => println(partialFunc(x)))

  }

  case class PhoneExt(name: String, ext: Int)

  //filter takes a function. In this case a predicate function of (PhoneExt) => Boolean.
  //  A PartialFunction is a subtype of Function so filter can also take a PartialFunction!
  def demoCaseClass() = {
    val extensions = List(PhoneExt("steve", 100), PhoneExt("robey", 200))
    println(extensions.filter({ case PhoneExt(name, extension) => extension < 200 }))
  }

  def main(args: Array[String]) = {
    demoFuncComposition()
    demoPartialFunction()
    demoCaseClass()
  }
}
