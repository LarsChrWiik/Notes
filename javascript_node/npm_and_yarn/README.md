
# NPM
**NPM** stands for **N**ode **P**ackage **M**anager and is the default package manager in Node.js JavaScript runtime environment.

NPM consist of two components:
* A **commandline tool** using for setting up projects and installing additional dependencies.
* An **online database** that contains public and paid-for packages (called NPM registry).


### npm init
Creates **package.json**.
```bash
npm init
```


### npm install
Update/Create the **package-lock.json** and **node_modules**.
```bash
npm install
```
Or:
```bash
npm i
```

Install new modules:
```bash
npm install express
```
* The **package-lock.json** file describes the exact installment tree that should be pushed.
* The **node_modules** folder contains downloaded dependencies from NPM that is usually not push.


### npm ci (lock files)
Install all exact version dependencies from a **package-lock.json** file.
```bash
npm ci
```
* Does not writes to package.json or package-lock.json.


# Yarn
Similar to **npm**, **yarn** is a JavaScript package managers.
Some people prefer yarn, others npm.

NB: yarn uses Facebook’s npm registry mirror, which means that some meta-data are sent to Facebook.


### Installing yarn
Yarn can be installed with npm or brew:
```bash
npm install yarn --global
```
or
```bash
brew update
brew install yarn
```

### yarn init
Yarn commands are similar to npm:
```bash
yarn init
```

### yarn install
```bash
yarn install
```

### yarn add
```bash
yarn add [package]
```

### yarn remove
```bash
yarn remove [package]
```
