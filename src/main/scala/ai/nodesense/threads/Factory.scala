package ai.nodesense.threads

import scala.collection.mutable.Queue
import scala.util.Random
// A simple consumer producer threads and queue example

class Consumer(q: Queue[Int])  extends  Runnable {
  def run(): Unit = {
    println("Consumer running");
    while(true) {
      if (!q.isEmpty) {
        println("Consumed ", q.dequeue());
      }

      Thread.sleep(1000);
    }

  }
}

class Producer (q: Queue[Int] ) extends Runnable {
  def run(): Unit = {
    println("Producer Running..")

    val rnd: Random = new Random();
    while (true) {
      val r: Int = rnd.nextInt(1000);
      q += r;
      println("Produced ", r);
      Thread.sleep(5000);
    }
  }
}

object Factory {

  def factory(): Unit = {
      val queue: Queue[Int] = new Queue()

      val producer = new Thread(new Producer(queue))
      val consumer = new Thread(new Consumer(queue))

      producer.start()
      consumer.start()



  }

  def main(args: Array[String]) = {
    factory()
  }

}
