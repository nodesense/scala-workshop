package ai.nodesense.networks

import java.net._
import java.io._


import scala.io._
import scala.util.control.Breaks._


object Client  extends App {

  val s = new Socket(InetAddress.getByName("localhost"), 9999)


  val out = new PrintStream(s.getOutputStream())

  //lazy val in = new BufferedSource(s.getInputStream()).getLines()
  lazy val in = new BufferedSource(s.getInputStream())

  out.println("Hello, world")
  println("Received: " + in.next())
  breakable {
  while (true) {
      print("Say something: ")
      val msg = scala.io.StdIn.readLine
      println("Senting", msg);
      out.println(msg)
      //out.println("Hello, world 2")
      out.flush()

      for(line <- in.getLines()) {
        println(line)
        if (line == "bye") {
          break
        }
      }

    }

  }

  println("Closing");
  s.close()
}
