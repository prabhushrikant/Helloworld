package com.learningscala

object TypeConversion extends App {

  val stringInt : String = "-10"
  val myInt : Int = stringInt.toInt
  println(s"myInt : $myInt")

  val stringInt2 : String = "10"
  val myInt2 : Int = Integer.parseInt(stringInt2)
  println(s"myInt : $myInt2")

  val stringIntFail : String = "shri"
  val myIntFail : Option[Int] = OptionSomeNone.toMyInt(stringIntFail) //.toInt => java.lang.NumberFormatException: For input string:

  //pattern matching using match expression
  myIntFail match {
    case Some(i) => println(s"myIntFail : $i")
    case None => println("Invalid input number provided.")
  }
}
