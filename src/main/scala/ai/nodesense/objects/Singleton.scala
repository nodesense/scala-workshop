// object is singleton type
// no static keyword in object/class/scala

// all members of objects are static by default

// we can't create object for object type ie no new Singleton()

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
