package workshop.section30_typesystem

object Types  extends  App {

   abstract class Appliance (val id: Int,
                    val name: String) {
     override def toString = s"$id, $name"
   }

   class Light(id: Int, name: String) extends  Appliance(id, name) {

   }

   object Light {
     def apply(id: Int, name: String) = {
       new Light(id, name)
     }
   }


  class Fan(id: Int, name: String) extends  Appliance(id, name) {

  }

  object Fan {

      def apply(id: Int, name: String) = {
        new Fan(id, name)
      }

  }





  class Appliances[D <: Appliance](appliances: Seq[D]) {
    def list = appliances.foreach(println(_))
  }

  class Test[D] (test: D) {
     def getObj: D = test
  }

  val appliances = new Appliances(Seq(Light(1, "light1"),
                                      Fan(2, "Fan2")));

  val test = new Test[Light] (Light(1, "L1"));

  println(test.getObj)

  appliances.list


  // Doesn't accept Appliance, even passing Light object
  // val appliances2: Appliances[Light] = new Appliances[Appliance](Seq(Light(1, "light1")))

  class AppliancesWithContra[-D <: Appliance](appliances: Seq[D]) {

    def list = appliances.foreach(println(_))

  }

  val appliances2: AppliancesWithContra[Light] = new AppliancesWithContra[Appliance](Seq(Light(1, "light1"), Fan(1, "fan2")))


  appliances2.list




  class GParent

  class Parent extends GParent

  class Child extends Parent

  class Box[+A]

  class Box2[-A]

  def foo(x : Box[Parent]) : Box[Parent] = identity(x)

  def bar(x : Box2[Parent]) : Box2[Parent] = identity(x)

  foo(new Box[Child]) // success

  //foo(new Box[GParent]) // type error

  // bar(new Box2[Child]) // type error

  bar(new Box2[GParent]) // success
}
