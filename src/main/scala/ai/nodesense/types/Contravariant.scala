package ai.nodesense.types

object Contravariant  extends  App {
  // If “S” is subtype of “T” then List[T] is is a subtype of List[S].
  // Prefixing Type Parameter with “-” symbol defines Contravariant in Scala

  abstract class Type [-T]{
    def typeName : Unit
  }

  class SuperType extends Type[AnyVal]{
    override def typeName: Unit = {
      println("SuperType")
    }
  }
  class SubType extends Type[Int]{
    override def typeName: Unit = {
      println("SubType")
    }
  }

  class TypeCarer{
    def display(t: Type[Int]){
      t.typeName
    }
  }

  object ScalaContravarianceTest {

    def main(args: Array[String]) {
      val superType = new SuperType
      val subType = new SubType

      val typeCarer = new TypeCarer

      typeCarer.display(subType)
      typeCarer.display(superType)
    }

  }


}
