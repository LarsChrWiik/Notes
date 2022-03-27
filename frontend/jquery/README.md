
# JQuery (less relevant)
JQuery is **less relevant** today since several of the features that where unique in JQuery is now part of vanilla JavaScript. For example:
* **JQuery.AJAX** can be replaced with **fetch**
* **JQuery.get** can be replaced by **document.querySelector**


### JQuery
* jQuery has for a long time been the most popular **JavaScript Framework**
* JQuery's purpose is to simplify JavaScript programming
* JQuery is easy to learn


### JQuery Features
* HTML/DOM manipulation
* CSS manipulation
* HTML event methods
* Effects and animations
* AJAX Utilities


### How to add JQuery to the Browser
There are two main ways of getting JQuery for the browser.

#### Donwloading JQUery
Download from jQuery.com and dependency to project:
```html
<head>
<script src="jquery-3.4.0.min.js"></script>
</head>
```

#### Google CDN
Instead of downloading JQuery, we can link to it through the internet using CDN (Content Delivery Network).

```html
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
</head>
```

However, this created a deppendency on the CDN.


### JQuery Syntax
"**$**" = "**JQuery.**".

JQuery commands is built in the following structure:

```javascript
$(selector).action()
```

**Example**:
Hide element:
```javascript
$(this).hide()
```


### Document Ready Event
Often, we want to wait for the web page to compleate loading before executing code. This is done with:
```javascript
$(document).ready(function(){
  ...
});
```


### jQuery Selectors
Get elements with id:
```javascript
$("#myId")
```

Get elements with class:
```javascript
$(".myClass")
```

Get all elements with "\<p>":
```javascript
$("p")
```

Get all elements of class within "\<p>":
```javascript
$("p.myClass")
```
