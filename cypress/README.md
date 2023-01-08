
# Cypress

### What is Cypress
* JavaScript-based end-to-end testing tool for web applications
* Free and open source project, but it also exists an enterprise version
* Very good to test behaviour using JavaScript frameworks such as React, Angular, and Vue
* Cypress is coded using JavaScript
* Has built-in support for automatic retries, which can be helpful when dealing with flaky tests
* Some key features:
    * Easy to use
    * Fast and reliable
    * Supports reloading of pages after every test
    * Can automatically retry tests (that potentially are flaky)
    * Has good debugging tooling

### adding e2e in package.json scripts
```
"scripts": {
    "e2e": "cypress open"
}
```

### cy.get
* For cy.get, we can use any valid CSS selector, exmaple 'button' to get all buttons on the page.
* We could also use the CSS selector '#my-button', which will select the element with the id 'my-button'.
* We could also use the CSS selector '.btn', which will select all elements with the class 'btn'.

Example fetching all button elements:
```js
cy.get('button').click();
```

Example using class selector:
```js
cy.get('.btn').click();
```

Example using ID selector:
```js
cy.get('#submit-btn').click();
// or
cy.get('button#submit-btn').click();
```

Example using a spesific type of button:
```js
cy.get('button[type=submit]').click();
```


### Example of Cypress code

```js
describe('Login Page', () => {
  it('Logs in successfully', () => {
    cy.visit('https://www.example.com/login');

    // Check if title includes the word "Example".
    cy.title().should('include', 'Example');

    // Enter username and password.
    cy.get('input[name=username]').type('user123');
    cy.get('input[name=password]').type('password123');

    // Check if submit works.
    cy.get('button[type=submit]').click();

    // Check if we are redirected to the new dashboard page.
    cy.url().should('include', '/dashboard');
  });
});
```
