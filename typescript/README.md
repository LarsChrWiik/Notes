
# TypeScript


### What is TypeScript
* Built and maintained by Microsoft
* A superset of JavaScript
* Adds strong typing using type annotations
* TypeScript is compiled down to JavaScript


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
