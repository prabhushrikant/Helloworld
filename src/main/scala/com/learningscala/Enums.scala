package com.learningscala

object Enums extends Enumeration {

  type myEnum = Value

  val Red    = Value(0,"Red")
  val Orange = Value(1,"Orange")
  val Yellow = Value(2,"Yellow")
  val Green  = Value(3,"Green")
  val Blue   = Value(4,"Blue")
  val Indigo = Value(5,"Indigo")
  val Violet = Value(6,"Violet")
  val White  = Value(-1,"White")

  def main(args: Array[String]): Unit = {

    val rainbowColor : myEnum = Enums.Red
    println(s"Current color : $rainbowColor")

    Enums.values.foreach {
      case c if (c == Enums.Red || c == Enums.Green || c == Enums.Blue) => println(s"$c : Basic Color")
      case c if (c == Enums.White) => println(s"$c : Not a rainbow color")
      case d => println(s"$d : Derived Color")
    }

  }

}









