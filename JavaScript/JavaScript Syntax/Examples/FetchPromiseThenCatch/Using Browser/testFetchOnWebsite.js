
fetch("https://api.github.com/users/LarsChrWiik")
    .then((data) => {
        return data.json()
    })
    .then((myJson) => {
        myJsonKeys = Object.keys(myJson)
        console.log("json.name = " + myJson.name)
    })
    .catch((error) => {
        console.log(error)
    })
