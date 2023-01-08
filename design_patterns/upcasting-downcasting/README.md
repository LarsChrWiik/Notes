# Upcasting and Downcasting
* Used to change the class type of objects in hierarchical programming.
* Should be used with caution.
* Neither Upcasting or Downcasting is Polymorphism. But we can use Upcasting and/or Downcasting in a function to achieve Polymorphism.

In general, it is a good idea to use upcasting to make your code more flexible and extensible, but to avoid downcasting unless it is absolutely necessary.

A good alternative to downcasting is to use polymorphism.

### Upcasting
* Upcasting is when a subclass is casted to a superclass.
* Upcasting is not Polymorphism. That is when we override or overload functions / classes in hierarchical programming.

**Upcasting is generally considered to be a good design pattern**.

Example Dog is cased to Animal:
```js
class Animal {
  name: string;

  ...
}

class Dog extends Animal {
  breed: string;

  ...
}

const dog = new Dog('Fido');

// Upcast the `dog` object to an `Animal` object
const animal: Animal = dog;
```


### Downcasting
* Downcasting is when a parent class is casted to a subclass.

**Downcasting, on the other hand, is generally considered to be a risky design pattern, because it requires you to make assumptions about the type of an object.**.
* It can result in a runtime error

Example Dog is cased to Animal:
```js
class Animal {
  name: string;

  ...
}

class Dog extends Animal {
  breed: string;

  ...
}

const myAnimal = new Animal('Fido');

// Downcasting the `animal` object to a `Dog` object
const myDog = myAnimal as Dog;  // NB: This can produce a runtime error.
```

Example of using **Polimophism** to bypass downcasting issues (**bad pattern**):
```js
function printInfo(animal: Animal): void {
  console.log(`Name: ${animal.getName()}`);
  if (animal instanceof Dog) {
    console.log(`Breed: ${animal.getBreed()}`);
  } else {
    console.log(`Breed: Unknown`);
  }
}
```
