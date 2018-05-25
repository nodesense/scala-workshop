
var partType = "fan";



// match != switch in java

// match is expression in Scala

var watts: Int = partType match {
  case "light"  => 20
  case "fan" => 100
  case "ac" => 1000

  // default
  case _ =>  20
}

def getWatts(partType: String) = partType match {
  case "light" => 20
  case "fan" => 100
  case "ac" => 1000

  // default
  case _ =>  200
}

var watts2 = getWatts("light")

val LIGHT = "light";
val FAN = "fan";


// TODO:
partType = "light";

println("Part type ", partType);

var watt3 = partType match {
  case LIGHT => 20
  case FAN => 30
  case _ => 50
}

println("watt ", watt3);


