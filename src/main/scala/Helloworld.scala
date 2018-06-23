/**
  * Created by shrikant on 5/21/17.
  */
object Helloworld {

  def main(args: Array[String]): Unit = {
    val mystring : Option[String] = Some("Hello World from ....Shrikant!!!")
    val rcvdString : String = mystring match
    {
      case Some(mystring) => mystring
      case None => ""
    }

    println(rcvdString)

    val res = "Hello" ++ "World !"

    println(res)
  }
}

