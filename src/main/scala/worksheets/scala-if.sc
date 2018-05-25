var i = 10;

var result = if (i % 2 == 0) "even" else "odd";

def isEven(n : Int) = if (n % 2 == 0) "even" else "odd"

def isOdd(n : Int) = {
  if (n % 2 == 1)
    true
  else
    false
}

println("isEven ", isEven(11));

println("isOdd 10", isOdd(10));

println("isOdd 11", isOdd(11));