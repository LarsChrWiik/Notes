# For Comprehension in Scala
For comprehension is actually an abtraction of map, flatMap, and withFilter. 

"<-" is used in for-comprehensions to separate "pattern" from "generator". "<-" is actually a flatMap.

For comprehensions does not allow the code to run in parallell.



### General Notation
```scala
for (enumerator) yield e
```



### General Notation (Multiple enumerators)
Enumerator separation is ";" when using the parentheses notation "()":
```scala
for (
    enumerator1; 
    enumerator2
) yield e
```

Enumerator separation is "\n" when using the curly braces notation "{}":
```scala
for {
    enumerator1
    enumerator2
} yield e
```



### Examples
```scala
val myList = List(10, 20, 30)
val myLisst2 = for (x <- myList) yield x+1
// myLisst2: List[Int] = List(11, 21, 31)
```

```scala
val myList = List(10, 20, 30)
val myList2 = List(5, 3, 1)
val myList3 = for {
    x1 <- myList
    x2 <- myList2
} yield x1 + x2
// myList3: List[Int] = List(15, 13, 11, 25, 23, 21, 35, 33, 31)
```



### Converting to FlatMap and Map
```scala
val myList = List(10, 20, 30)
val myList2 = List(5, 3, 1)
val myList3 = for {
    x1 <- myList
    x2 <- myList2
} yield x1 + x2
// myList3: List[Int] = List(15, 13, 11, 25, 23, 21, 35, 33, 31)
```

Is the same as:

```scala
val myList1 = List(10, 20, 30)
val myList2 = List(5, 3, 1)
val myList3 = myList1.flatMap(x1 => myList2.map(x2 => x1 + x2))
// myList3: List[Int] = List(15, 13, 11, 25, 23, 21, 35, 33, 31)
```



### For comprehension and Future
Since for comprehensions does not allow the code to run in parallell, it can be used to await for futures.

It would be the same logic as:

```scala
future1.flatMap(r1 => future2.flatMap(r2 => future3.map(r3 => r1 + r2 + r3) ) )
```
