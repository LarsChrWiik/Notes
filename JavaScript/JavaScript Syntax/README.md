# JavaScript Syntax


## The Console (in browsers)
We can print to the browser developer tool with the **console.log**, **console.error**, **console.warning** command.
```js
console.log("Hello World")
console.error("This is an error")
console.warn("This is a warning")
```

We can also measure time taken using **console.time()** and **console.timeEnd()**. 

### Printing Variables
```js
console.log("My name is " + name + " and I am " + " age years old")
```
```js
console.log(`My name is ${name} and I am ${age} years old`) // Must be ` not " nor '. 
```


## Variables
We have three variable types in JavaScript:
* **var** (old): var is globally scoped, its old and we should avoid using it
* **let** (Added with ES6): let defines a variable that can be reassigned later
* **const** (Added with ES6): const defines a constant. This should allways be used unless we want to reassign the value



## Use Strict
We can force JavaScript to throw exceptions by adding **"use strct"** on top of the script:
```js
"use strict"
```

It can also be added on top of a function to make just that function comply to the strict mode:
```js
function myFunction() {
  "use strict"
  x = 10 // This with cause an error since x is not declared. 
}
```



## Types

### Primitive Data Types
* **String**: Strings are immutable, which means that we cannot replace a single character with a new character.
```js
const name = "Mark Zuckerberg"
```

* **Number**: There is no "float" of "integer" in JavaScript. Number can be **NaN**, which means **Not A Number**. 
```js
const age = 34
```
```js
const pi = 3.141592
```

* **Boolean**: Either "true" or "false". 
```js
isNice = true
```

* **null** / **undefined**: null and undefined are both used to represent the absence of some value. 
```js
let x = null
let y = undefined
```

* **Symbol**: Symbols are completely unique identifiers with static properties (similar to ENUM). 

* **String, Number and Boolean as objects**: It is also possible to initialize String, Number and Boolean as objects. However, initializing primitive types with **new** is not recomended, since **===** is a conparison function that compares the data type.
```js
const myString = new String("Mark Zuckerberg")
```
```js
const myNumber = new Number(100)
```
```js
const myBoolean = new Boolean(true)
```


### Typeof
We can use **typeof** to check the type of an attribute JavaScript: 
```js
let age = 50
console.log(typeof(age))  // Res: "number"
```
| Command  | Returns |
|------|--------|
| typeof("Bob") | string |
| typeof(3.14) | number |
| typeof(NaN) | number |
| typeof(false) | boolean |
| typeof([1,2,3,4]) | object |
| typeof({name:'Bob', age:50}) | object |
| typeof(new Date()) | object |
| typeof(function () {}) | function |
| typeof(myUndefinedVariable) | undefined |
| typeof(null) | object |


### Type Conversion

#### Convert String to Integer:
```js
Number("42")  // res 42 of type "number"
parseInt("10.5")  // res: 10 of type "number"
parseFloat("10.5")  // res: 10.5 of type "number"
```

#### Convert Integer to String:
```js
const myNewString = String(15)  // res: 15 of type "String"
const myNum = 15
const myNewString = myNum.toString()  // res: 15 of type "String"
```

#### Convert String to Boolean:
```js
const myBool = myValue === 'true'
```


## If Statement / Conditionals
```js
if (age1 == 18 && age2 != 18 || age3 == 20) {
    ...
} else if (age === "23") {
    ...
} else {
    ...
}
```

Oneline if-else sentence. 
```js
let age = 17
let myCondition = age >= 18 ? "You are of legal age" : "You are underage"
```

### "==" vs. "==="
* **Double equalsign** (==) is used to compare **values**
* **Tripple equalsign** (===) is used to compare **datatypes**

Example:
```js
null == undefined  // res: true
null === undefined  // res: false
```


## Array
An Array in JavaScript is actually an ArrayList and supports functions such as **push**, **pop**, **shift**, **unshift**, **Length**, etc.

There are two main ways of initializing an Array. 
Initializing the Array as an object:
```js
const numbers = new Array(5,3,"Hello",2)
```

Or using the bracket [] notaiton:
```js
const numbers2 = [5,3,"Hello",2]
```

### Array Mutation
Arrays that are declated as "**const**" can still be mutated using bracket notation. 
```js
const myArray = [1,2,3]
myArray[1] = 10
```

### Add / Remove elements in an Array
| Command  | Description |
|------|--------|
| push | add to end |
| pop | remove last |
| shift | remove first |
| unshift | add to front |
| splice | cut items from given possitions |

### Array.length
```js
const myArray = [5,3,4,2,1]
let myLength = myArray.length
```

### Array.sort()
**Array.sort** sorts the array
```js
let myArray = [8,4,6,0,2,7]
myArray.sort()  // res: [0, 2, 4, 6, 7, 8]
```

A sort function can be added to compare elements. 
```js
function customSortFunc(a, b) {
  ...
}

let myArray = ...
myArray.sort(customSortFunc)
```

### Array.find() and Array.findIndex()
The **find** function returns the first element in an Array that satisfies a condition from a given function. 
```js
const myArray = [50, 39, 60, 10, 38]
myArray.find(x => x > 55)  // res: 60
```

The **findIndex** is exactly the same as the **find** function, but findIndex returns the index instead of the element:
```js
const myArray = [50, 39, 60, 10, 38]
myArray.findIndex(x => x > 55)  // res: 2
```


## Unpacking / Spread operator
The spread operation "..." is used to convert an array of elements into several individual elements. An example is that it converts ([1,2,3]) to (1,2,3).

This has several use cases such as copying arrays, concatinating arrays, destructuring, and spreading the elements in an array to use them as function parameters instead of the array itself. 
```js
const myArray = [1,2,3]
const myArrayCopy = [...myArray] // This will copy myArray.
```


## Loops

### For
```js
for (let i = 0; i < 10; i++){
    ...
}
```

### Foreach (indexes)
**index** is the index in myArray. The value can be accessed with myArray[i]. 
```js
for (let index in myArray) {
  console.log(myArray[i])
}
```

### Foreach (values)
```js
for (let value of myArray) {
  console.log(value)
}
```

### Foreach "entries" (index, value)
Same as "enumerate" in Pyhton:
```js
for (let [index, value] of myArray.entries()) {
  ...
}
```

### Foreach functional
```js
myArray.forEach(function(x){
    ...
})
```
Same with syntactic sugar:
```js
myArray.forEach(x => {
    ...
})
```

### While
```js
let i = 0
while (i < 10){
    ...
    i++
}
```

### Do While
```js
let i = 0
do {
   ...
   i++
} while (x < 10)
```


## Switch Sentence
```js
switch (age) {
    case 17:
        ...
        break
    case 23:
        ...
        break
    default:
        ...
        break
}
```


### Class Pattern Object (ES6)
This is the new and **noraml way** of creating classes in ES6+ world.

When using the class pattern object, all future instances of the object **will share the same instaces of the internal functions** since it is stored within the **prototype**. 
```js
class Person {
  constructor(name, age) {
    this.name = name
    this.age = age
  }
  myFunction() {
    ...code...
  }
  static myOtherFunction() {
    ...code...
  }
}

let bob = new Person("Bob", 50)
```

### Constructor Pattern Object (ES5)
This was the old way of creating classes in ES5 world.

When using the constructor pattern object, all future instances of the object **will create its own instace of the internal functions** since it is not stored within the **prototype**. 
```js
function Person(name, age){
  this.name = name
  this.age = age
  
  this.myFunction = function() {
    ...code...
  }
}

let bob = new Person("Bob", 50)
```

To share the same function for every Person objects, we can add functions to the **protptype** manually. 
```js
let Person = function(name, age) {
  this.name = name
  this.age = age
}

Person.prototype.getAge = function() {
  return this.age
}

let bob = new Person("Bob", 50)
```


## Object

### Object Literal
Object literals are key-value pairs, kind of like a dict in Python, but with the ability to apply funcitons to itself! Nested object literals are allowed. 

The object literal pattern should be used if we want to create a data structure with no initalization time and no need for constructor, dependency injection, etc.
```js
let person = {
    firstName: 'Bob',
    lastName: 'Smith',
    age: 50,
    childeren: ['John', 'Emily'],
    address: {
        street: 'Charles Street',
        city: 'Boston'
    },
    fullName: function(){
        return this.firstName + " " + this.lastName
    }
}
```

### Object Destructuring
Instead of getting values from objects one by one:
```js
const fName = person.firstName
const lName = person.lastName
```

We can use **destructuring assignment**: 
```js
const { firstName, lastName } = person
```

### Making an object inmutable (Object.freeze)
**Object.freeze** can be used to freeze the state of an object in JavaScript by making it immutable, i.e. you cannot change its properties. This also applies for Arrays, since an Array is an object. 
```js
let myFreezedObject = Object.freeze(myObject)
```

### Class Object Inheritance
```js
class Customer extends Person {
  constructor(name, age, customerID) {
    super(name, age)
    this.customerID = customerID
  }
}
```


## Map, Filter, Reduce, FlatMap

### Map
```js
const myArray = [1,2,3,4,5]
myArray.map(x => x + 10)  // res: [11,12,13,14,15]
```

### Filter
```js
const myArray = [1,2,3,4,5]
myArray.map(x => x != 3)  // res: [1,2,4,5]
```

### Reduce
```js
const myArray = [1,2,3,4,5]
myArray.reduce((prev, curr) => prev + curr)  // res: 6

// 0 is the init value of curr.
myArray.reduce((prev, curr) => prev + curr, 0)  // res: 6
```

### FlatMap
Map + flatten. Flatten will flatten arrays. Empty arrays are removed.
```js
// Task: Transform an array with true and false to 1 and 0 and remove nulls.
const messyData = ["true", "false", null, undefined, "true", "false"]
messyData.flatMap(x => {
    if (x != null) {
        return x === "true" ? 1 : 0
    }
    else {
        return []
    }
})
// res: [1, 0, 1, 0]
```
Compressed syntax:
```js
messyData.flatMap(x => x != null ? x === "true" ? 1 : 0 : [])
// res: [1, 0, 1, 0]
```


## Functions

### Standard Function
```js
function addTen(x) {
  return x + 10
}

addTen(5)  // Returns 15
```

### Function Expression / Anonymous
```js
let addTen = function(x) {
  return x + 10
}

addTen(5)  // Returns 15
```

### Arrow function
```js
let addTen = (x) => {
  return x + 10
}

addTen(5)  // Returns 15
```
With syntactic sugar:
```js
let addTen = x => {
    return x + 10
}
addTen(5)  // Returns 15
```


### Short Arrow Function (approach 4)
```
let addTen = (x) => x + 10

addTen(5) // Returns 15
```

### Function with default value
```
function addTen(x=0) {
  return x + 10
}
```

### Function with n arguments
```
function addNumbers(...args) {
  ...code...
}
```

### Function return with condition
```
function ifExists(key, array) {
   return array[key] || "No such item in array"
}
```

### Function with imidiate execution (Lambda function)
```
(() console.log("this is a function"))()
```
```
((x) => x**2)(3) // This will return 9
```

### Function Argument Destructuring
We can specify what elements to use from the input Object. 
Argument Destructuring is often used with JSON calls / API calls.
```
function myFunction5({ firstName, lastName, age}) {
  ...code...
}
```


## Object to JSON
An Object can be converted to JSON format with the JSON.stringify() function:
```js
const myObjects = [
  {
    id: 1,
    firstName: "bob"
  },
  {
    id: 2,
    firstName: "John"
  }
]

JSON.stringify(myObjects)
/*
res: 
{
  {
    "id": 1,
    "firstName": "bob"
  },
  {
    "id": 2,
    "firstName": "John"
  }
}
*/
```


## Import and Export modules
The main way to import and export JavaScript files in Node.js is by using the **require** statement and the **modules.export** statement. 

Another way of sharing modules were introduced in ES6 with the satements **import** and **export** / **export defaults**. 

### Require / Modules.export (Standard)
```js
// Define function in another file (otherJsFile.js)
exports.addOne = function (x) {
  return x + 1
}
```
```js
// Import the function using require. 
const functionsFromFile = require('./otherJsFile.js');
const myVal = functionsFromFile.addOne(10) // myVal is 11. 
```

### Import
```js
// Define function in another file (otherJsFile.mjs)
function addOne(x) {
    return x + 1
}

export { addOne }
```
```js
// Import the function using import from ES6. 
import { addOne } from "./otherJsFile.mjs"
const myVal = addOne(10) // myVal is 11
```

### Import JQuery in HTML vs Modern Node
Modern way of importing JQuery:
```js
import jQuery from “jQuery”;
```
Old way of importing JQuery:
```js
<script type="text/javascript" src="jQuery.js"></script>
```

*npm update* can be used to update the modules when using *import*. This is much better than updating the html code maually.


## Fetch and Promise
Fetch and promise in JavaScript are used to handle **asynchronous** calls.

### Promise
A promise contains a function with two parameters (**resolve**, **reject**).
*resolve* and *reject* are callback functions.

A promise can be in different states:
* **pending**: waiting to get data. 
* **fullfilled**: successfully resolved. 
* **rejected**: some error happend. 

A promise uses **then** and **catch** statements.
* **then**: receives an executable function when the promise has been *fullfilled*. 
* **catch**: receives an executable function when the promise is *rejected*. 

```js
let promise1 = new Promise( (resolve, reject) => { ... } );
```

### Fetch
Fetch is function that inputs a URL and converts it into a Promise. 
```js
let myPromise = fetch("https://api.github.com/users/LarsChrWiik")
```

Fetch and fill the Promise return functions **then** and **catch**: 
```js
fetch(myURL)
  .then((data) => {
    return console.log("It worked!")
  })
  .catch((error) => {
    return console.log("It did not work!")
  })
```

### Fetch vs jQuery.ajax()
* fetch does not reject HTTP error status if it is 404 or 500, but rather sets "*ok*" status to *false* and will only reject if there is a network error. 
* fetch wont send of recieve cookies by default. If the site relies on authentication sessions, then the requests will be unauthenticated. 

### Creating a Promise:
```js
function mySuccessFunction(data) {
  console.log("It worked!")
}
function myErrorFunction(error) {
  console.log("It did not work!")
}
let myPromise = fetch(myURL)
myPromise.then(mySuccessFunction)
myPromise.catch(myErrorFunction)
```
