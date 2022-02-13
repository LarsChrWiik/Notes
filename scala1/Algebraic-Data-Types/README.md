# Algebraic Data Types

### About AND / + / Product
{ Cat, Dog, Mouse } AND { Left, Right} = 3 items + 2 items = 5 items

### About OR / Sums
{ Cat, Dog, Mouse } AND { Left, Right} = 3 items + 2 items = 5 items

### A is B "OR" C
**OR** logic can be represented as a **Trait** in Scala.
```scala
sialed trait A
final case class B() extends A
final case class C() extends A
```

A sealed trait is basically the same as sialed abstract class.

### A is B "AND" C
**AND** logic can be represented as a **case class** in Scala.
```scala
final case class A(b: B, c: C)
```

You cannot extend a case class from a case class. But a class can extend a case class.




# MOVE!
Strucutreal recursion can allways be used on algebraic datatypes. It relates to proof by induction.

In structural recursion, you have a case for each branch in the logical OR. We can do this with:
* **Pattern matching** (with case "all cases must be implemented")
  * Implement the stuff in the trait, while something else extends this trait
* **Polimorphism**
  * Implement the stuff in the case class that extends a trait.

Trade-off with **pattern matching** vs **Polimorphism**:
* Pattern matching -> all code is in one place.
* Polymorphism might be more familiar to people
* Allows pattern matching to be used outside of the trait when appying case classes. And when we use pattern matching, we will 

# MOVE 2!
What is "sealed" in "sealed trait"?

When a trait is "sealed" all of its subclasses are declared within the same file and that makes the set of subclasses finite which allows certain compiler checks.


# MOVE 2 - Method call notation!
a.b(c) = a b c
Example:
myList map myFunc
Same as:
myList.map(myFunc)


# MOVE 3 - 
Map and FlatFlat are functions for Monad.


# MOVE! - MapN
TODO


# MOVE! - Sequence
```scala
List(Option(1), Option(2)).sequence // Some(List(1, 2))
```

# MOVE! - Tupled
```scala
List(Option(1), Option(2)).sequence // Some((1,2))
```

# MOVE! - Combine
```scala
List(Option(1), Option(2)).sequence // Some((1,2))
```

# MOVE! - Traverse
```scala
List(Option(1), Option(2)).sequence // Some((1,2))
```

# MOVE! - Type Equations
**map**
```
F[A] map (A => B) = F[B]
```

**FlatMap**
```
F[A] flatMap (A => F[B]) = F[B]
```

**Cats |+|**
```
A |+| A == A
```

**MapN**
```
(F[A], F[B], ..., F[N]).mapN((A, B, ..., N) => Z) == F[Z]
```

# MOVE! - Semigroups
???

# MOVE!
FP:
* Uses Sealed Trait to create case classes, that allows pattern-matching
* This means we cannot add case classes if we do not have access to the sealed trait file

OO:
* Uses Traits as Interfaces (not Sealed Traits)
* We create things that "extends" the trait


# MOVE! - Property based testing
Also called Generative testing.
* Generate test inputs and test eveything. 
* Tested general properties, for example, "This function should always return non-negative numbers"
* 

# MOVE! - Metamorphic testing
* If I transom the input in a spesific way, does the output stay the same?

# MOVE! - MapN
MapN = Flatmap + map.

