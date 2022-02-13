# JavaScript
* JavaScript is a programming language to make web pages interactive
* JavaScript is a scripting language and lightweight
* JavaScript is highlevel (a lot of abstraction)
* JavaScript is interpreted (it can be run without a compiler)
* JavaScript is dynamically typed, meaning that we do not need to add types and it does type checking at run-time as opposed to compile-time (statically typed). However, we can use TypeScript to add types to JavaScript.
* JavaScript conforms to ECMAScript (a JavaScript standard meant to ensure the interoperability of web pages across different web browsers). 
* JavaScript can be run:
    * On the client/browser (**Frontend**). 
    * A server using Node.js (**Backend**).
    * For mobile developmenet with **React Native**. 
    * For desktop applications with Electron JS. 
* JavaScript is a **prototypal object oriented language**, meaning that objects directly inherit from other objects.



## ES6
ES6 was a major enhancement of JavaScript and was published in **2015**, see: http://es6-features.org/#CurrencyFormatting.
* **ES6** is also known as "**ECMAScript 6**", "**ECMAScript 2015**", and "**JavaScript 6**"
* ES6 gave a lot of new functionality such as:
  * let and const
  * Exponentiation operator "\*\*" (same as the "pow" function) 
  * Default parameter values in functions
  * Array.find()
  * Array.findIndex()
  * The class keyword



## Running JavaScript Code

### JavaScript with HTML
Referencing a seperate ".js" file (**Recomended**)
```html
<header>
  <script src="main.js"><script>
</header>
```

Incorporating the JavaScript inside the HTML code using \<script>.´
```html
<body>
  <script>
    let x = 10
    console.log(x)
  </script>
</body>
```

### Using Node.js
A JavaScript file can be run using Node.js from the terminal by running the command:
```bash
node myJsFile.js
```


## Class
Classes, Arrays, and Functions are all objects. Essentially, everything in JavaSCript is an object except for the primitive data types. JavaScript is a **prototypal object oriented language**, meaning that objects directly inherit from other objects. 

Functions within objects that uses the **class** keyword are automatically put in the **prototype** (like in any other language with inheritance). This ensures that all instances of the object-type shares the same instance of the function-object. This is more efficient, compared to having the function within the object itself (like the constructor pattern), since it is then replicated for all instances of the object. 
