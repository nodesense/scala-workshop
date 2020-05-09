package workshop.section03_classes.lesson01

object Implicits extends App {


  println("Testing")
  case class Appliance(id: Int,
                       name: String,
                       price: Option[Int] = None)



  object ApplianceImplicits {
    implicit class AugmentedAppliance(appliance: Appliance) {
      def uuid: String = s"${appliance.id} - ${appliance.name}"
    }

  val a1: Appliance = Appliance(1, "Light1")

      println("Result ", a1.uuid);

}



}
