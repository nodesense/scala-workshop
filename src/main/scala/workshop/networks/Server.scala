package workshop.networks

import java.net._
import java.io._
import scala.io._


object Server extends App {

  val server = new ServerSocket(9999)
  while (true) {
    println("Waiting for connection ")
    val s = server.accept()

    println("Client connected");

    val in = new BufferedSource(s.getInputStream()).getLines()
    val out = new PrintStream(s.getOutputStream())

    var msg = in.next();
    println("Client sent ", msg);

    out.println(msg)
    println("Waiting for second line");
    msg = in.next();
    println("done waiting for second line");

    out.flush()
    s.close()
  }

}
