
# "\=\=" vs. "\=\=\="
* Strict equality \"===\" is almost always the correct comparison operation to use.
* strict equality is also used by array index-finding methods.


### Double equal \"==\"
* Means loose comparison. It will compare based on **values** after a **datatype conversion**.
* values of different types is tried to be converted to the same datatype.
* Comparison of object and primitive is transformed into the value of the object and the other primitive.
* Booleans are converted to numbers.
* Compares objects with `Object.is()`.
* `null` and `undefined` is loosly considered the same.
* `null` and `undefined` are loosly unqual to anything else.


### Tripple equal \"===\"
* Means strict comparison. It will comapre based on **values** with **no datatype conversion**.
* Neither values are converted before the comparison.
* `null` is not strictly the same as `undefined`


### Examples

```js
"A" == "A"  // res: true
"A" === "A"  // res: true
```

```js
10 == "10"  // res: true
10 === "10"  // res: false
```

```js
null == undefined  // res: true
null === undefined  // res: false
```

```js
A = 10
B = 10
console.log(A == B)  // res: true
console.log(A === B)  // res: true
```

```js
console.log(1 == true)  // res: true
console.log(1 === true)  // res: false
```

```js
console.log(NaN == NaN)  // res: false
console.log(NaN === NaN)  // res: false
console.log(Object.is(NaN, NaN))  // res: true
```

```js
console.log(+0 == -0)  // res: true
console.log(+0 === -0)  // res: true
```
