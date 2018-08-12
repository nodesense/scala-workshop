package ai.nodesense.functional

//https://alvinalexander.com/scala/how-to-define-use-partial-functions-in-scala-syntax-examples
//
//A partial function is a function that does not
// provide an answer for every possible input value it can be given.

object PartialFunctions extends  App {

  // syntax
  // PartialFunction[A, B], where as A is Input, B is output

  // Explicit Partial function, where we define isDefinedat method
  val divide = new PartialFunction[Int, Int] {
    def apply(x: Int) = 42 / x
    def isDefinedAt(x: Int) = x != 0
  }

  println(divide.isDefinedAt(1))
  println(divide.isDefinedAt(0))

  // implicit divide, where case works as isDefined
  val divide2: PartialFunction[Int, Int] = {
    case d: Int if d != 0 => 42 / d
  }


  println(divide2.isDefinedAt(1))
  println(divide2.isDefinedAt(0))


  if (divide.isDefinedAt(1)) println(divide(1))

  if (divide.isDefinedAt(0)) println(divide(1))

  if (divide2.isDefinedAt(1)) println(divide(1))

  if (divide2.isDefinedAt(0)) println(divide(1))

  // example 2
  // further read https://dzone.com/articles/partial-functions-in-scala

  val squareRoot: PartialFunction[Double, Double] = {
    case d: Double if d > 0 => Math.sqrt(d)
  }

  val list: List[Double] = List(4, 16, 25, -9)
  val result = list.map(Math.sqrt) // sqrt of negative returns NaN
  println(result)

  // collect takes partial function
  val result2 = list.collect(squareRoot)
  
  println(result2)

}
