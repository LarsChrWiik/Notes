# Scala Notes

### Scala overview
* Runs on the Java Virtual Machine (**JVM**) and can execute Java code
* Supports both **object-oriented** programming and **functional programming**
* **Compiled language**
* **Statically typed**, but infers the type if not provided
* Scala is compiled to Java Byte Code

### Requirements
* Installing a Java Platform Standard Edition (Java SE)
  * Example, install Open JDK, will include:
    * JVM
    * HotSpot, which is a Just-In-Time (JIT) compiler
    * Java APIs
    * Java Class Libraries
* Installing Scala

### What Scala has that Java does not
* All types are objects
* Type inference
* Nested Functions
* Functions are objects
* Traits: A trait is like an interface with a partial implementation. In scala, trait is a collection of abstract and non-abstract methods. 
* Closures ???
* Domain Spesific Language Support ???


# TODO
* Type-conversion
* Functional programming
  * Foreach
  * Map
  * Filter
  * Reduce
  * Flatten
  * FlatMap
  * Fold / FoldLeft / FoldRight
  * Fold vs Reduce
  * Apply
  * Collect
  * variance
  * find
* Pattern Matching
* Types
  * Some
  * None
* Trait / Sealed traits
* Case classes
* Expressions, types, and values
* Algebraic Data Types
* Sbt
* For "<-" syntax
* Structural recursion
* Generics
* Options
* Error handling
  * Either
  * Try
  * Promiss + Future
* Parallell programming
* Substitution
* Dependenvy injection
  * Constructor arguments
  * Reader monad
  * Interpreter pattern
* Implicit
* Monoid / free Monoid
* Monad
* Applicative / Semigroupal
* Testing
* Lazy vs. strict
* Ranges
* Higher order functions
* Proof of contradiction pattern in Scala
* Concurrency
  * Future
    * Starts running as soon as you create them.
    * You need a thread pool (ExecutionContext) available to run futures.
  * 


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
