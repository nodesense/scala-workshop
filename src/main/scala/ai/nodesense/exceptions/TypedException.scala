package ai.nodesense.methods

object TypedException extends  App {

  @throws(classOf[Exception])
  def throwError = {
    throw new Error("Boom")
  }

  throwError
}
