package workshop.functional

object MathExamples extends App {

  def isPalindrome(s: String) = {
    (for (x <- 0 to s.length/2) yield (s(x) == s(s.length - x - 1)))
      .reduceLeft((acc,n)=> acc && n)
  }


  println("ABBA");



}
