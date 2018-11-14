package ai.nodesense.composers

object ComposerBasics extends  App {
  def f(s: String) = "f(" + s + ")"
  def g(s: String) = "g(" + s + ")"

  val fComposeG = f _ compose g _
  println("fComposeG", fComposeG("yay"))

  val fAndThenG = f _ andThen g _

  println("fAndThenG", fAndThenG("yay"))



}
