
# Express
Express is a backend web-application framework for Node.

(Similar to **Flask** in Python)


### Creating endpoint
```javascript
var express = require('express'); // Get the module

const app = express()
const port = 3002


app.get('/myEndpoint', (request, response) => {
   getTransactionScore(request.headers.token).then(
      totalScore => response.send({totalScore})
   ).catch(error => console.log(error))
});


app.listen(port, (err) => {
  if (err) {
    return console.log('This didnt really work out...', err)
  }
  console.log('Listening on port ', port)
});
```

Calling the endpoint;
```bash
curl myEndpoint:3002
```
