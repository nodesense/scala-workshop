package workshop.section30_typesystem

object ContraCoVarianceApp   {

  //class definitions
  class Pet(val name: String) {
    override def toString = name
  }

  class Dog(override val name: String) extends Pet(name)

  //covariance example

  def playWithPets[T <: Pet](pets: Array[T]) = {
    print(pets.mkString(", "))
  }

  def main(args: Array[String]) {
    val dogs = Array(new Dog("Rover"), new Dog("Goofy"))
    playWithPets(dogs)
  }

  //contravariance example

  def copyPets[S, D >: S](fromPets: Array[S], destPets: Array[D]) = {
  }

}