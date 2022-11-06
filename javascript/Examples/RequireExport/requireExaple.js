
// Import from another JavaScript file. 
const functionFromFile = require('./exportModuleExample.js');

// Define varable. 
let myVal

// Use function from another file. 
myVal = 10
myVal = functionFromFile.addOne(myVal)
console.log(myVal)

// Use function from anoter file that uses a function within that file. 
myVal = 10
myVal = functionFromFile.minusOne(myVal)
console.log(myVal)
