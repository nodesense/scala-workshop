package workshop.functional

/*
  Functor:
    fmap:
    Takes a set and changes it to another set
    signature:
    (f: A => B): F[A] => F[B]

    point:
    lifts type to functor type
    signature:
    (a: => A): F[A]


    applic:
    A way to combine a container with a function.
    signature:
    (f: F[A=>B]): F[A] => F[B]

*/
object ApplicativeFunctor {

  def main(args: Array[String]){

    val price = applic(pricer(Market(true)))(grow)
    val price2 = applic(pricer(Market(true)))(grow2)
    val price3 = applic(pricer(Market(false)))(grow2)
    val price4 = applic(pricer(Market(true)))(grow3)

    println(price)
    println(price2)
    println(price3)
    println(price4)
  }

  def pricer(market: Market) = market.open match {
    case true => Some(market pricing)
    case false => None
  }

  val grow = Some(Fruit("Orange"))
  val grow2 = None
  val grow3 = Some(Fruit("Apple"))

  /*
    an applicative functor

    Takes a function and applies a parameter to that function to
    generate the result of its computation.
  */

  def applic(f: Option[Fruit => Int]):Option[Fruit] => Option[Int] =
    (fruitOption: Option[Fruit]) =>
      for(fruit <- fruitOption;
          func <- f) yield (func(fruit))
}

case class Fruit(val name: String)
case class Market(val open: Boolean){
  val pricing = (f: Fruit) => f.name match {
    case "Orange" => 10
    case _ => -1
  }
}