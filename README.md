# API-I
A test automation solution to accept request type (GET/PUT/POST/DELETE/PATCH), request URI, request headers, request body, request parameters, expected status code, Json Paths in an excel and verify if the endpoint behaves as expected (Status code match and json paths match). This solution must be able to process multiple rows that are present in an excel.

API used - BestBuy API, Apache POI (can be found in the POM file)<br>
Excel Data - can be found on the test resources file 

## Install BestBuy API Playground
```raml
Note: Make sure you have NodeJS installed (we require version 4 or newer). 

```
Open your Terminal/cmd/power-shell and run the following commands
```raml
git clone https://github.com/bestbuy/api-playground/
cd api-playground
npm install
npm start
```

## For installing this project
```raml
- navigate to your IDE workspace in cmd/power shell/terminal
- git clone https://github.com/Git-Nayanjyoti/API-I.git
- import the already existing project in your IDE
- run the tests
```
