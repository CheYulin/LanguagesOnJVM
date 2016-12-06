#Notes

##Link

- [scala school](https://twitter.github.io/scala_school/index.html)

##Fold
- map could be implemented with fold

```scala
  def demoGeneralizedFunctionalCombinator() = {
    val numbers = List(1, 2, 3, 4)
    def ourMap(numbers: List[Int], fn: Int => Int): List[Int] = {
      numbers.foldRight(List[Int]()) {
        (x: Int, xs: List[Int]) => fn(x) :: xs
      }
    }

    println(ourMap(numbers, timesTwo(_)))
  }
```

##Type & Polymorphism Basics
- parametric polymorphism(generic programming, similar to template in C++)

> Scala’s type system has to account for class hierarchies together with polymorphism.
 Class hierarchies allow the expression of subtype relationships.
  A central question that comes up when mixing OO with polymorphism is: 
  if T’ is a subclass of T, is Container[T’] considered a subclass of Container[T]? 
Variance annotations allow you to express the following relationships between class hierarchies & polymorphic types:

table | meaning | scala notation
--- | --- | --- 
covariant | `C[T’]` is a subclass of `C[T]` | `[+T]`
contravariant | `C[T]` is a subclass of `C[T’]` | `[-T]`
invariant | `C[T]` and `C[T’]` are not related | `[T]`

- type inference

- existential quantification

>  roughly, defining something for some unnamed type

- views