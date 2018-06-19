package ai.nodesense.functional


/**
  * Functions that do the flattening
  */
object Loans {

  //def loan[T1, T2](f: (T1, T2) ⇒ Unit)(implicit f1: (T1 ⇒ Unit) ⇒ Unit, f2: (T2 ⇒ Unit) ⇒ Unit)
  //	= f1 { a ⇒ f2 { b ⇒ f(a, b) } }

  /*
    First round of evaluation takes 3 types
    in our case Connection, Session, User and returns a

    second round of evaluation takes 3 functions
  */
  /*
    implicit keyword makes all parameters in the list explicit
  */
  def loan[T1, T2, T3]
  (f: (T1, T2, T3) => Unit)
  (implicit f1: (T1 => Unit) => Unit,
   f2: (T2 => Unit) => Unit,
   f3: (T3 => Unit) => Unit) = f1 { a => f2 { b => f3 { c => f(a, b, c) } } }

}

object LoanExample extends App {

  import Loans._

  // create some fake types for the purpose of illustration
  type Connection = Float
  type Session = Int
  type User = String

  // implicits calling functions with loans
  implicit def withDatabase(f: Connection => Unit) = f(2)

  /*
    implicitly converts a call to withSession with
    a parameter of (Session(Int) => Unit) to the function
    f(1)
  */
  implicit def withSession(f: Session => Unit) = f(1)


  /*
    implicitly converts a call to withUser on a function of type
    User => Unit and returns that function with the String "Bob"
    applied to it.
  */
  implicit def withUser(f: User => Unit) = f("Bob")

  //conventional loan pattern results in deep nesting
  //

  withDatabase { connection =>
    withSession { session =>
      withUser { user =>
        println("Hi from the depths. cononection, session user")
      }
    }
  }

  withDatabase{ connection =>
    println(connection)
  }


  withDatabase{ connection =>
    withSession{ session =>
      withUser{ user =>
        println(connection)
        println(session)
        println(user)
      }
    }
  }

  //The result of this function is Unit
  withUser { user =>
    println("Hi from the depths.")
  }

  /*
    withUser is called (User => String) println(User) and is implicitly
    converted to f(s)=println(s) with f("Bob")
  */

  /*
    There are tons of implicit conversions happening here
    Firstly Connection, Session, and User are just aliased
    types. The second curried portion of loan which is specified
    as implicit relies on the implicit defs of withUser, such
    that application of u:User and the implicit need for a function
    typed as User => Unit invokes the implict def for withUser

  */
  loan { (c: Connection, s: Session, u: User) =>
    println(c)
    println(s)
    println(u)
    println("Hi from flatland")
  }
}