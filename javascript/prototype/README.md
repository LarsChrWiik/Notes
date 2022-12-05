# prototype

### What is prototype
* Every object has a built-in property called prototype
* The prototype is its own object that every "subclass" is pointing to
* Used for inheritence in Javascript
* Prototype is a reference to a static object containing static functions


### Prototype based vs. Class based inheritance
* The most important difference between class- and prototype-based inheritance is that:
    * A class defines a type which can be instantiated at runtime
    * Whereas a prototype is itself an object instance

Simply said, when a constructor function creates an object, it does not create it based on the constructor’s prototype; instead, it creates an object linked to the constructor’s prototype object.



When using the class pattern object, all future instances of the object **will share the same instaces of the internal functions** since it is stored within the **prototype**.
