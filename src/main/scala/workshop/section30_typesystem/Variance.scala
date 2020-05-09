package workshop.section30_typesystem

/*
  Assignment compatibilty has several dimensions. The object type and the
  type of its parameters. Type parameters can be covariant the object type
  cannot. What's the difference? Covariant parameters allow subclassing.
  Defintions:
  ==========
  covariant: converting from wider(Animals) to narrower(Cats)
  contravariant: converting from narrower to wider Triangles->shapes
  invariant: not able to convert
  covariant -> Triangle is a subclass of Shape
  invariant -> List<String> is not a subclass of List<object>
    imagine this scenario. I assign a List<String> to a List<Object>.
    later I attempt to put a HashMap<String,String> into the List.
    Should I be able to do this? If List<String> was covariant
    with List<Object> I should because Hashmap is an object. To
    avoid this problem we make the types invariant.
  Scala differs from java in that it allows the specification
  of covariant, invariant, and contravariant types. This is expressed
  through the + or - annotations.
  Side note one difference between scala and java is that
  Arrays in Scala are Invariant while they are covariant in
  java.
  Usage:
  with great power comes great responsibilty. So how should we use
  these features. Here are a few guidelines...
  Immutable Collections should be covariant: They are immutable. the
  traditional issues associated with variance related to typed collections
  is not a problem because you are not able to add random items to the
  collection
  Mutable Collections should be invariant: In almost every case covariance
  is invalid when dealing with a mutable collection. Read example above.
*/
object VarianceApp{

  def main(args: Array[String]){
    println("Hello World!")

    //var x: Invariant[Object] = new Invariant[Object]
    //Illegal because type params are invariant by default
    //var y: Invariant[Object] = new Invariant[String]

    var x: Covariant[Object] = new Covariant[Object]
    //Legal because covariant specifies covariant type
    var y: Covariant[Object] = new Covariant[String]
  }
}

class Invariant[B]
class Covariant[+B]
class Sub[+A] extends Covariant[A]
//class Sub[A] extends Covariant[A]