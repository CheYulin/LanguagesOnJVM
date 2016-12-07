package org.yche.demo

import scalax.collection.Graph, scalax.collection.GraphPredef._, scalax.collection.GraphEdge._

/**
  * Created by cheyulin on 12/7/16.
  */
object GraphLibDemo {

  def demoInitGraph() = {
    val g1 = Graph(3 ~ 1, 5)
    val g2 = Graph(UnDiEdge(3, 1), 5)
    val gA = Graph(3 ~> 1.2)
    val h = Graph(1 ~ 1, 1 ~ 2 ~ 3)

    val nodes = List(5)
    val edges = List(3 ~ 1)
    val g3 = Graph.from(nodes, edges)
    var n, m = 0
    val f = Graph.fill(100)({
      n = m
      m += 1
      n - m
    })
  }

  def demoInnerOuterObj() = {
    val g = Graph(1 ~ 2, 1 ~ 3)
    val n1 = g.nodes.head
    println("n1" + n1.toString())
    println("n1 toOuter:" + n1.toOuter.toString())

    val e1 = g.edges.head
    println("e1 toOuter:" + e1.toOuter.toString())
    println("e1 first node:" + e1._1.toString())

    println("n1 directed successors:" + n1.diSuccessors.toString())
    println()
  }

  def demoGraphOperations() = {
    var g = Graph(2 ~ 3, 3 ~ 1)
    println(g.mkString("-"))
    println(g.nodes.mkString("-"))
    println(g.edges.mkString("-"))

    //Lookup, Function application with Syntax Sugar
    g = Graph(1 ~ 2)
    g find 1 // Option[g.NodeT] = Some(1)
    g find 3 // Option[g.NodeT] = None
    g get 1 // g.NodeT = 1
    //    g get 3 // NoSuchElementException
    g find 1 ~ 2 // Option[g.EdgeT] = Some(1~2)
    g find (g having (node = _ == 1)) // g.NodeT = 1

    println((g get 1) == 1) // true
    println((g get 1 ~ 2) == 2 ~ 1) // true
    println((g get 1 ~ 2) eq 2 ~ 1) // false
    println((g get 1 ~ 2) == 2 ~ 2) // false
  }

  def demoGraphMutations() = {
    val g = scalax.collection.mutable.Graph(1, 2 ~ 3)
    // Graph[Int,UnDiEdge]
    // to be assigned before each example
    g += 0 // Graph(0, 1, 2, 3, 2~3)
    println(g)

    g += (3 ~> 1) // Graph(1, 2, 3, 2~3, 3~>1)
    println(g)

    implicit val factory = scalax.collection.edge.LDiEdge
    g.addLEdge(3, 4)("red") // true
    println(g) // Graph(1, 2, 3, 4, 2~3, 3~>4 'red)
  }

  def demoImmutable() = {
    val g = Graph(1, 2 ~ 3) // immutable or mutable
    g + 1 // == g
    g + 0 // Graph(0, 1, 2, 3, 2~3)

    g + 0 ~ 1 // Graph(0, 1, 2, 3, 0~1, 2~3)
    g ++ List(1 ~ 2, 2 ~ 3) // Graph(1, 2, 3, 1~2, 2~3)

    g - 0 // == g
    g - 1 // Graph(2, 3, 2~3)
    g - 2 // Graph(1, 3)
    g -? 2 // == g
    g - 2 ~ 3 // Graph(1, 2, 3)
    g -! 2 ~ 3 // Graph(1)

    println(g)
  }

  def main(args: Array[String]): Unit = {
    demoInitGraph()
    demoInnerOuterObj()
    demoGraphOperations()
    demoGraphMutations()
    demoImmutable()
  }
}
