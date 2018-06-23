package com.learningscala

object Fold extends App {

  //constraints :
  //  The first constraint is that the start value must be a supertype of the object you're folding. In our first example we were folding on a type List[Int] and had a start type of Int.
  //  Int is a supertype of List[Int].

  //  The second constraint of fold is that the start value must be neutral, i.e. it must not change the result. For example, the neutral value for an addition operation would be 0, 1 for multiplication, Nil lists, etc.

  //fold can start from any given start value(not position) and moves from left to right in collection
  val numbers = List(5,4,3,2,1)
  val result = numbers.fold(7){ (acc, i) =>
    acc + i
  }
  println(result)

  //foldLeft starts from left of the collection and move to right,
  val resultLeft = numbers.foldLeft(List[Int]()){ (acc, i) =>
    //println(i)
    acc :+ i
  }
  println(resultLeft)

  val resultLeft2 = numbers.foldLeft(0){ (acc, i) =>
    acc - i
  }
  println(resultLeft2)


  //foldRight starts from right of the collection and move to left
  //Note - acc is the second argument in foldRight while it's first in foldLeft.
  val resultRight = numbers.foldRight(List[Int]()){ (i, acc) =>
    //println(i)
    acc :+ i
  }
  println(resultRight)

}
