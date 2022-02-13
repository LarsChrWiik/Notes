# Trait
TODO

# Sealed Trait
A **sealed trait** is a trait that can only be extended within the same file.

Sealed traits are open used instead of Enumerations.

### Example

```scala
sealed trait Answer
case object Yes extends Answer
case object No extends Answer
```
