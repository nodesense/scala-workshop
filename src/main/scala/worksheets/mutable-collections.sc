import scala.collection.mutable.ListBuffer

// mutable
var list = ListBuffer(10, 20);

println(list);

list += 30;
list += 40;
list += 50;

println(list);

list -= 40;


println(list);

println(list.exists( x => x == 40))

println(list.exists( x => x == 50))
