val mystring : Option[String] = Some("Shrikant")
val rcvdString : String = mystring match
{
  case Some(mystring) => mystring
  case None => ""
}

