
# Router
* Page routing / changing page content is handled by the browser
* React will inject the given page component into the "top level component"
* Results in less requests to the server


### Install
npm install react-router-dom


### Example
* We need to have all other component within the Router component.
* Pages should be in the Routes component that is within the Router component.

```js
import { BrowserRouter as Router, Route, Routes } from "react-router-dom"

function App() {
  return (
    <Router>
      <div className="App">
        <Routes>
          <Route exact path="/" element={ <MyHomePage /> } />
          <Route exact path="/about" element={ <MyAboutPage /> } />
          <Route exact path="/models:uniqueId" element={ <MyModelPage /> } />
        </Routes>
      </div>
    </Router>
  )
}
```
* NB: In v5, `Routes` is called `Switch`


### Router parameter
```js
import { useParams } from "react-router-dom"

export function MyModelPage() {

  const { uniqueId } = useParams()

  return (
    <div>
      <h1>uniqueId</h1>
    </div>
  )
}
```


### Router Links
* If we want to redirect to pages within our page components, we can use a router link
* Link components will allow the router to read the URL and match using the Router

```js
import { Link } from "react-router-dom"

// Replace
<a href="/about">My link button</a>
<a href={`/model/${uniqueId}`>My model link</a>
// With
<Link to="/about">My link button</Link>
<Link to={`/model/${uniqueId}`}>My model link</Link>
```


### How to step fetch when redirecting
We might have a fetch running a page when we route to to another page. We might have an issue if this is the case. But we can do a cleanup before the redirect.

```js
useEffect(() => {

  // We need to connect this abort controller signal with the fetch.
  const abortController = new AbortController()

  setTimeout(() => {
    myFetchFunc("myUrl", { signal: abortController.signal })
      .then(res => {
        // code
      })
      .catch(error => {
        if (error.name !== "AbortError"){
          // change states
        }
      })
  }, 1000)

  // Apply cleanup
  return () => abortController.abort()
}, [])
```
