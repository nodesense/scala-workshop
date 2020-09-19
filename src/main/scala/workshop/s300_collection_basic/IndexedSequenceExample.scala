package workshop.s300_collection_basic

object IndexedSequenceExample extends App  {
  val nums = IndexedSeq(1, 2, 3)

  println(nums(0))

  val l = List(10, 20, 30)
  println(l(0))

  (1 to 5).toIndexedSeq
  (1 until 5).toIndexedSeq
  (1 until 10 by 2).toIndexedSeq
  (1 to 10).by(2).toIndexedSeq


  println(IndexedSeq.fill(3)("foo")  )

  println(IndexedSeq.tabulate(2)(n => n * n))
  println(IndexedSeq.tabulate(4)(n => n * n))
  println(IndexedSeq.tabulate(6)(n => n * n))

  val v1 = IndexedSeq(4,5,6)         // IndexedSeq[Int] = Vector(4, 5, 6)
  val v2 = v1 :+ 7                   // Vector(4, 5, 6, 7)
  val v3 = v2 ++ IndexedSeq(8,9)     // Vector(4, 5, 6, 7, 8, 9)

  val v4 = 3 +: v3                   // Vector(3, 4, 5, 6, 7, 8, 9)
  val v5 = IndexedSeq(1,2) ++: v4    // Vector(1, 2, 3, 4, 5, 6, 7, 8, 9)
  println(v5)

  println(v5.head)

  println(v5.tail)

}
