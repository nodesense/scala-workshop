package workshop.section30_typesystem

/*
Article: http://jonasboner.com/2008/10/06/real-world-scala-dependency-injection-di/

The cake pattern is a way to do dependency injection in Scala.
Rather than using explicit xml configuration we compose our
configurations using a combination of self-typ annotations, traits,
and companion objects.

self-type Annotation
====================
This is a way to define what "this" means in a given context. This
is important because scala allows traits to contain mixin behavior.
In our example the methods defined in UserServiceComponent require
that a value userRepository exist somewhere in the final result even though
we have no idea how or where this trait will be applied.

Self-type annotations are tantamount to saying:
"I have no idea where you are going to try to mixin this trait and
I don't want limit your creativity. All I'll say is that the
UserRepositoryComponent needs to be mixed in somewhere along the line
or I'll have to compiler tear you a new one"


What the cake pattern does is allow us to compose complex objects
out of simpler well tested classes provided with satisfy the
constraints outlined by the self-type annotations.

Do we really need to wrap all our implementations in traits?
Yes if they have any dependency on mixedin state. For instance,

In our example UserServiceComponent defines the dependency
on UserRepositoryComponent. UserRepositoryComponent defines
the state userRepository. In order for the type of UserService
to have explicit access to userRepository it must be defined
within a trait that contains the self-type annotation ensuring
that this trait is also mixed with one of type UserRepositoryComponent

This above referenced article describes numerous use cases for
this pattern including wiring up a test environment with mock
implementations of the wired in components for unit testing
or providing alternate implementions in the ComponentRegistry
definition

*/

object ComponentRegistry extends UserServiceComponent with UserRepositoryComponent{
  val userRepository = new UserRepositoryAltImpl
  val userService = new UserService
}

object App{
  def main(args: Array[String]){
    println("Eat IT!");
    val userService = ComponentRegistry.userService;
    userService.create("steve", "password")
  }
}

trait UserRepositoryComponent{
  val userRepository: UserRepository
}

trait UserRepository{
  def authenticate(username: String, password:String): User
  def create(user: User)
  def delete(user: User)
}
class UserRepositoryImpl extends UserRepository {
  def authenticate(username: String, password:String): User = {
    println("authenticating user: " + username + " " + password)
    User(username, password);
  }
  def create(user: User) = println("creating user: " + user)
  def delete(user: User) = println("deleting user: " + user)
}

class UserRepositoryAltImpl extends UserRepository {
  def authenticate(username: String, password:String): User = {
    println("ALTERNATE: authenticating user: " + username + " " + password)
    User(username, password);
  }
  def create(user: User) = println("ALTERNATE: creating user: " + user)
  def delete(user: User) = println("ALTERNATE: deleting user: " + user)
}


trait UserServiceComponent{ this: UserRepositoryComponent =>
  val userService: UserService
  class UserService {
    def authenticate(username: String, password: String): User =
      userRepository.authenticate(username, password)

    def create(username: String, password: String) =
      userRepository.create(new User(username, password))

    def delete(user: User) =
      userRepository.delete(user)
  }
}
case class User(fname:String, lname:String)