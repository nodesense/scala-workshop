package ai.nodesense.lenses

import com.softwaremill.quicklens._

object quicklens extends App {

  case class User(id: Int, name: Name, billingInfo: BillingInfo, phone: String, email: String)
  case class Name(firstName: String, lastName: String)
  case class Address(street1: String, street2: String, city: String, state: String, zip: String)
  case class CreditCard(name: Name, number: String, month: Int, year: Int, cvv: String)
  case class BillingInfo(creditCards: Seq[CreditCard])


  val user = User(
    id = 1,
    name = Name(
      firstName = "Al",
      lastName = "Alexander"
    ),
    billingInfo = BillingInfo(
      creditCards = Seq(
        CreditCard(
          name = Name("Al", "Alexander"),
          number = "1111111111111111",
          month = 3,
          year = 2020,
          cvv = ""
        )
      )
    ),
    phone = "907-555-1212",
    email = "al@al.com"
  )

  val user1 = user.modify(_.phone).setTo("720-555-1212")
  val user2 = user1.modify(_.email).setTo("al@example.com")
  println(user2)

  // (2) how to update several fields at once
  val u3 = user.modify(_.phone).setTo("720-555-1212")
    .modify(_.email).setTo("al@example.com")
    .modify(_.name.firstName).setTo("Alvin")
  println(u3)

}
