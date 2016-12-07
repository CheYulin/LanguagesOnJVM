#Graph Lib Study
##Link

- [scala-graph user-guide](http://www.scala-graph.org/guides/core-introduction.html)
- [scala-graph download](http://www.scala-graph.org/download/)
- [scala-graph github](https://github.com/scala-graph/scala-graph)

##Notations

- Measurements

```scala
g.order                     // Int = 5 
g.graphSize                 // Int = 8
g.size                      // Int = 13
g.totalDegree               // Int = 16 
g.degreeSet                 // TreeSet(4, 3, 2)
g.degreeNodeSeq(g.InDegree) // List((4,3), (3,5), (2,1), (2,4), (2,2))
g.degreeNodesMap            // Map(2->Set(2), 3->Set(5,1), 4->Set(3,4))
g.degreeNodesMap(degreeFilter = _ > 3)  // Map(4 -> Set(3,4))
```

- Classification

```scala
val g = Graph(1, 2~>3) 
g.isConnected                   // false 
(g + 2~>1).isConnected          // true
(g get 2).findConnected(_ == 3) // Some(3)
g.isCyclic                      // false
(g + 3~>2).isCyclic             // true
g.isComplete                    // false 
(g ++ List(1~>2, 1~>3, 2~>1, 3~>1, 3~>2)).isComplete // true
g.isDirected                    // true 
g.isHyper                       // false 
g.isMulti                       // false 
```