package workshop.s300_collection_basic
import scala.collection.mutable.Map

object ImmutableMap extends  App {


  var t1 = ("d1", 10)
  // returns tuple
  var t2 = "d2" -> 20;

  var (key, value) = ("d10", 5);



  var map = Map[String, Int] (
    // ("device1", 100),
    "device2" -> 50,
    "device3" -> 20,
    t1
  )

  map += "device4" -> 30
  map += ("device5" -> 40)

  map += t2

  map -= ("device4");

  map += "device5" -> 400;

  for (x <- map) printf("key: %s, value: %s\n", x._1, x._2)


  for ((k,v) <- map) printf("key: %s, value: %s\n", k, v)

  var partition = map.partition( t => t._2 <= 30)


}


