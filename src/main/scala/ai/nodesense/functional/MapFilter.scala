package ai.nodesense.functional

object CollectionExample extends  App {

  def map2[A, B] (list: Seq[A], f: (A) => B): Seq[B] = {
    for {
      x <- list
    } yield f(x)
  }

  def map[A,B](f: (A) => B, list: Seq[A]): Seq[B] = {
    for {
      x <- list
    } yield f(x)
  }

  def filter[A] (list: Seq[A], f: (A) => Boolean):Seq[A] = {
    for {
      x <- list if f(x)
    } yield x
  }

  val list = List(1, 2, 3, 4, 5);
  println(map[Int, Int](i => i * 2, list))
  println(map[Int, Float] ((i => i * 2), list))

  println(filter[Int](list, (i => i % 2 == 0)))
}
