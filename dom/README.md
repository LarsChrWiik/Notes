
# DOM
**DOM**: Document Object Model.

The DOM is basically the user interface to inderact with the website. JavaScript can use the HTML DOM to access and change all the elements of an HTML document.


### DOM vs JQuery '$'
**JQuery** has long been used to support DOM manipulation, but recent updates has made **JQuery less relevant** since several of the features that where unique in JQuery is now part of vanilla JavaScript.


### DOM Tree
* **window**: is the parent object of the browser view. The window object is **this** in JavaScript.
* **document**: is the entire HTML code, which is basically the entire web page. *document* is inside *window*.

Example usage:
```javascript
const myElem = document.querySelector(".myId").firstChild
```
```javascript
const myElem = document.querySelector(".myId").parentNode
```

The DOM tree:
<br>
<img src="images/traversing_the_DOM.png" width="500">
<br>

More example usage:
```javascript
const myElement = document.querySelector(".myId")
myElement.style.background = '#333'
```

```javascript
const myElement = document.querySelector(".myId")
myElement.innerText = 'This is my new text'
```

```javascript
const myElement = document.querySelector(".myId")
myElement.innerHTML = <div><button>This is a button</button></div>
```


### Single element selectors:
Recommended selector function:
```javascript
document.querySelector(".myId")
```

Old selector function:
```javascript
document.getElementById("myId")
```


### Multi element selectors:
For classes and tags:
```javascript
document.querySelectorAll(".item") // return a NodeList.
```

Old way:
```javascript
document.getElementByClassName("myClassName")
```
```javascript
document.getElementByTagName("myTagName")
```


# DOM Manupulation

### Creating Elements
```javascript
const myLi = document.createElement('li')
myLi.className = 'myClass'
myLi.id = 'myId'
myLi.setAttribute('title', 'My new Title')
myLi.appendChild(document.createTextNode('Hello World'))
```

This HTML code is essentially creating:
```html
<li class='myClass' id='myId' title='My new Title'>Hello World</li>
```


# Remove Elements
```javascript
const myElement = document.querySelector(".myId")
myElement.remove()
```


### Event-Listener
```javascript
addEventListener(myEventType, myFunction)
```

Evenet listeners in JavaScript requires two inputs:
* The event type
* A callback function

Example usage:
```javascript
const btn = document.querySelector("myClassName").addEventListener('click', function(){
  console.log("this event was triggered")
})
```

We can also provide a custom function instead of an anonymous callback function:
```javascript
function myOnClickFunction() {
  console.log("this event was triggered")
}
const btn = document.querySelector("myClassName").addEventListener('click', myOnClickFunction)
```

The callback function can take en **event object** *e* as a parameter.
The *e* is the event, which can be used to extract the event information.
```javascript
const btn = document.querySelector("myClassName").addEventListener('click', function(e){
  const myId = e.target.id // target is the object that was triggered.
  console.log("this event was triggered by " + myId)
})
```


### EventListener using HTML
JavaScript events can also be triggered from HTML code. There are several event types dependent on the object that is used, for example a button:
```html
<script>
function myFunction(){
  ...code...
}
</script>

<button onClick="myFunction()">Click this button</button>
```

We can also access the object by sending **this** as the input parameter:
```html
<script>
function myFunction(x){
  console.log(x.value)
}
</script>

<button onClick="myFunction(this)">Click this button</button>
```


### Commonly used Event Types
* click = single click
* dbclick = double click
* mouseenter = mouse entered the object
* mouseleave = mouse left the object
* mousemove = mouse is moving
* keydown = when a letter is pressed on the keyboard
* focus = when an object becomes in focus
* cut = when we cut something
* paste = when we paste something
* input = any input such as cut, paste, type, etc...
* And many more...


### Form Validation using document.forms
Form validation is used to validate forms.

```html
<form method="post" action="myServerSidePage.php" name="myForm" onsubmit="return myValidation()">
  <input type="text" name="myTextField" id="myTextField" />
  ...form code...
</form>

<script>
function myValidation(){
  // Get value from the textfield myTextField within the form.
  const myField = document.forms["myForm"]["myTextField"].value

  if (myField == null) {
    // Stops the submission of the form.
    alert("Fill the textfield!")
    return false
  }
  return true
}
</script>
```
