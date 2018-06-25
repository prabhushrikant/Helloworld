package com.learningscala.Patterns

object TypeClass extends App{

  trait Show[T] { def show(t: T): String }

  object Show {
    implicit def IntShow: Show[Int] = new Show[Int] { def show(i: Int) = i.toString }
    implicit def StringShow: Show[String] = new Show[String] { def show(s: String) = s }

    //def ShoutyStringShow: Show[String] = new Show[String] { def show(s: String) = s.toUpperCase }
  }

  case class Person(name: String, age: Int)
  object Person {
    implicit def PersonShow(implicit si: Show[Int], ss: Show[String]): Show[Person] = new Show[Person] {
      def show(p: Person) = "Person(name=" + ss.show(p.name) + ", age=" + si.show(p.age) + ")"
    }
  }

  val p = Person("Shrikant", 33)
  val res = implicitly[Show[Person]].show(p)
  println(res)
}
