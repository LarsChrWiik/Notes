
# TypeScript


### What is TypeScript
* Built and maintained by Microsoft
* A superset of JavaScript
* Adds strong typing (static typing) using type annotations
* TypeScript is compiled down to JavaScript, and it must be complied before it can be run the browser
* Typescript supports both object oriented and functional programming (same as Javascript)
* Integrats well with frontend framewors such as React and Angular


### Installing TypeScript Compiler
```bash
sudo npm install -g typescript
```
You can now run typescript code using `tsc`, example:
```bash
tsc main.ts
```


### Installing TypeScript for Node
```
npm install -g ts-node
```


### Automatic global variables
Without top-level import or export declarations, the typescript file gets treated as a script whose contents are available in the global scope.
This means that a normal looking "script" will export its declarations to others files!

This can be prevented by ending the file with:
```ts
// ...code...
export {};
```


## Typing

### Functions
```ts
function createStartRowPawns(color: Color){
    return Array(8).fill(new Pawn(color))
}
```

### Types Objects / Dictionaries
```ts
const PieceMap: { [key: string]: string } = {
    Pawn: 'P',
    Rook: 'R',
    Knite: 'H',
    Bishop: 'B',
    Queen: 'Q',
    King: 'K'
  }
```


### Testing frameworks for Typescript
* **Jest**:
  * Most popular testing framework for javascript for a few years
  * Works with Node, TypeScript, Reract, Angular, Vue, Svelte, and Babel
  * Created and maintained by Facebook
  * Jest is strongly inspired by Jasmine
  * Good performane compared to Jasmine due to parallelisation
  * Jest comes recommended by React
* **Jasmine**:
  * Known to be out-of-the-box and strait forward
  * Works well for Node and browser
  * Was initally created to be language independent and used for browsers, so it also works with Python and Ruby for example
  * Jasmine is recommended as a first choice when using Angular
* **Mocha**:
  * The second most popular testing framework for JavaScript
  * Very lightweight
  * It is a test framework and is not a test-runner or built in assertion tools, and no mocking tools
  * It is normal to use plugins with Mocha such as Chai. Other options are should.js, Express.js, Unexpected and Better-assert.
  * It is a bit harder to get started with due to additional config setup
  * Does not support parallel testing
  * It was initially created for Node.js, but has been extended to frontend frameworks such as React, Angular and Vue
* **Chai**:
  * It simply provides an API for assertions (should, expect or assert)
  * Assertion library most commonly used to complement Mocha
  * But can be paired with all javascript testing frameworks
  * Can be used for Node.js and browser frameworks
* **Cypress**:
  * Used for end to end testing.
  * Has built-in support for automatic retries to retry flaky tests


### The "unknown" type
* The Known should be used instead of any when we know we will set the type at a later time.
* It can also be used to do downcasting in hierarchical programming.

The unknown type is commonly used to avoid the any type. Instead of having no type or any type, we assign it to unknown. Everything assigned to this type will result in an error unless you assign it to another type at some point.

Example:
```ts
let myThing: unknown;
```


### The "never" type
* The never type is used to indicate that the type is never going to be needed.
* The "never" type is only a tool for annotating your code, and does not have any special behavior or runtime effects.
  * Function: A function with a return type of never indicates that the dunction will never return.
  * Value: A value with the never type cannot be assigned. This functionality is useless.
  * Function parameter: A function with a parameter of type never indicates to other developers that this function should never be used with this parameter.

**Function**:
```ts
throwError(msg: string): never {
  throw new Error(msg)
}
```
```ts
function infiniteLoop(): never {
  while (true) {
  }
}
```

**Variable**.
```ts
let x: never;  // Thiss value is never assigned to anything
```

**Function parameter**:
```ts
function processData(data: string) {
  // function body
}

function foo(x: never) {
  // This function is never supposed to be called with a value for x.
  // If it is called with a value for x, it is a bug in the code.
  throw new Error("This function should not be called with a value for x");
}

let data: string | undefined;

if (data !== undefined) {
  processData(data);
} else {
  foo(undefined);
}
```


### The "is" functionality
* The "is" word is used to cast the input parameter for the user of the function so we do not have to check types for the user.

Example of using **Polimophism** and returning downcasting the type as the return of the function:
```js
function isDog1(animal: Animal): animal is Dog {  // <--- Returning Dog type.
  if (animal instanceof Dog) return true
  return false
}

function isDog2(animal: Animal): animal is Dog {  // <--- Returning Dog type.
  if (animal instanceof Dog) return true
  return false
}

function doSomething(animal: Animal) {
  if (isDog1(animal)) {
    animal.bark()  // Type error, Animal does not have functional called "bark"!

    // What we have to do is:
    (animal as Dog).bark()  // This works, but it is ugly since the downcasting is dependent on the function isDog1 in this case.
  }
  if (isDog2(animal)) {
    // The type of animal in here is now Dog and the text editor now understands it.
    // It works because isDog2 uses "animal is Dog".
    animal.bark()
  }
  ...
}
```


### The "satisfies" operator
* Introduced in Typescript 4.9.
* Used to infer the type of the object from the "interface".
* This means that when we use the object afterwards, we can use functions from attributes that has optional or conditional values.


Old way:
```ts
type interface User {
  id: number,
  firstName: string,
  lastName: string,
  yearBorn: number | string,
}

const myUser: User {
  id: 1,
  firstName: 'John',
  lastName: 'Doe',
  yearBorn: "1950",
}

const myUser.yearBorn.??? // <-- the type of myUser.yearBorn is unknown here since it can be number of string.
```

Instead we can use "satisfied":
```ts
type interface User {
  id: number,
  firstName: string,
  lastName: string,
  yearBorn: number | string,
}

const myUser {
  id: 1,
  firstName: 'John',
  lastName: 'Doe',
  yearBorn: "1950",
} satisfies User

const myUser.yearBorn. // <-- yearBorn is a String! we can use String functions here and the text editor understands it.
```


### Enum mistake
Do not create enums without values, since then they become numbers.

```ts
enum Status {
  inProgress,  // This is inferred as 0
  Success,  // This is inferred as 1
  Fail,  // This is inferred as 2
}

Status(100)  // This is a legal input.
```

A better way is to use strings as values:
```ts
enum Status {
  InProgress = 'InProgress',
  Success = 'Success',
  Fail = 'Fail',
}
```


### Utility functions
*** **Omit**: TODO.
*** **Partial**: TODO.
*** **Record**: TODO.
***

