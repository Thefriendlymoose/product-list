# ellos-test

## What it does
This application has one endpoint and its purpose is to get the data in JSON available in this ellos url:
``https://www.ellos.se/api/articles`` with the help of query parameters ``?path=pathHere``, then parse the 
data and convert it into this [result](#results). In addition to the path query parameter, the endpoint has a 
filter query parameter to allow filtering of the result. In addition to the products that are given in the result 
there is an additional field called "averagePrice" that is the average price of all the products in the result.

## Versions
- OpenJDK 22

## Run Instructions
To run the application you have two choices run using docker or using your IDE.

### Docker
To run using docker open your terminal in the root folder of the project and run the following commands

``docker image build -t ellos-test .``

wait for the image to be built then run:

``docker container run -p 8080:8080 ellos-test``

### IDE
To run using your IDE (intellij). Ensure you have OpenJDK 22 installed then open the project in your IDE, open pom.xml and download all dependencies.

## Available Endpoints
The application has one available endpoint
``/products`` with mandatory query parameter ``?path=pathHere`` and optional query parameter ``?filter=filterHere``.

## Examples
Example get requests:

#### Without filter
``http://localhost:8080/products?path=barn%2Fbabyklader-stl-50-92``


#### With filter
``http://localhost:8080/products?path=barn%2Fbabyklader-stl-50-92&filter=set``

## Results
When calling the endpoint products you will receive a JSON object in the below form.
```
{
    "products": [
        {
            "sku": "123456",
            "name": "example"
            "size": "10"
        }
    ],
    "averagePrice": 299.999
}
```
If the path query parameter is not supplied then you will receive a 400 BAD REQUEST response