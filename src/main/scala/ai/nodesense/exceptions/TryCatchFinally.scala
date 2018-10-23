package ai.nodesense.exceptions

object TryCatchFinally extends  App {
  try
  {
    // your scala code here
  }
  catch
    {
      case _: Throwable => println("Got some other kind of exception")
    }
  finally
  {
    // your scala code here, such as to close a database connection
  }
}
