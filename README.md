# Project Title: DummyJsonAPITesting

## Description
This project focuses on creating a structured framework for testing the **DummyJSON API**. The DummyJSON API provides a range of sample endpoints with JSON data, making it ideal for practicing and demonstrating API testing techniques. The goal of this project is to manually test these endpoints using **Postman**, followed by implementing automated tests using **Java** with **RestAssured**.

## Project Objectives

1. **Manual Testing with Postman**:
   - Test key endpoints for CRUD operations, including:
     - **GET**: Retrieve data from the API.
     - **POST**: Create new entries in the API.
     - **PUT**: Update existing data in the API.
     - **DELETE**: Remove data from the API.
   - Verify responses, including status codes and returned JSON structure.

2. **Automation Testing with RestAssured and Java**:
   - Build a reusable test suite to validate the API’s functionality and behavior.
   - Organize test scripts to ensure clarity and maintainability.
   - Implement assertions to check the correctness of responses.

3. **Test Reporting**:
   - Generate reports to track API responses, including:
     - Request parameters
     - Headers
     - Status codes
   - Provide insights into the testing process and outcomes.

## Learning Outcomes
This project serves as a comprehensive learning tool for mastering API testing fundamentals while providing a solid foundation for working with real-world APIs. It will help you understand:
- How to perform effective manual testing of APIs.
- The principles of API automation testing using RestAssured.
- How to create clear and informative reports to summarize test results.


## High-Level Functional Requirements for Testing DummyJSON API

### 1. Product Data Retrieval
- **Fetch Product List**: Retrieve a list of products, including pagination and filtering options.
- **Fetch Single Product**: Retrieve detailed information for a specific product based on its ID.
- **Search Products**: Search for products by keyword or category.

### 2. User Data Retrieval
- **Fetch User List**: Retrieve a list of users.
- **Fetch Valid Single User**: Retrieve a valid single specific user based on their ID.
- **Fetch Invalid Single User**: Retrieve a invalid single specific user based on an invalid ID.

### 3. Cart Data Retrieval
- **Fetch All Carts**: Retrieve all the current carts.
- **Fetch Valid Single Cart**: Retrieve a valid single cart using the cart id.
- **Fetch Invalid Single Cart**: Retrieve an invalid single cart using an invalid cart id.

### 4. Recipe Data Retrieval
- **Fetch All Recipes**: Retrieve all the current recipes.
- **Fetch Valid Single Recipe**: Retrieve a valid single recipe using the recipe id.
- **Fetch Invalid Single Recipe**: Retrieve an invalid single recipe using an invalid recipe id.

### 5. Error Handling and Validation
- **Invalid Request**: Test responses for invalid requests, such as incorrect URLs, missing parameters, or invalid data formats.
- **Rate Limiting**: Test the API's rate limits and error handling for exceeding those limits.
- **Server Errors**: Test the API's response to server-side errors, such as database failures or internal server errors.

### 6. Performance Testing
- **Response Time**: Measure the response time for different API endpoints under various load conditions.
- **Throughput**: Measure the number of requests the API can handle per second.
- **Scalability**: Test the API's ability to handle increased load and traffic.

## Implemented Test Cases

### 1. Product Data Retrieval Test Cases

| Test Case ID | Test Case Description     | Test Data                              | Expected Result                                         | Test Steps                                                                                                                                                  |
|--------------|---------------------------|----------------------------------------|---------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------|
| TC_01        | Fetch All Product List    | Valid pagination and filter parameters | List of products with pagination and filtering applied   | 1. Send a GET request to /products with pagination and filter parameters. <br> 2. Receive a JSON response with a list of products, pagination info, and filter results. |
| TC_02        | Fetch Single Product      | Valid product ID                       | Detailed product information                             | 1. Send a GET request to /products/{productId} with a valid product ID. <br> 2. Receive a JSON response with detailed product information.                   |
| TC_03        | Fetch Product List        | Invalid pagination parameter           | Not Implemented							               | 1. Send a GET request to /products with an invalid pagination parameter. <br> 2. Receive an error response with an appropriate error message.               |
| TC_04        | Fetch Single Product      | Invalid product ID                     | Error message indicating product not found               | 1. Send a GET request to /products/{productId} with an invalid product ID. <br> 2. Receive an error response with an appropriate error message.             |
| TC_05        | Search Products           | Valid keyword                          | List of products matching the keyword                    | 1. Send a GET request to /products/search?q={keyword} with a valid keyword. <br> 2. Receive a JSON response with a list of products matching the keyword.   |
| TC_06        | Search Products           | Invalid keyword                        | Empty list of products or error message                 | 1. Send a GET request to /products/search?q={keyword} with an invalid keyword. <br> 2. Receive an empty list of products or an error message.              |

### 2. User Data Retrieval Test Cases

| Test Case ID | Test Case Description | Test Data           | Expected Result                     | Test Steps                                                                                   |
|--------------|-----------------------|---------------------|-------------------------------------|----------------------------------------------------------------------------------------------|
| TC_07        | Fetch User List       | No specific parameters | List of users                      | 1. Send a GET request to `/users` without any parameters. <br> 2. Receive a JSON response with a list of users. |
| TC_08        | Fetch Single User     | Valid user ID       | Detailed user information           | 1. Send a GET request to `/users/{userId}` with a valid user ID. <br> 2. Receive a JSON response with detailed user information. |
| TC_09        | Fetch Single User     | Invalid user ID       | Error message indicating user not found         | 1. Send a GET request to /users/{userId} with an invalid user ID. <br> 2. Receive an error response with an appropriate error message. |

### 3. Cart Data Retrieval

| Test Case ID | Test Case Description     | Test Data                              | Expected Result                                         | Test Steps                                                                                                                                                  |
|--------------|---------------------------|----------------------------------------|---------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------|
| TC_10        | Fetch All Carts			| No required Data | All carts appears in response   | 1. Send a GET request to /carts. <br> 2. Receive a JSON response with all carts items. |
| TC_11        | Fetch Single Cart with ID     | Valid Cart ID                      | Single cart details appears in response                            | 1. Send a GET request to /carts/{cartID} with an valid cart ID. <br> 2.  Receive a JSON response with single Cart details                   |
| TC_12        | Fetch Invalid Single Cart with ID        | Invalid Cart ID           | Error message and status code 404 						               | 1. Send a GET request to /carts/{cartID} with an invalid cart ID. <br> 2.  Receive an error message.               |
