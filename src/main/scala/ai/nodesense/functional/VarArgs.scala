package ai.nodesense.methods

/*
  Variable number of arguments

 */
object VarArgs extends App {

  def printAll(names: String*)  {
    names.foreach(println);
  }

  def printNumbers(numbers: Int*): Unit = {
    numbers.foreach(println)
  }

  printAll(); // error due to multiple default
  printAll("Hello");
  printAll("Welcome", "to", "Scala")

  // List to splat/spread

  // only works with * arguments
  val fruits = List("Apple", "Orange", "Mango")
  printAll(fruits: _*)

  printNumbers(1, 2, 3)
  printNumbers(List(100, 200, 300): _*)

}
