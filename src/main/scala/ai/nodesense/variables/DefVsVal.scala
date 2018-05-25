package ai.nodesense.variables

/*

def is basically  a method to be defined in classs/object

 */

object DefVsVal {

  def defExample(): Unit =  {
    def add(a: Int, b: Int) = a + b

    def sub = (a: Int, b: Int) => a + b;

    val mul = (a: Int, b: Int) => a * b

    println ("Add ", add(10, 20));
    println("Sub ", sub(10, 5));
    println("Mul ", mul(10, 2));
  }

  def main(args: Array[String]): Unit = {
    defExample();
  }

}
