package ai.nodesense.objects

object Implicits extends App {


  println("Testing")
  case class Appliance(id: Int,
                       name: String,
                       price: Option[Int] = None)



  object ApplianceImplicits {
    implicit class AugmentedAppliance(appliance: Appliance) {
      def uuid: String = s"${appliance.id} - ${appliance.name}"
    }

    import ApplianceImplicits._

  val a1: Appliance = Appliance(1, "Light1")

      println("Result ", a1.uuid);

}



}
