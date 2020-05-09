package workshop.section30_typesystem

object SelfType {

  trait User {
    def username: String
  }

  trait Tweeter {
    this: User =>  // reassign this
    def tweet(tweetText: String) = println(s"$username: $tweetText")
  }

  class VerifiedTweeter(val username_ : String) extends Tweeter with User {  // We mixin User because Tweeter required it
    def username = s"real $username_"
  }

  def main(args: Array[String]): Unit = {
    val realBeyoncé = new VerifiedTweeter("Krish")
    realBeyoncé.tweet("hi, its me")
  }
}
