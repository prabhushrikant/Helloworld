package com.learningscala

class PhoneString(s: String) {

  val phone_regex = """^\+?(\d{1,2})-?(\d{3})-?(\d{3})-?(\d{4})$"""
  def isPhoneString : Boolean = s.matches(phone_regex)
}

object Implicits extends App {

  //advantages of implicits:
  // 1. can be used to achieve dependency injection in scala.
  // 2. can be used to implement typeclass pattern
  // 3. can be used to extend a given class

  //scala allows to have implic it function parameters for calling a method.

  implicit var fromLocation : String = "USA"
  implicit var fromLocationZipcode : Int = 98199
  //following will cause compile time error.
  //e.g. ambiguous implicit values.
  //implicit var fromLocationZipcode : String = "98199"

  def sayHelloFrom(name:String)(implicit fromLocation : String,
                                fromZipcode : Int) : Unit = {

    println(s"Hello $name from $fromLocation, $fromZipcode")
  }

  sayHelloFrom("shrikant")

  //Note - 1) problem with implicits , what if change fromLocationZipcode to String,
  //there will be two implicits in scope with same type, func "sayHelloFrom" wouldn't
  //know which one to use.


  //Note - 2) another problem with implicits is, if you define a one argument method
  //with the implicit modifier, scala uses that a way to convert arguments of input
  //type to the output type, in calls where method is in scope.
  // on side note it's actually also advantageous to easily extend a class,
  // see example below with PhoneString.

  //e.g.
  //output - "Hello, 007!"
  implicit def agentCodename(i: Int) = s"00$i"
  sayHelloFrom(7)


  //implicitly:
  //Implicitly is avaliable in Scala 2.8 onwards
  //It is commonly used to check if an implicit value of type T is available and return it if such is the case.

  val a_implicit_string = implicitly[String]
  println(s"implicit_string : $a_implicit_string")

  val b_implicit_int = implicitly[Int]
  println(s"implicit_int : $b_implicit_int")

  //it will error if not found anything of that type.
  //eg. could not find implicit value for parameter e : Double
//  val c_implicit_double = implicitly[Double]
//  println(s"implicit_double : $c_implicit_double")


  //extension of string class using implicits.
  //Note - it's good idea to wrap it into an object

  implicit def convertToPhoneString(s: String) : PhoneString = new PhoneString(s)

  val string1 : String = "+1214-676-8979"
  val string2 : String = "+912146768979"
  val string3 : String = "+91abc67shrii"

  println(s"string : $string1, isPhoneString: ${string1.isPhoneString}")
  println(s"string : $string2, isPhoneString: ${string2.isPhoneString}")
  println(s"string : $string3, isPhoneString: ${string3.isPhoneString}")

}
