# Polymorphism
Polymorphism is a concept in object-oriented programming (OOO) that refers to the ability for a single entity, such as a function or object, to have multiple forms. It allows you to write code that is more flexible and extensible. By using polymorphism, you can write code that can adapt to different situations and scenarios, rather than having to write separate code for each possibility.

There are several types of polymorphism.

### Function overloading
This refers to the ability to create multiple functions with the same name, but with different signatures. This allows the function to behave differently depending on the number and/or type of arguments it is called with.
```js
function greet(name) {
  console.log(`Hello, ${name}`);
}

function greet(firstName, lastName) {
  console.log(`Hello, ${firstName} ${lastName}`);
}
```

### Function overriding
This refers to the ability to create a function with the same name and signature as a function in a parent class, and have it override the parent class's function. This allows subclasses to provide their own implementation of a function that is inherited from a parent class.
```js
class Animal {
  speak() {
    console.log('Animal sound');
  }
}

class Dog extends Animal {
  speak() {
    console.log('Woof');
  }
}
```

### Type inheritance
This refers to the ability to create a new type that is a subtype of an existing type. The new type is said to "inherit" the properties and methods of the existing type, and can also have additional properties and methods of its own.
```js
class Animal {
  name: string;
}

class Dog extends Animal {
  breed: string;
}
```
