package workshop.section30_typesystem

object ContraVarianceEx  {


  class Animal
  class Cat extends Animal

  abstract class Whisperer[-A <: Animal] extends (A => Unit)

  object Whisperer {
    implicit def animalWhisperer: Whisperer[Animal] =
      new Whisperer[Animal] { def apply(a: Animal): Unit = { println("animal") } }

    implicit def catWhisperer: Whisperer[Cat] =
      new Whisperer[Cat] { def apply(a: Cat): Unit = { println("cat") } }
  }

  def main(args: Array[String]): Unit = {

    implicitly[Whisperer[Animal]].apply(new Animal)
    implicitly[Whisperer[Cat]].apply(new Cat)


    // animal
    // animal
  }



}

object ContraVarianceEx2 extends  App {
  class Animal
  class Cat extends Animal

  abstract class Whisperer[-A <: Animal] extends (A => Unit)

  trait AnimalWhisperers {
    implicit def animalWhisperer: Whisperer[Animal] =
      new Whisperer[Animal] { def apply(a: Animal): Unit = { println("animal") } }
  }

  trait CatWhisperers extends AnimalWhisperers {
    implicit def catWhisperer: Whisperer[Cat] =
      new Whisperer[Cat] { def apply(a: Cat): Unit = { println("cat") } }
  }

  object Whisperer extends CatWhisperers

  implicitly[Whisperer[Animal]].apply(new Animal)
  //implicitly[Whisperer[Cat]].apply(new Cat)

  // implicitly[Whisperer[Animal]].apply(new Animal)
  // implicitly[Whisperer[Cat]].apply(new Cat)
  // /home/cracknj/git/contravariant-resolution/./3.scala:16: error: ambiguous implicit values:
  //  both method animalWhisperer in object Whisperer of type => this.Whisperer[this.Animal]
  //  and method catWhisperer in object Whisperer of type => this.CatWhisperer
  //  match expected type this.Whisperer[this.Cat]
  // implicitly[Whisperer[Cat]].apply(new Cat)
  //           ^
  // one error found
}

object ContraVarianceEx4 extends App {
  class Animal
  class Cat extends Animal

  abstract class Whisperer[-A <: Animal] extends (A => Unit)
  abstract class CatWhisperer extends Whisperer[Cat]

  trait AnimalWhisperers {
    implicit def animalWhisperer: Whisperer[Animal] =
      new Whisperer[Animal] { def apply(a: Animal): Unit = { println("animal") } }
  }

  trait CatWhisperers extends AnimalWhisperers {
    implicit def catWhisperer: CatWhisperer =
      new CatWhisperer { def apply(a: Cat): Unit = { println("cat") } }
  }

  object Whisperer extends CatWhisperers

  implicitly[Whisperer[Animal]].apply(new Animal)
  implicitly[Whisperer[Cat]].apply(new Cat)

  // animal
  // cat
}

object ContraVarianceEx3 extends App {
  class Animal
  class Cat extends Animal

  abstract class Whisperer[-A <: Animal] extends (A => Unit)
  abstract class CatWhisperer extends Whisperer[Cat]

  object Whisperer {
    implicit def animalWhisperer: Whisperer[Animal] =
      new Whisperer[Animal] { def apply(a: Animal): Unit = { println("animal") } }

    implicit def catWhisperer: CatWhisperer =
      new CatWhisperer { def apply(a: Cat): Unit = { println("cat") } }
  }

  implicitly[Whisperer[Animal]].apply(new Animal)
  //implicitly[Whisperer[Cat]].apply(new Cat)

  // /home/cracknj/git/contravariant-resolution/./2.scala:19: error: ambiguous implicit values:
  //  both method animalWhisperer in trait AnimalWhisperers of type => this.Whisperer[this.Animal]
  //  and method catWhisperer in trait CatWhisperers of type => this.Whisperer[this.Cat]
  //  match expected type this.Whisperer[this.Cat]
  // implicitly[Whisperer[Cat]].apply(new Cat)
  //           ^
  // one error found

}