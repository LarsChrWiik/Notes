# Web scraping


### What is web scraping?
Web scraping is the process of extracting data from websites. It is also known as **web harvesting** or **web data extraction**. Web scraping is a form of copying in which specific data is gathered and copied from the web, typically into a central local database or spreadsheet, for later retrieval or analysis.


### Web scraping vs. web crawling
Web scraping and web crawling are often confused.

**Web scraping** is a technique to extract data from a website. It involves making HTTP requests to a website's server, downloading the HTML content of the web page, and then parsing that HTML data to extract the data you're interested in.

**Web crawling** is the process of automatically *navigating* through multiple web pages and scraping data from each of them. A web crawler starts with a list of URLs to visit and then follows links on those pages to other pages, repeating the process until it has visited every page on the site. The goal of web crawling is to extract data from as many pages as possible - making it a more comprehensive approach to data collection compared to web scraping.

The key difference between the two is the scope of the data collection, with web scraping being more limited and web crawling being more comprehensive.


### Sitemaps
A sitemap is an **XML** file that lists the URLs for a website, along with additional metadata about each URL such as when it was last updated and relevance of pages.

Sitemaps are used by search engines to understand the structure and content of a website, but they can also be used by web scraping and web crawling tools to help guide the process of extracting data from a website. Sitemaps are important for web scraping and web crawling because they provide a way for the scraper or crawler to efficiently discover the URLs on a site that contain the data they are interested in.

Without a sitemap, a scraper or crawler would need to start at the homepage and follow links to other pages on the site, which can be time-consuming and may not cover all the URLs on the site.


### Frameworks for web scraping
There are many web scraping frameworks available for Python, including:
* **Scrapy**: A web crawling framework for Python.
* **BeautifulSoup4**: A Python library for parsing HTML and XML documents.
* **Selenium**: A Python library for automating web browsers.
* **Puppeteer**: A Node library which provides a high-level API to control Chrome or Chromium over the DevTools Protocol. It provides a high-level API for controlling browser behavior and extracting data from web pages.
* **Playwright**: A Node library which provides a high-level API to control Chromium, Firefox, and WebKit with a single API.


#### Scrapy
* Scrapy is a web crawling framework for Python.
* Scrapy makes it easy to write scripts (also called spiders) that defines your web scapers.
* 45 000+ stars on GitHub.
* Scrapy is maintained by Zyte (formerly Scrapinghub)


#### BeautifulSoup4
* Is a Python library for extracting data from HTML and XML files
* Provides a simple and intuitive API for extracting data from web pages.
* You can do multiple things such as searching for all instances of a particular HTML tag, or find all elements with a specific attribute value.
* Built-in support for handling common web scraping tasks.


#### Selenium
* Selenium is the most extensively used and well-liked web testing solution available today.
* Is a program to automate web browser interaction.
* Supportes multiple browsers such as Firefox, Chrome, and Safari.
* Selenium is not a web scraping framework, but it can be used to automate the process of web scraping.
* Selenium is useful for web scraping because it can be used to simulate a user's interaction with a website, such as clicking on links and filling out forms. And also loading javascript content.
* Is supported in multiple languages such as JavaScript, Python, Java, C#, and Ruby.
* Supports headless browser functionality.


### Headless Browser
A headless browser is a web browser without a graphical user interface (GUI), meaning that it doesn't have a visual interface for the user to interact with. Instead, it is controlled programmatically through a command-line interface or an API. Headless browsers are typically used for automated testing and running scripts, as well as for web scraping and other server-side tasks. They allow developers to simulate a web browser's behavior and to interact with websites and web applications as a user would, but without the overhead of a GUI, making them faster and more efficient for these tasks.

Selenium is not a headless browser by itself, but it does provide the capability to run tests in a headless mode.
