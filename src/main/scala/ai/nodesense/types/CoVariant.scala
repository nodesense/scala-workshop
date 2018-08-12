package ai.nodesense.types

// for more studies
// https://www.journaldev.com/9585/scala-variances-covariant-invariant-contravariant

// If “S” is subtype of “T” then List[S] is is a subtype of List[T].
// Prefixing Type Parameter with “+” symbol defines Covariance in Scala.
//   T is a Type Parameter and “+” symbol defines Scala Covariance.


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
