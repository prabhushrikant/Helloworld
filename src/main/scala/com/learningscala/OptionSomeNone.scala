package com.learningscala

import scala.util.{Failure, Success, Try}

//disadvantage of option_some_none pattern is that we can't see the error/exception.
//or carry it forward, but that's the main purpose of using option. If you can't
//mitigate the exception, why catch it.....in that case it's more appropriate to use
//Try_Success_Failure pattern also called Neither_Left_Right pattern.

object OptionSomeNone {

  val myIntOption_Success : Option[Int] = Some(10)
  println(s"myIntOption_Success: ${myIntOption_Success.get}")

  val myIntOption_None : Option[Int] = None
  println(s"myIntOption_None: ${myIntOption_None.getOrElse(0)}")

  //Option..Some...None idiom
  def toMyInt(s: String) : Option[Int] = {
    try{
      Some(s.toInt)
    } catch{
      case e: NumberFormatException => None
    }
  }

  //Either..Left..Right idiom
  def toMyInt2(s: String) : Either[Exception, Int] = {
    try{
      Right(s.trim().toInt)  //right contains the correct result.
    } catch{
      case e: Exception => Left(e) //left contains what failed.
    }
  }

  //Try...Success...Failure
  def toMyInt3(s: String) : Try[Int] = {
    Try(s.trim().toInt)
  }

  def main(args: Array[String]): Unit = {

    val myIntSuccess : Unit = toMyInt("10") match {
      case Some(i) => println(s"Input number (some): $i")
      case None => println("Invalid number")
    }

    val myIntFail : Unit = toMyInt("foo") match {
      case Some(i) => println(s"Input number (some) : $i")
      case None => println("Invalid number")
    }

    val myIntFail3 : Unit = toMyInt3("foo") match {
      case Success(i) => println(s"Input number (success) : $i")
      case Failure(f) => println(f)
    }

    val myIntFail2 : Unit = toMyInt2("foo") match {
      case Right(i) => println(s"Input number (right): $i")
      case Left(e) => throw new Exception(e)
    }

  }

}
