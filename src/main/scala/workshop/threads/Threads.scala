package workshop.threads

object Threads extends  App {
  {
    val thread1 = new Thread(new Runnable {
      def run(): Unit = {
        println("Thread Run onces ")
      }
    })

      val thread2 = new Thread(new Runnable {
        def run(): Unit = {
          println("Thread2 Running , waiting for 5 seconds")
          Thread.sleep(5000);
          println("Thread 2 wait over ")
        }
      })

      val thread3 = new Thread(new Runnable {
        def run(): Unit = {
          println("Thread3 Running , waiting for 3 seconds")
          Thread.sleep(3000);
          println("Thread 3 wait over ")
        }
      })

      // MAIN THREAD EXECUTE

      println("Starting threads ");
      //Thread.sleep(4000);
      println("After Sleep");
      thread1.start()
       thread2.start()
       thread2.join();  // blocking call, t2 to be completed

      thread3.start()

      println("All threads started");

       // shall wait for thread1 to complete to proceed next step

       // thread3.join();
  }
}
