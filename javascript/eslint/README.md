
# ESLint
* Open-source static code linter for ECMAScript/JavaScript code.
* Parses the code into an AST (Abstract Syntax Tree) and analyzes it for potential errors.


### .eslintrc.json
* ESLint configuration file.
* Contains rules to be used by ESLint.
* Can be placed in the root directory of the project or in a subdirectory named `.eslint`.
* Can be in JSON or YAML format.


### Running ESLint
```bash
eslint <file>
```


### Fields in ESLint config file
* **env**: Environment to run the code in. For example "browser", "node", "es2021", etc.


**Example of .eslintrc.json**
```json
{
  "env": {
    "browser": true,
    "es2021": true
  },
  "extends": [
    "eslint:recommended",
    "plugin:react/recommended"
  ],
  "parserOptions": {
    "ecmaFeatures": {
      "jsx": true
    },
    "ecmaVersion": 12,
    "sourceType": "module"
  },
  "plugins": [
    "react"
  ],
  "rules": {
  }
}
```
