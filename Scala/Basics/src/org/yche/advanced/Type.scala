package org.yche.advanced

/**
  * Created by cheyulin on 12/6/16.
  */
object Type {
  def demoParametricPoly() = {
    val myList = 2 :: 1 :: "bar" :: "Foo" :: Nil
    println(myList)

    def dropFirstEle[A](l: List[A]) = l.tail

    var resList = dropFirstEle(myList)
    println(resList)

    resList = dropFirstEle(resList)
    println(resList)

    def toList[A](a: A) = List(a)
    println(toList("str"))
    println(toList(1))

    //all type variables have to be fixed at the invocation site
    //all type variable are resolved in compile-time, similar to C++ generic programming and template-meta-programming
    //types deduced requires to be consistent
  }

  def demoTypeInference() = {
    def identity[T](x: T) = x
    println(identity(1))
    println(identity("str"))
    println(identity(1.0))
    println()
  }

  class Animal {
    val sound = "rustle"
  }

  class Bird extends Animal {
    override val sound = "call"
  }

  class Chicken extends Bird {
    override val sound = "cluck"
  }

  def demoVariance() = {
    //The standard animal library has a function that does what you want, but it takes an Animal parameter instead.
    // In most situations, if you say “I need a ___, I have a subclass of ___”, you’re OK. But function parameters are contravariant.
    // If you need a function that takes a Bird and you have a function that takes a Chicken, that function would choke on a Duck.
    // But a function that takes an Animal is OK:
    val getTweet: (Bird => String) = (a: Animal) => a.sound

    //A function’s return value type is covariant.
    // If you need a function that returns a Bird but have a function that returns a Chicken, that’s great.
    val hatch: (() => Bird) = () => new Chicken
    println(getTweet(hatch()))
  }

  def demoBounds() = {
    
  }

  def main(args: Array[String]): Unit = {
    demoParametricPoly()
    demoTypeInference()
    demoVariance()
    demoBounds()
  }
}
