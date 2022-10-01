# Shopify

### Shopify Themes
* a Shopify theme is a template that merchants use on their ecommerce stores.


### Online Store 2.0
* A set of features that makes themes and theme apps easier to building.
* Allows the use of custom App Extentions that allows App Blocks within themes.


### App blocks / Theme App Extension
* UI components that can be customised and configured through the theme editor.
* Is essentially a "block" (or container) of code that can run on your Theme/Page.
* App blocks can only be used with Online Store 2.0 themes.


### How to build an App extention:
```
Shopify extention create
```


### App embeds
* Is floating elements within a site. For example, a chat bubble.


### Web Components
* Web components are components that are compatible with most web standards.
* Is essentially HTML code that can be used in any website.


### Requirements to building a Shopify App
* Correct verison of Ruby
* Shopify CLI
* ngrok


### Create Shopify app (React)
```bash
shopify app create node
```


### Setup tunnel to ngrok
```bash
shopify app tunnel auth <TOKEN>
```


### Serve the app
```bash
shopify app serve
```


### run dev app
This will run the app so it is visible in your Shopify store under `apps`.
```bash
npm run dev 
```


### Shopify Polaris
https://polaris.shopify.com/
* Shopify Polaris is a design system for Shopify partners.
* The design patterns make the apps consistent and arguably easier to build.
* The goal is to make the Shopify apps familiar to mercants without learning curves.
* Provides developers with a styling guide and a libary of UI components.
```jsx
import { Heading, Page, Button } from "@shopify/polaris";
```


### Shopify core commands
https://shopify.dev/themes/tools/cli/core-commands
* help
* login
* logout
* populate
* store
* switch
* version
* config
* whoami


### Shopify custom component on Page
* iFrame:
    * Fastest and easiest way to embed a form into your Shopify page.
* Javascript Embedded Code:
    * TODO


### Custom app integration
2. The Store owner logs into Shopify and enables custom app integration
3. The Store owner creates a custom app that they call `MyCustomApp`
4. The Store owner adds the required access we need `read access to products`, etc. 
5. The Store owner clicks install App. This generates two secrets: `Admin API access token` and a `StoreFront API access token` that is unique for this app and permissions.
6. These access tokens can then be used to interact with the Shopify store
    * The access tokens should only be shared with trusted applications.
