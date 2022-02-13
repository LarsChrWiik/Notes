
# TODO
Move?

# REST API
REST API (also called RESTful API) is an Application Programming Interface (API) using the Representational State Transfer (REST) style.

### REST
REST is a set of architectural constraints, not a protocol or a standard.

Information is transfered over HTTP with a given data representation, which can be several formats such as:
* JSON (Javascript Object Notation)
* Protobuf
* HTML
* plain text

**JSON** is most popular data representation to use since it is language-agnostic as well as easily human readable.

### API 
An Application Programming Interface (API) is used to allow different systems to communicate together. When two systems communicate, one system is the **client** that makes a request, while the other system is the **server** that recieves the request and returns the response.

### Headers and Parameters
Headers and parameters are important in the HTTP methods of a RESTful API HTTP request. They can contain imporant identifier information such as:

### URL Parameters (query string)
URL parameters are basicly variables the user can provide what will be used within the server. The parameters/varaibles can for example be used to filter content for the website. 

URL parameters start with "**?**" followed by a "**variable=value**" and then followed by "**&variable=value**" for as many variables we wish to add.

We also have *path* parameter**: 
```
https://www.facebook.com/bob.hansen
```
where **/bob.hansen** is the path parameter. Often used for IDs.

Example of filtering a stock price graph for a given *company* with a given *metric* type for a given *date*:
```js
examplewebsite.com/mypage?company=dnb&date=2020-02-10&metric=intraday
```

Example of language of home page:
```js
examplewebsite.com/home?lang=fr
```

Example of a search:
```js
examplewebsite.com/search?q=christmas
```

#### Concerns with URL Parameters
* Several parameters = several possible combinations to construct a valid URL. Google might mark such URLs as "low content" sites with little traffic.
* Tracking tools such as Google Analytics are based on exact URLs. Having many different URLs will cause these tools to create different traffic reports for each unique URLs.

#### URL Parameters best practices
* Adding a **canonical tag** that points to the non-parameter version.
* For URLs where content changes based on prameters, make sure we wish these pages to be ranked uniquely.
* Use hreflang annotation instead of language parameters. 

### Pagination
Pagination can be used for webistes to limit data transfor between server and client when the client. Basically, the clinet revies a certain page from the server that is displayed, and if the client wishes to display the next page, another call to the server must be made. The response from the server contains the number of pages, so if a developer wishes to loop over all pages, he first needs to make an initial call to get the "max_page" nuber.
