package com.learningscala.Utils

object StringUtils {

  def isNullOrEmpty(s:String) : Boolean = {

      //Note - this doesn't work for not null empty strings like "".
      //Option(s).isEmpty

      Option(s).getOrElse("").trim().isEmpty()
  }

  def isNullOrEmpty2(s:String) : Boolean = {

    Option(s) match {
      case Some(s) if (!s.trim.isEmpty()) => return false
      case _ => return true
    }
  }

  def main(arg : Array[String]) : Unit = {

    var s : String = "Shrikant"
    println(s"s: $s, isNullOrEmpty : ${isNullOrEmpty(s).toString}")
    println(s"s: $s, isNullOrEmpty2 : ${isNullOrEmpty2(s).toString}")

    s = ""
    println(s"s: $s, isNullOrEmpty : ${isNullOrEmpty(s)}")
    println(s"s: $s, isNullOrEmpty2 : ${isNullOrEmpty2(s)}")

    s = "  "
    println(s"s: $s, isNullOrEmpty : ${StringUtils.isNullOrEmpty(s)}")
    println(s"s: $s, isNullOrEmpty2 : ${StringUtils.isNullOrEmpty2(s)}")

    s = null
    println(s"s: null, isNullOrEmpty : ${StringUtils.isNullOrEmpty(s)}")
    println(s"s: null, isNullOrEmpty2 : ${StringUtils.isNullOrEmpty2(s)}")

  }



}
