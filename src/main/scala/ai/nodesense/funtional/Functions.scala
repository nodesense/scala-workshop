//package ai.nodesense.functional
//
//object Functions extends App {
//
//  val sum = (f: Int => Int, a: Int, b: Int) => {
//    if (a > b) 0
//    else f (a) + sum (f, a + 1, b)
//  }
//
//  val id = (n: Int) => n
//
//  val sq = (n: Int) => n * n
//
//  val cube = (n: Int) => n * n * n
//
//  val sumId = (a: Int, b: Int) =>  sum(id, a, b)
//
//  val sumSq = (a: Int, b: Int) =>  sum(sq, a, b)
//
//  val sumCube = (a: Int, b: Int) => sum(cube, a, b)
//
//
//  println("Sum It", sumId(0, 2))
//  println("Sum SQ", sumSq(0, 2))
//  println("Sum Cube", sumCube(0, 2))
//
//
//
//
//
//}