package workshop.section04_objects.lesson01

object Singleton {

  // Object member
  var count = 100;

  // Object member function
  def increment  = {
    count += 1
    count
  }

  def main(args: Array[String]): Unit = {
      println("Singleton main ");
      println(count);

      println("increment", increment)

      println("new count ", count)
  }

}
