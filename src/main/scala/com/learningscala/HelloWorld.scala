package com.learningscala

import com.typesafe.scalalogging.LazyLogging

object HelloWorld extends App with LazyLogging { //interface LazyLogging

  val res = "Hello, " ++ "Scala !"
  lazy val lazy_result = "A lazy hello " + "from Scala" //lazy initialization.

  println(res)
  logger.info("Hello world from Scala!")
  logger.info(s"$lazy_result from Scala!")  //string interpolation
  val amount : Double = 2.0
  logger.info(s"You owe me $$$amount")  //escaping $ with string interpolation

  val nothing: Unit = () //Unit is equivalent of void in java.
  println(s"nothing: $nothing")

  val nothing1: Unit = "shri" //initializing unit...doesn't change its type>> gives warning.
  println(s"nothing1: $nothing1")

  val price : Double = 2.50
  println(f"price = $price%.3f")  //string formating using string interpolation

  val name = "shrikant"
  println(s"My name is:\t$name")
  println(raw"My name is:\t$name") //raw interpolation to pring symbols as is

  val addressJson =
    """
      |{
      |"house_no":"3804".
            |"street_name": "Wow st",
      |"city":"Seattle",
            |"state":"Washington",|"zip": "00000"
      |}
    """
    .stripMargin   //pipe allows to align , only makes sense only when on new line

  println(s"addressJson: $addressJson")

  val addressJson1 =
    """
      #{
      #"house_no":"3804".
      #"street_name": "Wow st",
      #"city":"Seattle",
      #"state":"Washington",
      #"zip": "00000"
      #}
    """
      .stripMargin('#')

  println(s"addressJson1 : $addressJson1")


  val addressJson2 =
    """
      #{
      #"house_no":"3804".
      #"street_name": "Wow st",
      #"city":"Seattle",
      #"state":"Washington",
      #"zip": "00000"
      #}
    """
      .stripMargin('#').replaceAll("\n", "")
  println(s"addressJson2 : $addressJson2")


  //for loop with condition and yield
  val oddNumbers = for {
    number <- 1 until 11 //use 1 to 10 (where 10 is included)
    if (number % 2 != 0)
  } yield number

  println(s"oddNumbers : $oddNumbers")

  //looping through 2D array of ints
  //[[1,2,3],[4,5,6],[7,8,9]]

  val Array2D = Array.ofDim[Int](3,3)
  var count = 1
  for (i <- 0 to 2)
    for (j <- 0 to 2 by 1) {  //increment by 1 by default.
      Array2D(i)(j) = count
      count += 1
    }

  //print 2D array
  for { x <- 0 to 2
        y <- 0 to 2
  } println(Array2D(x)(y))

  //mkstring on 2D array
  Array2D.map(row => println(row.toArray.mkString(",")))




}
