# Map
A map is a collection of key-value pairs. 

### Example
```scala
val myMap = Map(("A" -> 10), ("B" -> 25))
```

### Get
```scala
myMap.get("A")  // res: Some(10)
myMap.get("C")  // res: None
```
