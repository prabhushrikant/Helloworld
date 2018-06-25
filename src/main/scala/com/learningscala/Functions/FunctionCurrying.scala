package com.learningscala.Functions

case class Address(houseNumber: Int,
                   street: String,
                   city: String,
                   state: String,
                   zip: Int,
                   country: String)

object FunctionCurrying extends App {

  //curried function, (parameter grouping)
  def setAddress(country: String)(houseNumber : Int)(street: String)(city: String)
                  (state: String)(zip: Int): Address = {

    new Address(houseNumber,street,city,state,zip,country)

  }

  val newAddress = setAddress("US")(7575)("Frankford Rd")("Dallas")("TX")(75452)
  println(newAddress)

  //partially invoked function, //only fills first parameter group
  val USAddress = setAddress("USA") _  //uses wildcard for rest.

  //no need to provide the country
  val completeAddress = USAddress(2400)("Waterview Pkwy")("Dallas")("Texas")(75005)
  println(s"complete_Address: $completeAddress")


}


