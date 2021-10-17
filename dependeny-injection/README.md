# Inversion of Control
The Inversion-of-Control (IoC) pattern is all about redirecting to some external handler/controller instead of acting itself directly.

IoC is inverting the controll flow to a generic framework. This is in contrast to traditional **procedural programming**.

The dependency injection pattern is a subset of the inversion of control pattern.

Inversion of control is used to **increase modularity** of the program and make it extensible.



# Dependency Injection
When we pass an objects its properties, we have **dependency injetion**. The Dependency Injection (DI) pattern is all about separation of concern.

The DI pattern usually allows services to depend on interfaces, rather than other objects.

Types of depedency injection:
### Construction injection

Passing properties within the constructor. This type of injection is the most common one.

Example of constuctor injection:
```python
class Service:

    def __init__(self, db: Database):
        self.db = db
```

Example without constuctor injection:
```python
class Service:

    def __init__(self):
        self.db = Database()
```


### Method Injection 
In Method Injection, we supply the dependency class/object through a public method.
```python
class Consumer

    def create_new_database(db: Database):
        self.db = dep

    def do_something()
         self.db.do_stuff()
```


### Property Injection 
In Property Injection, we call a public property/function that will initialize a dependency for us, which can later be used.

This pattern should often be avoided.

Example:
```python
class Consumer

    def create_new_database():
        self.db = Database()

    def do_something()
         self.db.do_stuff()
```

# Dependency Injection Lifetime
* **Singelton**: Allways the same instance of the dependent class/object throughout the timelife of the application.
* **Transient**: Allways creates a new instance of the dependent class/object service when asked for it.
* **Scoped**: The dependent class/object is the same within the scope, but resets when the scope resets.



## Advantages of Dependency Injection
* Easier testing - Mocking dependencies are easier with the DI pattern
* Allows separation of concern
* Decrease tight coupling between classes/dependencies by removing the clients knowledge of how its dependencies are implemented.
* Components become more reusable
* Code becomes more flexible - since we can replace components with new components that fufills the interface we are interface with
* Config is hidden from the application code
* DI makes it easier for multiple programmers to work on the same project since it isolates classes functions

## Disadvantages of Dependency Injection
* Forces unnecessary abtractions and complexity by introducting more classes, which might be hard to manage - when it could have been implemented with mich fewer lines of code
* Produces more lines of code
* Makes code difficult to trace since it separates interface from implementation
* Might introduce reflection and/or dynamic programming instead of potentially eaiser to understand functional programming
* Encourage dependence on a framework


### What is reflection?
Reflection modifies the runtime behavior of any class. Example trying to use a function if it exists:
```java
Method method = foo.getClass().getMethod("doSomething", null);
method.invoke(foo, null);
```
