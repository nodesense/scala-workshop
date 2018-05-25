trait Control {
   def on()
   def off()
}

trait Regulate {
  def step(range : Int)
}

trait PowerUsage {
  var volt: Int; // volt
  def power: Int; // Amp
  def watt: Int; // volt * amp
}

  class Fan(val id: String, val watt: Int) extends Control with  Regulate with PowerUsage {
   // member variable
   var  volt: Int = 0;
   var power: Int = 0;

  def on() = {
    println ("Fan on")
  }

  def off() = {
    println ("Fan off")
  }

  def step(range: Int) = {
    println("Step by ", range);
  }
}

object ControlBoard extends Control {
  def on() = {

  }

  def off() = {

  }
}


object ControlApp extends App {

  val fan1 = new Fan("fan1", 100)
  fan1.power = 5

  var pu: PowerUsage = fan1;

  pu.volt = 220

  println("fan ", fan1.id);
}