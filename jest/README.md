
# Jest with Typescript

### Info
* **Jest** is able to run JavaScript tests, but not Typescript code out of the box.
* To be able to run TypeScript code, we can install **Bable**, which converts TypeScript code into Javascript code.
* Alternativly, we can use **ts-jest**.

### Babel
Babel is a widely used JavaScript transpiler that can be used to transpile a wide range of languages, including TypeScript. It is highly configurable and can be used with a variety of tools and environments. If you are already using Babel in your project, or if you prefer the flexibility and configurability of Babel, you may want to use it to transpile your TypeScript code for use with Jest.

### Ts-Jest
jest-ts is a Jest transformer specifically designed for transpiling TypeScript code. It is easier to set up and use than Babel, and it is specifically optimized for use with Jest. If you are primarily interested in using Jest to run your TypeScript tests, and you don't need the additional configurability provided by Babel, jest-ts may be a better choice.

### Setup (Ts-Jest)
installing ("jest", "@types/jest", "ts-jest")
```
npm install --save-dev jest @types/jest ts-jest
```

Run the ts-jest create config runner:
```
npx ts-jest config:init
```

Add to package json for complicity
```json
"scripts": {
    "test": "jest --watchAll --verbose"
}
```

Adding types for jest
Create jsconfig.json and add:
```json
{
    "typeAcquisition": {
        "include": [
            "jest"
        ]
    }
}
```

### --coverage
We can also check code coverage with the `--coverage` command:
```
jest --watchAll --verbose --coverage
```
* NB: 100% test coverage does not equal good tests, it just means that all code has been run at least once.


### Example test
```js
describe('tests whether addOne works', () => {

    // This is a todo and will pass the test
    it.todo('works like expected')

    // This is a real test
    it('works like expected 2', () => {
        const myVal = 9
        const myNewVal = addOne(myVal)
        const expectedValue = 10
        expect(myNewVal).toBe(expectedValue)
    })
})
```
