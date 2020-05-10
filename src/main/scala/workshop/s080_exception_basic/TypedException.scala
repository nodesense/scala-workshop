package workshop.s080_exception_basic

object TypedException extends  App {

  @throws(classOf[Exception])
  def throwError = {
    throw new Error("Boom")
  }

  throwError
}
