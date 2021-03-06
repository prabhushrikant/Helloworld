package com.learningscala.Functions

object PartialFunction extends App {

//  A partial function is a function that does not provide an answer for every possible input value it can be given. It provides an answer only for a subset of possible data, and defines the data it can handle. In Scala, a partial function can also
//  be queried to determine if it can handle a particular value.
    val divide = new PartialFunction[Int, Int] {
    def apply(x: Int) = 42 / x
    def isDefinedAt(x: Int) = x != 0
  }

  println(divide.isDefinedAt(0))
  println(divide.isDefinedAt(2))
  println(if(divide.isDefinedAt(2)) divide(2))

  //should get you the same result.
  val divide2: PartialFunction[Int, Int] = {
    case d: Int if d != 0 => 42 / d
  }

  println(divide2.isDefinedAt(0))
  println(divide2.isDefinedAt(2))
  println(if(divide2.isDefinedAt(2)) divide2(2))

  //orElse - andThen construct

  val evenNumbers : PartialFunction[Int, String] = {
    case d: Int if d %2 == 0 => s"$d is even"

  }

  val oddNumbers : PartialFunction[Int, String] = {
    case d: Int if d %2 != 0 => s"$d is odd"

  }

  val handleOddAndEven = evenNumbers orElse oddNumbers
  val x = 5
  println(s"x: $x, ${handleOddAndEven(x)}")
  val x1 = 10
  println(s"x: $x1, ${handleOddAndEven(x1)}")

  //strangly enough if you apply evenNumbers on a collection Integers via map function
  //it will error. But the collection.collect() method will work.

  val myInts : Array[Int] = Array.ofDim[Int](5)
  for (i <- 1 to 5)
    myInts(i-1) = i

  //errors with : scala.MatchError
  //myInts.map(k => println(evenNumbers(k)))

  //doesn't error
  val res = myInts.collect(evenNumbers)
  res.foreach(println)
}
