
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

### npm versions
Shows various versions that is used in the project, such as the Node version:
```bash
npm version

# res:
{
  myApp: '0.1.0',
  npm: '7.24.2',
  node: '14.18.2',
  v8: '8.4.371.23-node.85',
  uv: '1.42.0',
  zlib: '1.2.11',
  brotli: '1.0.9',
  ares: '1.18.1',
  modules: '83',
  nghttp2: '1.42.0',
  napi: '8',
  llhttp: '2.1.4',
  openssl: '1.1.1l',
  cldr: '39.0',
  icu: '69.1',
  tz: '2021a',
  unicode: '13.0'
}
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


# NVM
NVM (Node Version Manager) is used to install and use different versions of **node.js**. It is designed to be used on a per-user basis and used through the shell.

### nvm install
Install latest version of Node.
```bash
nvm install node
```

Install spesific version of Node.
```bash
nvm install 16
```

### List node versions
```bash
nvm ls-remote
```

### nvm use
```bash
nvm use 16
# res: Now using node v16.9.1 (npm v7.21.1)
```


# NPX
npx (npm package runner). X = eXecute.

npx can be used when we want only need to download a package for a short amount of time, either for testing purposes or because we only need to run the package once.

An example of usage is when we want to create a React app. We only need to use the package "create-react-app" once:
```bash
npx create-react-app .
```


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
