# Functional Programming

### Higher order functions
Higher order functions are functions are has a **fuinction** as input and outputs **->** another **function**.

Functions are first class values in Scala.

### Creating functions
```scala
val myFunc = (x: Int) => x + 5

// The above is syntactic sugar for:
val myFunc = new Function1[Int, Int] {
    override def apply(x: Int) = x + 1
}
```

### Identify function
Is a function that allways returns the same value that was used as its argument. In recursion, this is the base case.

```scala
def nTimes(f: Int => Int, n: Int): Int => Int = {
    if (n == 0) f  // Identify function
    else (x: Int) => nTimes(f, n-1)(x)
}
```

### Map
Avaliable for Scala collections.
```scala
val myList = List(1,2,3)
myList.map(x => x * 2)  // res: List(2,4,6)
```

### Filter


### Reduce


## Flatten


### FlatMap


### Apply
Used when we wish to allow objects to be invoked like functions. 
Example:
```scala
class Applicable {
    def apply(x: Int) = x + 1
}

val myApplicable = new Applicable
myApplicable.apply(1)
myApplicable(1)  // Same as above
```
