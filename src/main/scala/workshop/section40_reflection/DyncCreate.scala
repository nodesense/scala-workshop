package workshop.section40_reflection

import scala.reflect.runtime._
import scala.reflect.runtime.universe._

object DyncCreate extends  App {
  trait MyTrait;

  class Test[T <: MyTrait : TypeTag] {

    def createInstance(args: AnyRef*)(ctor: Int = 0): T = {
      val tt = typeTag[T]

      currentMirror.reflectClass(tt.tpe.typeSymbol.asClass).reflectConstructor(
        tt.tpe.members.filter(m =>
          m.isMethod && m.asMethod.isConstructor
        ).iterator.toSeq(ctor).asMethod
      )(args: _*).asInstanceOf[T]
    }
  }

  class Person {
    println("Person created")
  }

  def example() =
  {
    val instance1 = createInstance[Person]()
    val instance2 = createInstance(typeOf[Person])
  }


  def createInstance[T:TypeTag]() : Any= {
    println("through type tag")
    createInstance(typeOf[T])
  }


  def createInstance(tpe:Type): Any = {
    val mirror = runtimeMirror(getClass.getClassLoader)
    val clsSym = tpe.typeSymbol.asClass
    val clsMirror = mirror.reflectClass(clsSym)
    val ctorSym = tpe.decl(termNames.CONSTRUCTOR).asMethod
    val ctorMirror = clsMirror.reflectConstructor(ctorSym)
    val instance = ctorMirror()
    return instance
  }

  val instance1 = createInstance[Person]()
  val instance2 = createInstance(typeOf[Person])

  //val instance3 = createInstance(typeTag[Person])


}
