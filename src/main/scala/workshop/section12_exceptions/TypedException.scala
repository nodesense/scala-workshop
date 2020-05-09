package workshop.section12_exceptions

object TypedException extends  App {

  @throws(classOf[Exception])
  def throwError = {
    throw new Error("Boom")
  }

  throwError
}
