
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
