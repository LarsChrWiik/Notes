
// Needed in Node (and not while using a Browser). 
const fetch = require("node-fetch")

myURL = "https://api.github.com/users/LarsChrWiik"

console.log("before")

fetch(myURL) // This call will be made asynchronous
    .then((data) => {
        return data.json()
    })
    .then((myJson) => {
        myJsonKeys = Object.keys(myJson)
        console.log("")
        console.log("json keys: " + myJsonKeys)
        console.log("")
        console.log("json.name = " + myJson.name)
    })
    .catch((error) => {
        console.log(error)
    })

console.log("after")