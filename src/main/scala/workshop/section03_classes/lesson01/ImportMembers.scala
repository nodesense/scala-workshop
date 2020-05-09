package workshop.section03_classes.lesson01

object Math {
  def add(a: Int, b: Int) : Int = a + b
  def mul(a: Int, b:Int) : Int = a * b
}


object ImportMembers extends App {
  import Math._

  println(add(10, 20))
  println(mul(10, 20))

}
