
# JavaScript/Node Packaging


## npx
npx stands for **N**ode **P**ackage **E**xecute.

npx is usually used to execute a package (usually for install packages).
```bash
npx create-react-app .
```


## nvm
NVM stands for **N**ode **V**ersion **M**anager and is used to install and use different versions of **node.js**. It is designed to be used on a per-user basis and used through the shell.


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


## npm
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
```


### npm install
Update/Create the **package-lock.json** and **node_modules**.
```bash
npm install
# or
npm i
# for clean-install
npm ci
```

Install new modules:
```bash
npm install express
```
* The **node_modules** folder contains downloaded dependencies from NPM that is usually not push to your repository.
* The **package-lock.json** file describes the exact installment tree that should be pushed to your repository.


### npm ci (lock files)
Install all exact version dependencies from a **package-lock.json** file.
```bash
npm ci
```
* Does not writes to package.json or package-lock.json.


### Uninstall package
```
npm uninstall packageName
```


### .npmrc
* The **.npmrc** file is used to configure npm on a per-project basis.
* The **.npmrc** file is usually located in the root directory of the project.
* Examples are fields in the **.npmrc** file:
    * registry: The URL of the npm registry to use.
    * prefix: The location to install global packages.
    * proxy: The URL of the proxy server to use.
    * engine-strict: If set to true, then npm will exit with an error instead of a warning when the current Node.js version is not supported by the package.
    * save-exact: If set to true, then npm will save exact versions of installed packages instead of using npm’s default semver range operator.
    * cache: The location of npm’s cache directory.


## Yarn
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



