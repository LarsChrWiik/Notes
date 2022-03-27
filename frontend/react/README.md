
# React

### Creating a React app
```bash
npx create-react-app ./
```

This will create three folders:
* **node_modules**: All dependencies
* **public**: index.html and web icons
* **src**: source code folder.


### React folder structure
```python
├── package-lock.json
├── package.json
├── node_modules  # Folder with installed node packages
│   ├──  ...
├── public
│   ├── index.html  # HTML with a div poinitng to "root"
│   ├── manifest.json  # Usually used by mobile phones
│   └── robots.txt  # Crawler helper

└── src
    ├── index.js  # React starting point. Renders "App" in "root"
    ├── App.js  # the "App" element to be displayed (essentially the entire website itself)
    ├── components  # Presentational react components (cares about look)
    │   ├── myComponent1.jsx
    │   ├── myComponent1.css  # Optional
    │   ├── myComponent2.jsx
    │   ├── myComponent3.jsx
    │   └── index.js  # File that exports components (only used for simplified imports outside this folder)
    ├── containers  # Complex components using backend operation and state handling (cares about how things work)
    │   ├── MyContainer
    │   │   ├── myContainer1.jsx
    │   └── index.js  # File that exports components (only used for simplified imports outside this folder)

    # Extra
    ├── assets  # example folder (images, icons, fonts, etc)
    ├── utils  # example folder (utulity functions, colors, etc)
    ├── hooks  # example folder (react hooks in a separate folder)
    ├── form  # example folder (form validations)
    ├── api  # example folder (handle networking)
    ...  # and more
```


### React App
```javascript
import React from 'react'

const App = () => {
  return (
    <div>My APP!</div>
  )
}

export default App
```

**Note**: This can be created with "rafce" with the correct extention in vscode.


# Popular React UI Component Libraries

### Chakra-UI


### Ant Design


### Material-UI


### Bootstrap


# Popular React libraries

### react-icons

### react redux
State management.

### Axios

