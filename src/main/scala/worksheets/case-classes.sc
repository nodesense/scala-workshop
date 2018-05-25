
// watt is a member
// by default, immutable
// useful for pattern matching
case  class LightPower(watt: Int);
case class FanPower(watt: Int);

var power = FanPower(200);
println("Watt ", power.watt);

var obj: Object = power;

//error val by default
//power.watt = 100;

obj match {
  case l: LightPower => println("Light power", l.watt)

    // extractor
  case  FanPower(watt) => println(s"Fan power $watt")
}

// Extractor
val FanPower(watt) = power;
println(s"Watt is $watt");
// what it really implies
// calls unapply method
// val watt = FanPower.unapply(power)
