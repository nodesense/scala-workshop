package workshop.functional

import scala.annotation.tailrec

object Recursion extends  App {

  //GCD below is a tail recursion,
  //reuses the one call stack, instead of creating new callstack
  // for every recursive attempt

  @tailrec
  def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
  }

  // This factorial is not a tail recursion
  // maintain call stack for n each time recursively called
  //adding tailrec would fail
  //@tailrec
  def factorial(n: Int): Int = {
    if (n <= 0)
      return 1

    println(s"N $n")

    n * factorial(n - 1);
  }

  def factorialWithTail(n: Int) = {
    var acc = 1
    def fact(i: Int): Int = {
      if (i <= 0)
        return acc

      acc *= i;

      fact(i - 1)
    }

    fact(n)
  }

  println("GCD (1, 2)", gcd(1, 2));
  println("GCD (2, 4)", gcd(2, 4));
  println("GCD (4, 6)", gcd(4, 6));


  println("Factorial (4)", factorial(4));
  println("Factorial (5)", factorial(5));

  println("factorialWithTail (4)", factorialWithTail(4))

  println("factorialWithTail (5)", factorialWithTail(5))
}
