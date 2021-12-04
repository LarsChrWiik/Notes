
# CSS
* CSS = Cascading Stylesheet.
* CSS is not a programming language, but a styling language that are used for website design and layout.
* CSS3 is mostly used, which is an extention to the basic CSS. 


## There are 3 ways of adding CSS styling:
* **Inline CSS**: Within the HTML code. (**Bad practice**).
* **Internal CSS**: Using \<style\> tags within the HTML code. (**Kind of bad practice**).
* **External CSS**: Linking to an external CSS file (within the header). (**Best practice**).


### How to link HTML to external CSS:
```html
<link rel="stylesheet" href="style.css" />
```


## Notations

### Object notation
```css
body {
    background-color: rgb(240, 240, 240);
    color: #555;
    font-family: Calibri;
    font-size: 20px;
    line-height: 1.5em;
    margin: 0;
}
```

### Class notation
```css
.myContainerClass {
    width: 80%;
    margin: auto;
    overflow: hidden;
}
```

### ID notation
* Styling for id's are using "#" notation.
```css
#myContainer1 {
    float: right;
    width: 30%;
    background: #333;
    color: #fff;
    padding: 10px;
    box-sizing: border-box;
}
```


## Size unit
* px = pixel
* em = relative unit
* fr = fractions


## Box Model
![](images/boxmodel.jpg)


## Positioning:
* **Static (default)**: Render in order of the document flow.
* **Relative**: Relative to the normal position.
* **Absolute**: Target what position we want inside a relative element.
* **Fixed**: A fixed position to a browser window.
* **Initial**: Set property to default value.
* **Inherit**: will inherit from parent.
