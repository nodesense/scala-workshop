object Counter {
  // Object members

  var count = 10;

  def increment = {
    count += 1
    count
  }

  // Getter/Setter methods in Scala
  private var myseq = 0;

  // Getter
  def seq = myseq

  // Setter

  // in scala _= is overloaded operator for setter

  //http://www.scala-lang.org/files/archive/spec/2.11/04-basic-declarations-and-definitions.html#variable-declarations-and-definitions
  def seq_= (value:Int):Unit = myseq = value



}


// App is a trait defined in Scala
// App implement main method

object SingletonApp  extends App {
   // object constructor
   println("my singleton app ");
   println(Counter.count);
   Counter.increment
   println(Counter.count);

   println("SEQ ", Counter.seq)
   // calling setter
   Counter.seq = 20


  println("SEQ ", Counter.seq)

}
