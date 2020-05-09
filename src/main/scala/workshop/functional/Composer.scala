package workshop.functional

object App {

  def main (args: Array[String]){

    val fp = candidate(_)

    val f = decorate(fp,decorator) // F o G

    println(f("Hello World"))
    println(fp("Hello World"))
  }

  def candidate(s: String):String = {
    "Transforming - " + s
  }

  def decorator(c: String=>String):(String=>String) = {
    (s: String) => {
      "****** " + c(s) + " *******"
    }
  }

  def decorate[A,B](f:(A => B),f2:((A=>B)=>(A=>B))):(A=>B) = f2(f)

}