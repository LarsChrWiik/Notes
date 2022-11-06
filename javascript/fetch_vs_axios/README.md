
# Fetch vs. Axios


### Fetch
```js
const requestOptions = {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json',
        'X-API-Key': 'secret',
    },
    // Need to stringify.
    body: JSON.stringify({ userId: 'Lars' })
  }

fetch(myUrl, requestOptions)
  .then(response => {
    // Need to check "ok" status.
    if response (!response.ok) {
      throw Error(response.statucText)
    }
    response.json()
  })
  .then(([data, statusCode]) => {
    ...
  })
  .catch(error => {
    console.log(error)
  })
```

### Axios
A Javascript library for making HTTP requests from Node.js or Browsers.
```js
const config = {
  url: "abc.com",
  method: "POST",
  timeout: 4000,  // 4 sec
  header: {
    'Content-Type': 'application/json',
    'X-API-Key': 'secret',
  },
  data: { userId: 'Lars' }
}

axios(config)
  .then((response) => {
    // Only "ok" response gets through, so no need to check for it.
    ...
  })
  .catch(error => {
    console.log(error)
  })
```

### Differences
* **Vanilla JS**: Fetch is vanilla javascript without the need of installment. Axios is a library and need to be installed. However, Axios is backwards compatible and supported by old browsers since it uses "XMLHttpRequest" under the hood, while fetch is more modern javascript.
* **Compilation**: Axios has to be compiled, while fetch can be read directly by browsers.
* **Timeout**: setting timeout is simpler with Axios.
* **Stringify**: Fetch needs to stringify the data before the request. Axios does not.
* **JSON reponse**: Fetch needs to process the response into a json, axois does not
* **Status code check**: Fetch needs to check the status code, while axios automatically sends status code != "ok" to *catch*.
* **Progressbar**: When downloading a lot of data, then fetch can use *readablestream*. In axios we can use axios-progress-bar, which might be easier to use.
* **HTTP interception**: Is built in to Axios and is a key feature. This is nice for authentication.
