// using for as expression with yield

val squareList = for(i <- 1 to 5)  yield  i * i

def square(x: Int) : Int = x * x;

val squareList2 = for(i <- 1 to 5)  yield  square(i)


// _ represent value of i
// val squareList3 = for(i <- 1 to 5)  yield  square(_)




squareList2.foreach( x => println(x) );

// _ represent whatever variable name
squareList2.foreach(println(_));



println("List ", squareList)

println("List 2 ", squareList2)
