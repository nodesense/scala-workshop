package ai.nodesense.bounds

object BoundsApp extends  App {

  trait Thing
  class Vehicle extends Thing
  class Car extends Vehicle
  class Jeep extends Car
  class ArmyJeep extends  Jeep

  class Coupe extends Car
  class Motorcycle extends Vehicle
  class Bicycle extends Vehicle
  class Tricycle extends Bicycle



  def GenericExample: Unit = {
    class Parking[A](val place: A)

    new Parking[Motorcycle](new Motorcycle)
    new Parking[Car](new Jeep)

    // new Parking[Motorcycle](new Car)
  }

  def UpperBoundExample: Unit = {
    class Parking[A <: Vehicle](val place: A)

    new Parking[Motorcycle](new Motorcycle)
    new Parking[Car](new Jeep)

    new Parking[Vehicle](new Car)
  }

  def LowerBoundExample: Unit = {
    class Parking[A >: Jeep](val place: A)

    // new Parking[Motorcycle](new Motorcycle)
    new Parking[Car](new Jeep)

    new Parking[Vehicle](new Car)

    //new Parking[ArmyJeep](new ArmyJeep)

  }

  def LowerAndUpperBound: Unit = {
    // Accept all types Vehicle and below and Bicycle and Above
    class Parking[A >: Bicycle <: Vehicle](val plaza: A)

    new Parking[Vehicle](new Car)
    new Parking[Bicycle](new Bicycle)

    // new Parking[Car](new Car)
    // new Parking[Tricycle](new Tricycle)
  }

  def SiteVariance: Unit = {
    class Parking[+A](val place: A){
      def park(p1: Parking[_ <: Vehicle]) {}
    }

    def dosomething(p1: Parking[Vehicle]) {}
    var p1 = new Parking(new Car)
    dosomething(p1)

  }

}
