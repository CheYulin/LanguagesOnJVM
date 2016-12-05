#Notes
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