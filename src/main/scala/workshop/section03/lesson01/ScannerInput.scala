package workshop.section03.lesson01

import scala.io.StdIn;

object ScannerInput  {
  def main(args: Array[String]) {
    print("Enter your name: ")
    val name =  StdIn.readLine() // let it run until user presses return
    print("Enter your exp: ")

    val exp = StdIn.readInt()

    println("Your name " + name);
    println("Your exp " + exp);
  }
}
