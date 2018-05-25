var numbers:List[Int] = List.range(1, 10);

// var list = 1 to 5;
var list = 1.to(5)

for(i <- numbers) println(i)

for(i <- list) println(i)

for (i <- 1 to 5   ) println(i)


for (i <- 1 to 10 if i % 2 == 1) println(i)

// for loop with nesting
for(  i <-  1 to 3;
      j <- 1 to i)
    println(i, j);

for {
  i <-  1 to 3
  j <- 1 to i
}
  {
    println(i, j)
  }

