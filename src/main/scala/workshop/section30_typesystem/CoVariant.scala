package workshop.section30_typesystem

object CoVariant extends  App {

  class Animal[+T](val animial:T)

  class Dog
  class Puppy extends Dog

  class AnimalCarer(val dog:Animal[Dog])

  val puppy = new Puppy
  val dog = new Dog

  val puppyAnimal:Animal[Puppy] = new Animal[Puppy](puppy)
  val dogAnimal:Animal[Dog] = new Animal[Dog](dog)

  val dogCarer = new AnimalCarer(dogAnimal)
  val puppyCarer = new AnimalCarer(puppyAnimal)

  //  Puppy is subtype of Dog, Animal[Puppy] is a subtype of Animal[Dog].
  println("Done.")


}
