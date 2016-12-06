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

- type inference

**Variance**

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

**Bounds**

`[T <: Animal]`: T must be a subtype of Animal. 

**Quantification**

```scala
def count2(l: List[_]) = l.size
def countWholeThing(l: List[T forSome {type T}]) = l.size
```

>  roughly, defining something for some unnamed type

- views

##Collection Traits

These are all traits, both the mutable and immutable packages have implementations of these as well as specialized implementations.
You can easily move between Java and Scala collection types using conversions that are available in the 
[JavaConverters](http://www.scala-lang.org/api/current/index.html#scala.collection.JavaConverters$) package. 
It decorates commonly-used Java collections with `asScala` methods and Scala collections with `asJava` methods.


###Traversable

All of these methods below are available all the way down. The argument and return types types won’t always look the same as subclasses are free to override them.

- basic

```scala
def head : A
def tail : Traversable[A]
```

- functional components

```scala
def map [B] (f: (A) => B) : CC[B]
def foreach[U](f: Elem => U): Unit
def find (p: (A) => Boolean) : Option[A]
def filter (p: (A) => Boolean) : Traversable[A]
def partition (p: (A) ⇒ Boolean) : (Traversable[A], Traversable[A])
def groupBy [K] (f: (A) => K) : Map[K, Traversable[A]]
```

- conversion

```scala
def toArray : Array[A]
def toArray [B >: A] (implicit arg0: ClassManifest[B]) : Array[B]
def toBuffer [B >: A] : Buffer[B]
def toIndexedSeq [B >: A] : IndexedSeq[B]
def toIterable : Iterable[A]
def toIterator : Iterator[A]
def toList : List[A]
def toMap [T, U] (implicit ev: <:<[A, (T, U)]) : Map[T, U]
def toSeq : Seq[A]
def toSet [B >: A] : Set[B]
def toStream : Stream[A]
def toString () : String
def toTraversable : Traversable[A]
```

###Iterable

not used a lot, since java-esque...

- basics

```scala
def iterator: Iterator[A]
```

```scala
def hasNext(): Boolean
def next(): A
```

###Seq

Sequence of items with ordering.

###Set

A collection of items with no duplicates.

```scala
  def contains(key: A): Boolean
  def +(elem: A): Set[A]
  def -(elem: A): Set[A]
```

###Map

What is `->` ? That isn’t special syntax, it’s a method that returns a Tuple.

###Commonly-Used Subclasses

- HashSet and HashMap Quick lookup, the most commonly used forms of these collections. 
- TreeMap A subclass of SortedMap, it gives you ordered access. 
- Vector Fast random selection and fast updates. 
- Range Ordered sequence of Ints that are spaced apart. You will often see this used where a counting for-loop was used before. 

###Some Descriptive Traits
 
> IndexedSeq fast random-access of elements and a fast length operation.  
> LinearSeq fast access only to the first element via head, but also has a fast tail operation. 

- Mutable vs. Immutable
    - Pros: Can’t change in multiple threads
    - Cons: Can’t change at all


##Attention

- `_` represents for wildcard