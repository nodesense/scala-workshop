package workshop.section01_basics.lesson04.functions

// Functions are first class citizen in SCALA
// This is starter, for details, we will cover in next session

object Functions extends  App {

  // =>

  // val lambda_exp = (variable:Type) => Transformation_Expression

  // lambda expression/ aka function in Scala
  // returns types are implicits
  val add = (a: Int, b: Int ) => a + b
  val sub = (a: Int, b: Int ) => {
    a - b
  }

  println ( add(20, 10) )
  println ( sub(20, 10) )


}
