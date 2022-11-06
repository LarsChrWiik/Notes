
### Function Component vs. Class Component
Function conponent is the standard nowdays.

**Function Component**
```js
function FunctionalComponent = () => {
 const [count, setCount] = React.useState(0);

 return (
   <div>
     <p>count: {count}</p>
     <button onClick={() => setCount(count + 1)}>Click</button>
   </div>
 );
};
```

**Class Component**
Contains a constructor.
```js
class ClassComponent extends React.Component {
 constructor(props) {
   super(props);
   this.state = {
     ...
   };
 }

 render() {
   return (
     <div>
       ...
     </div>
   );
 }
}
```
