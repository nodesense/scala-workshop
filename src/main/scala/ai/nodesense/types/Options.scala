package ai.nodesense.types

object Options extends App {


  def toInt(input: String): Option[Int] = {
    try {
      Some(input.toInt)
    } catch {
      case _: Throwable =>
        println ("Error input ")
        None

    }
  }

  println("parse 100", toInt("100"));
  println("parse empty ", toInt(""));

  var result: Option[Int] = toInt("100");
  var result2: Option[Int] = toInt("test")

  println("result", result.isEmpty);

  println("result value ", result.get);

  println("result2", result2.isEmpty);

  println("getOrElse ", result.getOrElse(0));

  println("getOrElse ", result2.getOrElse(0));





}
