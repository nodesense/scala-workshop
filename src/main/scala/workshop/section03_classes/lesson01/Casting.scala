package workshop.section03_classes.lesson01

object Casting {

  class Animal {

  }

  class Dog extends Animal {

  }

  val a:Animal = new Dog();

  val d: Dog = a.asInstanceOf[Dog];



}
