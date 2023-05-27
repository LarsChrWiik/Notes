# Jsconfig.json
* A spesific file for javascript projects, and some frameworks that is built on top of Javascript such as React.
* TypeScript projects use **tsconfig.json**.
* If you have a TypeScript project, then you should generally move configs from jsconfig.json to tsconfig.json if possible and supported by the TS compiler.
* Used to configure various settings realted to the programming langauge and environment.


### Example of jsconfig
```json
{
  "compilerOptions": {
    "target": "es2015",
    "module": "commonjs",
    "baseUrl": ".",
    "paths": {
      "@/*": ["src/*"]
    }
  },
  "include": ["src/**/*"],
  "exclude": ["node_modules", "**/*.test.js"]
}
```
