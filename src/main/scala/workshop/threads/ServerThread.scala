package workshop.threads

import scala.util.control.Breaks._

import java.net._
import java.io._
import scala.io._


object ServerThread extends App {

  def processClient(s :Socket) = {

    val thread = new Thread(new Runnable {
      def run(): Unit = {
        println("Serving Client  ")


        val in = new BufferedSource(s.getInputStream()).getLines()
        val out = new PrintStream(s.getOutputStream())
        breakable {
        while (true) {
            var msg = in.next();
            println("Client sent ", msg);

            out.println("Echo " + msg)
            out.flush()

            if (msg == "bye") {
              break
            }
          }
        }


        s.close()

      }
    })

    thread.start();
  }

  val server = new ServerSocket(9999)
  while (true) {
    println("Waiting for connection ")
    val s = server.accept()

    println("Client connected");

    processClient(s);

  }

}
