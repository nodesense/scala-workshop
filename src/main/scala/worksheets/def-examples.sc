// return type is inferreced to Int
def add (a: Int, b : Int ) = a + b

// explicit return type

def sub(a: Int, b: Int): Int = a - b;

// with brace/multi-line

// type inference, no need for return
// result of last expr, considered as return
def mul(a: Int, b: Int) = {
  println("A ", a, "B", b);
  a * b
}

// using return statement, requires explicit return type

def div(a: Int, b: Int): Int = {
  println("A ", a, "B", b);
  return a / b;
}

println("Add ", add (10, 20))

println("Sub ", sub(20, 10));

println("Mul ", mul(20, 10));

println("Div ", div(20, 2))
