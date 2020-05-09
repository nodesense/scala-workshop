package workshop.threads

//Runnable has a single method that returns no value.


object Basics {
  def runnableExample: Unit = {
    val thread = new Thread(new Runnable {
      def run(): Unit = {
        println("Thread Run onces ")
      }
    })

    thread.start()
  }

  def multiThreads: Unit = {
    val thread1 = new Thread(new Runnable {
      def run(): Unit = {
        println("Thread1 Running , waiting for 5 seconds")
        Thread.sleep(5000);
        println("Thread 1 wait over ")
      }
    })

    val thread2 = new Thread(new Runnable {
      def run(): Unit = {
        println("Thread2 Running , waiting for 3 seconds")
        Thread.sleep(3000);
        println("Thread 2 wait over ")
      }
    })

    println("Starting threads ");
    thread1.start()
    thread2.start()

    thread2.join(); // shall wait for thread1 to complete to proceed next step
    println("Waiting for thread 1");


    println("Waiting for thread 2");

  }


  def main(args: Array[String]) = {
    runnableExample

    multiThreads



  }


}

