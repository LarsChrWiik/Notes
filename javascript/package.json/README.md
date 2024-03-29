
# Package.json
* For for javascript projects to manage dependencies and scripts.
* Contains information such as the project name, version, description, author, scripts, dependencies, etc.
* The package.json file is used to give information to npm to allow it to identify the project as well as handle the project's dependencies.
* The package.json file is normally located at the root directory.
* Used for React, Vue, Angular, Node.js, etc.
* Example of json keys in package.json:
    * **devDependencies**:
    * **dependencies**:
    * **scripts**: Used to create custom cli commands such as mapping "npm test" to "jest --watchAll --verbose" or "npm start" to "npm run start".
    * **main**: The entry point of the project
    * **name**:
    * **version**:
    * **description**:
    * **author**:
    * **license**:
    * **repository**:


### Package-lock.json
* A file created by npm to lock dependencies to a specific version.
* This is done to ensure that the same dependency versions are installed on all machines.
* This file is automatically generated for any operations where npm modifies either the node_modules tree, or package.json.


### Typescript and package.json
* Typescript projects also use package.json and package-lock.json to manage dependencies.
