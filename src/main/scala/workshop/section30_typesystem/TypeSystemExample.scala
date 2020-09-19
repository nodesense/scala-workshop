package workshop.section30_typesystem

object TypeSystemExample extends  App {
  // wiki Variance refers to how subtyping between more complex types relates to subtyping between their components

  // Types
  // every type has finite/infinite possible values
  // Boolean is a type with true/false, two possible values
  // String, inifite values
  // [Cicle, Triangle, Reactangle] - set of 3 values

  sealed trait Shape
  case object Circle    extends Shape
  case object Triangle  extends Shape
  case object Rectangle extends Shape

  case class Container(form: Shape, hasBg: Boolean)
  // ProductType  Container has n values of type Shape - 3
  // m values of type boolean - 2
  // total 3 x 2 = 6


}
