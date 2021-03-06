# Scala-Info

### Overview
* Scala smoothly integrates features of object-oriented and functional languages and Scala is compiled to run on the Java Virtual Machine
* Scala is a pure object-oriented language in the sense that every value is an object. However, Scala is also a functional language. Functions are values and values are an objects, so functions are actually objects. 
* Scala allows anonymous functions, higher-order functions, nested functions, and supports currying. 
* Scala is statically typed but does not expect you to provide type information. 
* Scala is compiled to Java Byte Code, which can be executed by the Java Virtual Machine. This means that Java and Scala has the same runtime environment. 
* Scala can execute Java code. 

### What Scala has that Java does not
* All types are objects
* Type inference
* Nested Functions
* Functions are objects
* Traits: A trait is like an interface with a partial implementation. In scala, trait is a collection of abstract and non-abstract methods. 
* Closures ???
* Domain Spesific Language Support ???



# Scala-Syntax
Learn TODO:
* foldLeft and foldRight
* groupBy

Reading S3 lines and splitting it into a Map[String, List[String]]
```Scala
val deletion_map: Map[String, List[String]] = {
  val source = scala.io.Source.fromFile(filename)
  try
    source.getLines().foldLeft(Map.empty[String, List[String]]) {
      case (acc, line) =>
        if (line == "") acc
        else {
          val bucket_obj = line.split("/", 2)
          val bucket = bucket_obj(0)
          val obj = bucket_obj(1)
          val existingObjects = acc.getOrElse(bucket, List())
          acc.updated(bucket, obj :: existingObjects)
        }
    }
  finally source.close()
}
```

# Setting up Intellij with Scala (Gradle)
See: https://github.com/LarsChrWiik/Spark-Info/tree/master/SparkSetupTemplate

### Gradle
Gradle is an open-source build automation tool that can build almost any type of software. The following is a high-level overview of some of its most important features:
* Fast / High performance
* Runs on JVM and requires a Java Development Kit (JDK) installed to use it.
* Project conventions
* IDE support
* Insight when building projects
