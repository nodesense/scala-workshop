
// Immutable List

val list = List(10, 20, 30, 40, 45, 50, 55, 65);

val listAny = List(10, "Scala");


var list2 = list.map(_ * 2);

var list3 = list.map ( n => n * 2);

def mulBy2 (n: Int) : Int = n * 2

var list4 = list.map (mulBy2)

var filter1 = list.filter(n => n % 2 == 0);

var par = list.partition(n => n % 2 == 0);

var (evenList, oddList) = list.partition(n => n % 2 == 0);

println("Even ", par._1) // print even numbers
println("Odd ", par._2) // print even numbers


list.fold(0) ( (acc: Int,  n: Int) => acc + n)


// Tuple
var t1 = (10, 20);

var t2 = (10, 20, 30);

var t3 = ("Student 1", 1);

var (a, b) = t1;

// tuple index start from 1
// access tuple variable
println("t1_1", t1._1, t1._2);



// clone of the list, add the element
//var newList =   50 :: list;