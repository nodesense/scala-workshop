package ai.nodesense.objects

class Fan(val id: String, val watt: Int) {
  override def toString: String = s"ID : $id; Watt: $watt"
}

object Fan {
  def apply(): Unit = {
    println("FAn Apply called")
  }

  def apply(id: String, watt: Int = 0) : Fan = {
    println(s"Fan Apply $id")
    new Fan(id, watt)
  }

  // unapply :Extractor, returns Option
  def unapply(fan: Fan) : Option[String] = {
    println("unapply called");
    Some(fan.id)

    // returns None
    // when id not present None
  }
}


class Light(val id: String, val watt: Int) {
  override def toString: String = s"ID : $id; Watt: $watt"
}


object Light {

  def apply(id: String, watt: Int = 0) : Light = {
    println(s"Light Apply $id")
    new Light(id, watt)
  }

  // unapply :Extractor, returns Option
  def unapply(light: Light) : Option[(String, Int)] = {
    println("unapply called");
    Some((light.id, light.watt))

    // returns None
    // when id not present None
  }
}

object FanTest extends App {

  // calls apply method
  Fan();
  // calls overloaded apply function
  val fan1 = Fan("fan1")
  // fan1.toString called automatically
  println(fan1);

  {
    // Extractor for id, needs unapply method
    val Fan(id) = fan1;

    println("ID is ", id);
  }

  {
    val light1 = Light("light1", 10)
    // extracting id and watt from object
    val Light(id, watt) = light1;

    println("ID is ", id, watt);
  }


  {
    val light2 = Light("light2", 24)
    val Light(watt) = light2;

    println("light 2 watt is ", watt);
  }




}
