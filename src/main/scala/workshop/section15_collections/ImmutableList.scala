package workshop.section15_collections

object ImmutableList extends  App {
  val brands: List[String] = List("Apple", "Google");

  val names= "iPhone" :: ("Galaxy" :: ("Nexus" :: Nil))

  val age = Nil

  println( "Length of names array : " + names.length)
  println( "Head of names array : " + names.head )
  println( "Tail of names array : " + names.tail )
  println( "Check if names is empty : " + names.isEmpty )
  println( "Check if age is empty : " + age.isEmpty )

  val country_1 =  List("India","USA","France")
  val country_2 = List("Austria","Belgium","Canada")

  val country = country_1 ::: country_2
  println( "country_1 ::: country_2 : " + country )

  val cont = country_1.:::(country_2)
  println( "country_1.:::(country_2) : " + cont )
  val con = List.concat(country_1, country_2)
  println( "List.concat(country_1, country_2) : " + con  )

  println("Country List reversal :" + country.reverse)
  println("Country List after reversal :" + country)

  val namesFilled = List.fill(6)("phone")
  println(namesFilled)

  // :: has right associativy
  val nums = 1 :: (2 :: (3 :: (4 :: Nil)))
  println("nums ", nums);


  case class Mobile(title: String, price: Int)
  val phones = Seq( Mobile("Moto", 15000),
    Mobile("iPhone", 40000),
    Mobile("Galaxy", 35000),
    Mobile("MI", 20000) )
  println("MaxBy ", phones.maxBy(phone => phone.price))
  println("MinBy ", phones.minBy(phone => phone.price))

  // filters
  val filteedList = phones.filter(phone => phone.price >= 25000);
  println("Filtered list >= 25000 ", filteedList)

  val phones1 = List("iPhone 5", "iPhone 6")
  val phones2 = List("Nexus 5", "Nexus 6")
  val phones3 = List("Moto G", "Moto G Plus")

  val allPhones = List(phones1, phones2, phones3)

  println("All Phones ", allPhones)

  allPhones.map (println(_))


  println("Flatten ", allPhones.flatten)

  // union, substraction, intersect
  val num1 = Seq(1, 2, 3, 4, 5, 6)
  val num2 = Seq(4, 5, 6, 7, 8, 9)
  //List(1, 2, 3)
  println("diff", num1.diff(num2))
  //List(4, 5, 6)
  println("intersect", num1.intersect(num2))
  //List(1, 2, 3, 4, 5, 6, 4, 5, 6, 7, 8, 9)
  println("union", num1.union(num2))

  println("Distinct ", num1.union(num2).distinct)

  val numbers = Seq(1, 2, 3, 4, 5, 6, 7, 8, 9)

  //(List(2, 6, 4, 2), List(3, 7, 9, 5, 1))
  println("Partition", numbers.partition(n => n % 2 == 0))

  println("Fold Left", numbers.foldLeft(0)((res, n) => res + n))


  val words = Seq( "mango", "apple", "orange", "tomato")
  println("Words ", words.foldLeft(0)((resultLength, word) => resultLength + word.length))

  println("Words contact fold left ", words.foldLeft("")((resultLength, word) => resultLength + word))
  println("Words contact fold right ", words.foldRight("")((resultLength, word) => resultLength + word))
  println("Words contact fold ", words.fold("")((resultLength, word) => resultLength + word))

  println("Words contact fold left iteration ", words.foldLeft("")((resultLength, word) => {
    println("Result Length ", resultLength, "Word", word)
    resultLength + word
  }))


  println("Words contact fold iteration ", words.fold("")((resultLength, word) => {
    println("Result Length ", resultLength, "Word", word)
    resultLength + word
  }))

  println("Sorted ", numbers.sorted)

  println("Sorted desc", numbers.sorted(Ordering[Int].reverse))

  println("sorted ordering by desc", phones.sorted(Ordering.by((_: Mobile).price).reverse));

  println("sorted ordering by asc", phones.sorted(Ordering.by((_: Mobile).price)));

  println("Sort by ", phones.sortBy(_.price)(Ordering[Int].reverse))
}
