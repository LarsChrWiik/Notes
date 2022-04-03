
# React Hooks
React hooks are used to simplify state handling without using classes, but rather using functions.


### useState
Used for easily changing state for react object and make it rerender automatically.

This is simplifying the old approach where de needed to get a spesific element by ID and then modifying the content.

```js
import { useState } from "react"

function myComponent(){

  // myVariable is the variable
  // setMyVariable is the function that updates the myVariable
  // 0 is the inital value
  const [myVariable, setMyVariable] = useState(0)

  // function to mutate myVariable
  const myFunction = () => {
    setMyVariable(myVariable + 1)
  }

  return (
    <div>
      {myVariable}
      <button onClick={myFunction}>Increment</button>
    </div>
  )
}
```

### useEffect
A function that will be called right after the page is rendered + when any rendering occur / when the provided state hooks are updated.

```js
import { useEffect } from "react"

const [myVariable, setMyVariable] = useState(0)

function myComponent(){
  useEffect(() => {
    // This will be called when the page is loaded + everytime a state is changing.
    console.log("new rendering!")
    randomURL = "https://kjdakljsdkljalsdakl"
    // API call and grab an email.
    axios
      .get(randomURL)
      .then((response) => {
        email = response.data[0].email
        setMyVariable(email)
      })
  }, [])  // [] = states you wish to trigger the "useEffect" function.

  return (
    <div>
      {myVariable}
    </div>
  )
}
```

### useLayoutEffect
Same as `useEffect` but it is called **before** the page is rendered. This means it is also called before `useEffect`.

```js
import { useEffect } from "react"

const [myVariable, setMyVariable] = useState(0)

function myComponent(){
  useLayoutEffect(() => {
    console.log("this is called before the page is loaded")
  }, [])  // [] = states you wish to trigger the "useLayoutEffect" function.

  return (
    <div>
      {myVariable}
    </div>
  )
}
```


### useRef
Manipulate DOM elements (outside of what React fixes for us).

```js
import { useRef } from "react"

function myComponent(){

  // This is simply a pointer that can be set to any object.
  const inputRef = useRef(null)

  const myClickEvent = () => {
    inputRef.currect.value = ""  // Clear the input field
  }

  return (
    <div>
      {myVariable}
      <input type="text" placeholder="type something here..." ref={inputRef}/>
      <button onClick={myClickEvent}>clear</button>
    </div>
  )
}
```


### useContext
Used to manage state without using props. But this introduces global states.

**Main.js**
```js
import { useState, createContext } from "react"
import myOtherComponent from "./myOtherComponent"

// Exporting the context to other files can use it.
export const AppContext = createContext(null)

function myComponent(){

  const [username, setUsername] = useState("")

  // The username below will be modified from another file using "setUsername" through "AppContext".
  return (
    <AppContext.Provider value = {username, setUsername}>
      <div>
        {username}
      </div>
      <myOtherComponent />
    </AppContext.Provider>
  )
}
```

**myOtherComponent.js**
```js
import { createContext } from "react"
import { AppContext } from "./Main"

function myOtherComponent(){

  const { username, setUsername } = useContext(AppContext)
  const inputRef = useRef(null)

  const myClickEvent = () => {
    setUsername(inputRef.currect.value)
    inputRef.currect.value = ""
  }

  return (
    <div>
      <input type="text" placeholder="change username here..." ref={inputRef}/>
      <button onClick={myClickEvent}>submit</button>
    </div>
  )
}
```
