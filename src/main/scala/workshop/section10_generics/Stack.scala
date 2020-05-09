package workshop.section10_generics

class Stack[T]	{
  var	elems:	List[T]	=	Nil
  def push(x:	T)	{	elems	=	x	::	elems	}
  def top:	T	=	elems.head
  def pop()	{	elems	=	elems.tail	}
  def isEmpty = elems.isEmpty
}

case class Bicycle(id: String);

object Stack extends  App {
  val stack: Stack[Bicycle] = new Stack;
  stack.push(Bicycle("cycle1"))
  stack.push(Bicycle("cycle2"))
  println (stack.top)
  stack.pop()
  println (stack.top)
  stack.pop()
  println(stack.isEmpty)
}
