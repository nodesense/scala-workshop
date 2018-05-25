package ai.nodesense.objects


object Casting {

  class Animal {

  }

  class Dog extends Animal {

  }

  val a:Animal = new Dog();

  val d: Dog = a.asInstanceOf[Dog];



}
