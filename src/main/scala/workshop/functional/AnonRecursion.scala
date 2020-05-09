package workshop.functional

// https://stackoverflow.com/questions/156369/which-languages-support-recursive-function-literals-anonymous-functions
object AnonRecursion extends  App {
  def fix[A,B](f: (A=>B)=>(A=>B)): A=>B = f(fix(f))(_)

  val fact = fix[Int,Int](f => a => if(a<=0) 1 else f(a-1) * a)

  println(fact(5))

  val factFunc = new Function1[Int,Int]{
    def apply(x:Int):Int = if(x==1) x else x * apply(x-1)
  }

  println(factFunc(5))

  val factorial = new ((Int) => Int){
    def apply(x:Int):Int = if(x==1) x else x * apply(x-1)
  }


  println(factorial(5))

}
