
// returns a function
// Closure, keeps the variable in memory
def Seq(start: Int = 0): () => Int = {

  var i = start;

  // visiblity rule, var visible to incr
  def incr(): Int = {
    val prevValue = i
    i += 1
    prevValue
  }

  // returns a function
  incr
}

// g1 is an incr function
val g1 = Seq(1);
val g100 = Seq(100);

println(Seq(10000)());

// we call incr() method, that return result
var value = g1();

println(g1())
println(g1())
println(g1())

println(g100());

println(g100());
println(g1())
//
//
//
//g1 = Seq(1)
//
//g2 = Seq(100)
//
//g3 = Seq(10000)
//
//g1() 1, 2, 3, ..
//g2() 100, 101, 102, ..
//g3() 10000, 100001