
import { addOne, minusOne } from "./exportExample.mjs"

// Define varable.
let myVal

// Use function from another file.
myVal = 10
myVal = addOne(myVal)
console.log(myVal)

// Use function from anoter file that uses a function within that file.
myVal = 10
myVal = minusOne(myVal)
console.log(myVal)
